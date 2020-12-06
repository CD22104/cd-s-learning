#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<unistd.h>
#include<time.h>
#include<string.h>
#include <sys/types.h>
#include<sys/syscall.h>
/*����ʵ��ģ��ʵ�ֲ���ϵͳ�н��̵����㷨,ģ������ڲ�ͬʱ�̵�������*/
#define PNUM  5 //���̵�����
#define TIMER 10 //��ʱ��,�CPU����ʱ��
#define SLICE 2//��ת�㷨��ʱ��Ƭ
int timenow = 0;     //��ǰʱ��
typedef struct node {
	int pid;   //���̺�
	int priority;//�������ȼ�,1~3,����ԽС���ȼ�Խ��
	int arrival; //����ʱ��
	int burst;  //CPU����ʱ��
	int rest;  //ʣ��ʱ��
	char state;//����״̬,'N'�½�,'R'����,'W'�ȴ�CPU(����),'T'��ֹ
	struct node* next;
}PCB;

int gantt[TIMER * PNUM] = { 0 }; //��һ��gantt�����¼���ȹ���,ÿ��ʱ�̵��ȵĽ��̺� 

PCB* job;//������ҵ������,��ͷ�ڵ�(Ϊ�򻯱��)
PCB* ready = NULL; //���̾�������,����ͷ�ڵ�
PCB* tail = NULL;  //��¼�������е�β�ڵ�
PCB* run = NULL;//���������еĽ���,����ͷ���
PCB* finish = NULL;//�Ѿ������ĳ���,����ͷ���

void InitialJob()
{
	int i = 0;
	PCB* p, * tail;
	job = (PCB*)malloc(sizeof(PCB));//����ͷ�ڵ�,������������
	job->next = NULL;
	tail = job;

	for (i = 0; i < PNUM; i++)
	{
		p = (PCB*)malloc(sizeof(PCB));//�����½ڵ�(�½���)
		p->pid = i + 1;
		p->priority = rand() % 3 + 1;//����������ȼ�:1~3
		p->arrival = rand() % TIMER;//������ɵ���ʱ��0-9,(Ԥ�Ƶ���������е�ʱ��) 
		p->burst = rand() % TIMER + 1;//�������CPU����ʱ��:1~10;(��������ʱ��)
		p->rest = p->burst;
		p->state = 'N';//��ʼ�����̵�״̬Ϊ'�½�'
		p->next = NULL;
		tail->next = p;
		tail = p;  //��ͷ���
	}
}
void DisplayPCB(PCB* pcb) //��ʾ����
{
	struct node* p = pcb;
	if (pcb == NULL) { printf("XXXXXX\n"); return; }
	printf("���̺� ���ȼ� ����ʱ�� ����ʱ�� ʣ��ʱ�� ����״̬\n");
	do {
		printf("P%-3d\t", p->pid);
		printf("%3d\t", p->priority);
		printf("%3d\t", p->arrival);
		printf("%3d\t", p->burst);
		printf("%3d\t", p->rest);
		printf("%3c\t", p->state);
		printf("\n");
		p = p->next;
	} while (p != NULL);
}

void DisplayGantt() //��ʾ��������
{
	int i = 0;
	for (i = 0; i < timenow; i++)
	{
		if (gantt[i] == 0) printf("����,");
		else
			printf("P%d,", gantt[i]);
	}
	printf("\n");
}

