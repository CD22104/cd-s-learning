#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<unistd.h>
#include<string.h>
#include<pthread.h>
#include<semaphore.h>
/*模拟读者写者问题,代码编写:2017-2018-1,操作系统--朱继祥
写者优先,设计方案:
    若干个读者和写者共同访问一数组,为了简洁,数组元素初始化为数组下标+1;
    读者线程进行查找,重复N次,根据生成的随机值,遍历数组查找改值;
    写者线程更新数组,重复N次,为了简洁,将数组所有元素+1;
  根据写者优先,程序结果应该如下:
    若有写者在等,读者不能进入临界区,直到所有写者离开;
    若读者先进入临界区,查找线程的返回结果应是更新前数组元素所在的下标(查找值-1);
    若写者先进入临界区,则等最后一个写者更新完数据才能开始查找.
    
其他说明:
  代码中的sleep语句或者usleep均为尽量使并发线程交叉执行而设置.
  代码中有些统计数据和显示语句只为验证程序的正确性而设计.
  代码仅为教学使用,旨在让学生更好的掌握信号量解决进程同步的一般方法.
  程序运行过程的随机性是因为线程的调度,请同学们分析程序结果,理解线程(进程)调度过程.
  */
#define WNUM 2   //写者线程数
#define RNUM 3   //读者线程数
#define BUF_SIZE 20 //数组大小 
#define N 2 //每个写者和读者重复访问临界区的次数
int count=0;  //数组求和
int readcount=0;    //读者的数量
int writecount=0;    //读者的数量
int buffer[BUF_SIZE]={0};

sem_t wrt,rd,mutex1,mutex2; //定义四个信号量,初始化为1
/*wrt表示数据集是否可写,第一个读者都会关闭该信号,最后一个读者打开该信号,写者进入临界区之前测试该信号
  rd表示数据集是否可读,第一个写者关闭该信号,最后一个写者打开该信号,读者进入测试该信号
  mutex1用于读者访问readcount时的互斥 
  mutex2用于写者修改writecount时的互斥
*/
void init() //按升序赋值初始化数组
{
    int i;
    printf("按升序初始化数组!\n");
    for(i=0;i<BUF_SIZE;i++) 
 	buffer[i]=i+1;
}

void display()  
{	printf("输出数组:\n");
	int i;
	for(i=0;i<BUF_SIZE;i++)
          { 
            printf("%3d ",buffer[i]);
            if((i+1)%10==0) printf("\n");
          } 	  
}
void update() //更新数组
{
  int i;
  for(i=0;i<BUF_SIZE;i++) 
    	{
		usleep(100);
         	buffer[i]++;
     	}
}
void *writer(void * arg) //写者线程函数
{
   int n=0;
   while((n++)<N)
  { 
       sem_wait(&mutex2);
       writecount++;
       if (writecount == 1)
           sem_wait(&rd);
       sem_post(&mutex2);
       sem_wait(&wrt);
    	printf("写者%ld开始第%d次更新数组...\n",(unsigned long)arg,n);
    	update();//写者更新数组
     	printf("写者%ld第%d次更新数组完成!\n",(unsigned long)arg,n);
        display();
        sem_post(&wrt);
        sem_wait(&mutex2);
        writecount--;
        if (writecount == 0)
            sem_post(&rd);
        sem_post(&mutex2);
        
    usleep(100);//写者剩余区
   }
}

int search(int value){   //查找
          int i=0;
         while(i<BUF_SIZE&&buffer[i]!=value) {usleep(100);i++;}
         if(i<BUF_SIZE) return i;
         else return -1;
}
void *reader(void * arg){   //读者线程函数
    int n=0;    
    while((n++)<N)
    { 
        sem_wait(&rd);
        sem_post(&rd);
        sem_wait(&mutex1);
        readcount++;
        if (readcount == 1)
        {
            sem_wait(&wrt);
        }   
        sem_post(&mutex1);
        
	    printf("读者%ld第%d次开始访问数组...\n",(unsigned long)arg,n); 
         int value= rand()%BUF_SIZE; //随机生成查找值    	
         printf("读者%ld第%d次查找,查找值:%d\n",(unsigned long)arg,n,value);    	  
    	 int location=search(value);  //读者查找value        
         if(location>=0)  
            printf("读者%ld第%d次查找结束:location=%d!\n",(unsigned long)arg,n,location);
         else  printf("读者%ld第%d次查找结束:查找失败!\n",(unsigned long)arg,n);
         sem_wait(&mutex1);
         readcount--;
         if (readcount == 0)
         {
             sem_post(&wrt);
         }
         sem_post(&mutex1);
    }
}

void main()
{
   int res;
   srand((int)time(NULL));
   pthread_t writer_thread[WNUM],reader_thread[RNUM];//WNUM个写者,RNUM个读者

   sem_init(&mutex1, 0, 1);
   sem_init(&mutex2, 0, 1);
   sem_init(&rd, 0, 1);
   sem_init(&wrt, 0, 1);

   int i=0;
   init(buffer,BUF_SIZE);
   display();
  
      for(i=0;i<RNUM;i++) //创建读者线程
      {
       res=pthread_create(&reader_thread[i],NULL,reader,(void*)(unsigned long)(i)); 
       if(res!=0){perror("Thread creation failure!\n");}
       }
      //usleep(1);//延迟创建写者线程,让读者线程先执行
      for(i=0;i<WNUM;i++)//创建写者线程
      {
       res=pthread_create(&writer_thread[i],NULL,writer,(void*)(unsigned long)(i)); 
       if(res!=0){perror("Thread creation failure!\n");}
       }
       for(i=0;i<RNUM;i++)
       	  pthread_join(reader_thread[i],NULL);
       for(i=0;i<WNUM;i++)
          pthread_join(writer_thread[i],NULL);
      
       printf("所有读者和写者线程结束!\n");   
       display();
       printf("\n");    
}