/*ע:������תʱ��,�ȴ�ʱ������Ӧʱ��ĸ�������:
  �ڿγ̲̽�<����ϵͳ�����7��>��(P141),��������ʱ���Ǵӽ��̵����ʱ�俪ʼ��.
  �ڸ����̲�<�ִ�����ϵͳ��4��>��(P89),��������ʱ��ʱ�ӽ����ύ��ʱ��(0ʱ��)��ʼ��.
  �����ձ����ǰһ�����,�������Կγ̲̽��еĽ���Ϊ׼������ʱ��.
*/
void DisplayTime() //��ʾ��תʱ��t,�ȴ�ʱ��w����Ӧʱ��r
{
	int t = 0, w = 0, r = 0;
	float t_avg = 0, w_avg = 0, r_avg = 0;
	int i, j;
	PCB* p; //��p����finish����,���ҽ���Pi�ĵ���ʱ��,���øú���ʱ���н��̶��ѷ���finish����
	if (finish == NULL) { return; }
	printf("���̺�    ��תʱ��    �ȴ�ʱ��    ��Ӧʱ��\n");
	for (i = 1; i <= PNUM; i++)
	{
		p = finish;
		while (p->pid != i) p = p->next;
		j = 0;
		while (gantt[j] != i) j++; //������������,�����Pi����Ӧʱ��
		r = j;  //��Ӧʱ��
		t = j + 1;
		for (j = r + 1; j < timenow; j++) //��������,����תʱ��
		{
			if (i == gantt[j]) t = j + 1;
		}//����ʱ��
		r = r - p->arrival;  //��Ӧʱ��=��Ӧʱ��-����ʱ��
		t = t - p->arrival; //��תʱ��=����ʱ��-����ʱ��
		w = t - p->burst; //�ȴ�ʱ��=��תʱ��-����ʱ��
		r_avg += (float)r / PNUM; //ƽ����Ӧʱ��
		w_avg += (float)w / PNUM;  //ƽ���ȴ�ʱ��
		t_avg += (float)t / PNUM;   //ƽ����תʱ��

		printf("P%d       %4d       %4d       %4d\n", i, t, w, r);
	}
	printf("ƽ����תʱ��:%.2f,ƽ���ȴ�ʱ��%.2f,ƽ����Ӧʱ��%.2f\n", t_avg, w_avg, r_avg);
}
void ReadyQueue(char* algo, int t) //������ҵ���й����������,algo:�㷨,t:��ǰʱ��
{
	struct node* jpre, * jcur, * rpre, * rcur;
	int j, r, a = 0;
	if (strcmp(algo, "FCFS") == 0 || strcmp(algo, "RR") == 0)//FCFS��RR�ľ������еĹ��췽ʽ��ͬ
		a = 0;
	else if (strcmp(algo, "SJF") == 0)  //����ռSJF
		a = 1;
	else if (strcmp(algo, "SRTF") == 0)  //��ռʽSJF,���ʣ��ʱ������
		a = 2;
	else if (strcmp(algo, "Priority") == 0 || strcmp(algo, "NonPriority") == 0)//��ռ�ͷ���ռ���ȼ� 
		a = 3;
	else { printf("ReadyQueue()�������ò�������!\n"); exit(0); }
	if (job->next == NULL) { printf("��ҵ����Ϊ��!\n"); return; }
	jpre = job;
	jcur = job->next;
	while (jcur != NULL) //������ҵ������ѡ���ѵ������,�������ҵ���������������,ֱ����ҵ����Ϊ�� 	  
	{
		if (jcur->arrival <= t) //�����ǰʱ�̽����Ѿ�����,������뵽�������еĺ���λ��
		{
			printf("P%d����.\n", jcur->pid);
			jpre->next = jcur->next;  //��jcur����ҵ�����Ƴ�
			jcur->state = 'W';//������״̬����Ϊ����
			if (ready == NULL) //��������Ϊ��
			{
				jcur->next = NULL; ready = jcur; tail = ready;
			}
			else  //�������в�Ϊ��,������������,��jcur���뵽����λ��
			{
				rpre = ready;
				rcur = ready;
				switch (a) { //�����������в��Ҳ����
				case 0:    //FCFS,RR.���ݵ���ʱ��arrival���Һ��ʲ����
					while ((rcur != NULL) && (jcur->arrival >= rcur->arrival))
					{
						rpre = rcur; rcur = rcur->next;
					}
					break;
				case 1: //SJF,��������ʱ��burst���Һ��ʲ���� 
					while ((rcur != NULL) && (jcur->burst >= rcur->burst))
					{
						rpre = rcur; rcur = rcur->next;
					}
					break;
				case 2:  //STRF,����ʣ��ʱ��rest���Һ��ʲ����
					while ((rcur != NULL) && (jcur->rest >= rcur->rest))
					{
						rpre = rcur; rcur = rcur->next;
					}
					break;
				case 3:  //Priority, Non-Priority,�������ȼ����Һ��ʲ����
					while ((rcur != NULL) && (jcur->priority >= rcur->priority))
					{
						rpre = rcur; rcur = rcur->next;
					}

					break;
				default: break;
				}
				if (rcur == NULL)// ������ھ�������β��
				{
					jcur->next = NULL;
					rpre->next = jcur;
					tail = jcur;
				}
				else if (rcur == ready) //�������ͷ��
				{
					jcur->next = rcur;
					ready = jcur;
				}
				else //���뵽rpre��rcur֮��
				{
					jcur->next = rcur;
					rpre->next = jcur;
				}
			}
			jcur = jpre->next;  //��һ����ҵ
		}
		else   //��ǰ��ҵδ�ﵽ
		{
			jpre = jcur; jcur = jcur->next;
		} //��һ����ҵ
	}
	printf("\n��ҵ����:\n");
	DisplayPCB(job->next);
}
void FCFS()
{
	timenow = 0;
	while (true) {
		printf("\n��ǰʱ��:%d\n", timenow);
		ReadyQueue("FCFS", timenow);//ˢ�¾�������
		printf("��������:\n");
		DisplayPCB(ready);
		if (job->next == NULL && ready == NULL && run == NULL) break; //û�н���,����ѭ��   
		if (ready != NULL || run != NULL) //�н��̴��ھ�����������״̬
		{
			if (run == NULL)//��CPU����
			{
				run = ready;      //��CPU�����ready���еĵ�һ������
				ready = ready->next;
				run->next = NULL;
				printf("\nP%d�����ȳ������CPU!\n", run->pid);
			}
			run->rest--;    //�޸Ľ���PCB
			run->state = 'R';
			printf("\nP%d��������.......\n", run->pid);
			printf("���н���:\n");
			DisplayPCB(run);
			gantt[timenow] = run->pid; //��¼��ǰʱ�̵��Ƚ��̵�ID��
			if (run->rest == 0)
			{
				printf("\nP%d����!\n", run->pid);
				run->state = 'T';
				run->next = finish;   //����ɵĽڵ���뵽finish��ͷ���,��һ��
				finish = run;
				run = NULL;
				printf("�������̶���:\n");
				DisplayPCB(finish);
			}
		}
		timenow++; //��һʱ�̼���ɨ����ҵ����  
	}
}
void RR(int slice)  //ʱ��Ƭ��Ϊ����
{
	timenow = 0;
	int count = 0; //ʱ��Ƭ������new
	while (true) {
		printf("\n��ǰʱ��:%d\n", timenow);
		ReadyQueue("RR", timenow);//ˢ�¾�������
		printf("��������:\n");
		DisplayPCB(ready);

		if (job->next == NULL && ready == NULL && run == NULL) { break; } //û�н���,����ѭ�� 
		if (ready == NULL) { tail = NULL; }
		if (tail != NULL) printf("��������β�ڵ�:P%d\n", tail->pid);
		if (ready != NULL || run != NULL) //�н��̴��ھ�����������״̬
		{
			//�������RR���ȵĴ���
			if (run == NULL)//��CPU����
			{
				run = ready;      //��CPU�����ready���еĵ�һ������
				ready = ready->next;
				run->next = NULL;
				printf("\nP%d�����ȳ������CPU!\n", run->pid);
			}
			run->rest--;    //�޸Ľ���PCB
			run->state = 'R';
			printf("\nP%d��������.......\n", run->pid);
			printf("���н���:\n");
			DisplayPCB(run);
			gantt[timenow] = run->pid; //��¼��ǰʱ�̵��Ƚ��̵�ID��
			count++;//�Ѿ�����һ��ʱ��Ƭʱcount==slice
			if (run->rest == 0)
			{
				count = 0;//new
				printf("\nP%d����!\n", run->pid);
				run->state = 'T';
				run->next = finish;   //����ɵĽڵ���뵽finish��ͷ���,��һ��
				finish = run;
				run = NULL;
				printf("�������̶���:\n");
				DisplayPCB(finish);
			}
			if (count == slice)//new
			{
				run->state = 'R';
				count = 0;
				if (ready == NULL)
				{
					ready = run;
					tail = run;
					tail->next = NULL;
					run = run->next;
				}
				else
				{
					tail->next = run;
					tail = run;
					tail->next = NULL;
					run = run->next;
				}
			}
		}
		timenow++; //��һʱ�̼���ɨ����ҵ����  
	}
}
void SJF() //�κ����,�����������ʱ���ն���ҵ����
{
	timenow = 0;
	while (true) {
		printf("\n��ǰʱ��:%d\n", timenow);
		ReadyQueue("SJF", timenow);//ˢ�¾�������
		printf("��������:\n");
		DisplayPCB(ready);
		if (job->next == NULL && ready == NULL && run == NULL) break; //û�н���,����ѭ��   
		if (ready != NULL || run != NULL) //�н��̴��ھ�����������״̬
		{
			if (run == NULL)//��CPU����
			{
				run = ready;      //��CPU�����ready���еĵ�һ������
				ready = ready->next;
				run->next = NULL;
				printf("\nP%d�����ȳ������CPU!\n", run->pid);
			}
			run->rest--;    //�޸Ľ���PCB
			run->state = 'R';
			printf("\nP%d��������.......\n", run->pid);
			printf("���н���:\n");
			DisplayPCB(run);
			gantt[timenow] = run->pid; //��¼��ǰʱ�̵��Ƚ��̵�ID��
			if (run->rest == 0)
			{
				printf("\nP%d����!\n", run->pid);
				run->state = 'T';
				run->next = finish;   //����ɵĽڵ���뵽finish��ͷ���,��һ��
				finish = run;
				run = NULL;
				printf("�������̶���:\n");
				DisplayPCB(finish);
			}
		}
		timenow++; //��һʱ�̼���ɨ����ҵ����  
	}
}
void SRTF() //����ʣ��ʱ������,�����������ʱ�������ʣ��ʱ����ҵ����
{

}
void NonPriority() //����ռ���ȼ�
{
	timenow = 0;
	while (true) {
		printf("\n��ǰʱ��:%d\n", timenow);
		ReadyQueue("NonPriority", timenow);//ˢ�¾�������
		printf("��������:\n");
		DisplayPCB(ready);
		if (job->next == NULL && ready == NULL && run == NULL) break; //û�н���,����ѭ��   
		if (ready != NULL || run != NULL) //�н��̴��ھ�����������״̬
		{
			if (run == NULL)//��CPU����
			{
				run = ready;      //��CPU�����ready���еĵ�һ������
				ready = ready->next;
				run->next = NULL;
				printf("\nP%d�����ȳ������CPU!\n", run->pid);
			}
			run->rest--;    //�޸Ľ���PCB
			run->state = 'R';
			printf("\nP%d��������.......\n", run->pid);
			printf("���н���:\n");
			DisplayPCB(run);
			gantt[timenow] = run->pid; //��¼��ǰʱ�̵��Ƚ��̵�ID��
			if (run->rest == 0)
			{
				printf("\nP%d����!\n", run->pid);
				run->state = 'T';
				run->next = finish;   //����ɵĽڵ���뵽finish��ͷ���,��һ��
				finish = run;
				run = NULL;
				printf("�������̶���:\n");
				DisplayPCB(finish);
			}
		}
		timenow++; //��һʱ�̼���ɨ����ҵ����  
	}

}
void Priority()//��ռʽ���ȼ�
{

}
int main()
{
	srand((int)time(NULL)); //���������
//srand(0); 
	InitialJob();
	DisplayPCB(job->next);
	RR(SLICE);
	//FCFS();
	//SJF();
	//SRTF();
	//NonPriority();
	Priority();
	DisplayGantt();
	DisplayTime();
	return EXIT_SUCCESS;;
}
