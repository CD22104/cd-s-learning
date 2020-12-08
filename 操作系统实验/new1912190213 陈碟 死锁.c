#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <unistd.h>
#include <sys/types.h>
#include<sys/syscall.h>

#define PNUM 5
#define RNUM 3
int allocation[PNUM][RNUM] = { {0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0} };
int max[PNUM][RNUM] = { {7,5,3},{3,2,2},{9,0,2},{2,2,2},{4,3,3} };
int need[PNUM][RNUM] = { {7,5,3},{3,2,2},{9,0,2},{2,2,2},{4,3,3} };
int available[RNUM] = { 10,5,7 };

void display()
{
	printf("The resource state now:\n");
	printf("%-10s\t%-10s\t%-10s\t%-10s\t%-10s\n", "process", "  max", "allocation", "  need", "available");
	int i;
	for (i = 0; i < PNUM; i++)
	{
		int j = 0;
		printf("P%-9d\t", i);
		for (j = 0; j < RNUM; j++)
			printf("%2d ", max[i][j]);
		printf("\t");
		for (j = 0; j < RNUM; j++)
			printf("%2d ", allocation[i][j]);
		printf("\t");
		for (j = 0; j < RNUM; j++)
			printf("%2d ", need[i][j]);
		printf("\t");
		if (i == 0)
			for (j = 0; j < RNUM; j++)
				printf("%2d ", available[j]);
		printf("\n");
	}
}

void rollback(int req[], int id)
{
	int j = 0;
	for (j = 0; j < RNUM; j++)  //rollback if a process's request is not allowed
	{
		allocation[id][j] -= req[j];
		need[id][j] += req[j];
		available[j] += req[j];
	}
}

void request(int req[], int id) //resource request
{
	int j = 0;
	///////update state





}

bool issafe()
{
	int work[RNUM];
	bool finish[PNUM];
	int i = 0, j = 0;
	for (i = 0; i < PNUM; i++)
		finish[i] = false;
	for (j = 0; j < RNUM; j++)
		work[j] = available[j];
	///////is safe state?
	int n = 0;
	while (n < 5)
	{
		if (finish[n] == true) n++;
		else
		{
			for (j = 0; j < 3; j++)
			{
				if (need[n][j] > work[j]) { break; }
			}
			if (j < 3) n++;
			if (j >= 3)
			{
				finish[n] = true;
				for (j = 0; j < 3; j++)
				{
					work[j] += allocation[n][j];
				}
				n = 0;
			}
		}
	}
	int y = 1;
	for (i = 0; i < 5; i++)
	{
		if (finish[i] == false)
		{
			y = 0; break;
		}
	}

	if (y == 1) return true;
	else return false;


}

bool banker()
{
	int request[RNUM] = { 0 };
	int i = 0, j = 0, id;
	while (true)
	{
		printf("Please input a process id :\n P");
		scanf("%d", &id);
		if (id < 0 || id >= PNUM) { printf("invalid process!\n"); break; }
		printf("Please input request array for P%d :\n", id);
		for (j = 0; j < RNUM; j++)
		{
			scanf("%d", &request[j]);
			if (request[j] < 0) { printf("invalid request!\n"); return false; }
		}

		//////////banker algorithm

		int f = 1;
		for (j = 0; j < RNUM; j++)
		{
			if (request[j] > need[id][j])
			{
				f = 0;
				break;
			}
		}
		if (f == 1)
		{
			for (j = 0; j < RNUM; j++)
			{
				if (request[j] > available[j])
				{
					f = 0;
					break;
				}
			}
		}

		if (f == 1)
		{
			for (j = 0; j < RNUM; j++)
			{
				allocation[id][j] += request[j];
				need[id][j] -= request[j];
				available[j] -= request[j];
			}
		}
		display();
		if (issafe() == true) printf("The system is safe now!\n");
		else
		{
			printf("The system is not safe\n");
			rollback(request, id);
		}

	}
}


int main()
{
	pid_t pid0, pid1, pid2, pid3, pid4;
	int i;
	while ((pid0 = vfork()) == -1);
	if (pid0 == 0) //p0 allocation
	{
		printf("P0 is allocated<0,1,0>\n");
		allocation[0][0] = 0;
		allocation[0][1] = 1;
		allocation[0][2] = 0;

		for (i = 0; i < RNUM; i++) {
			need[0][i] = max[0][i] - allocation[0][i];
			available[i] -= allocation[0][i];
		}
		exit(0);
	}
	else //main process
	{
		while ((pid1 = vfork()) == -1);
		if (pid1 == 0) //p1 allocation
		{
			printf("P1 is allocated<2,0,0>\n");
			allocation[1][0] = 2;
			allocation[1][1] = 0;
			allocation[1][2] = 0;

			for (i = 0; i < RNUM; i++) {
				need[1][i] = max[1][i] - allocation[1][i];
				available[i] -= allocation[1][i];
			}
			exit(0);
		}
		else //main process
		{
			while ((pid2 = vfork()) == -1);
			if (pid2 == 0) //p2 allocation
			{
				printf("P2 is allocated<3,0,2>\n");
				allocation[2][0] = 3;
				allocation[2][1] = 0;
				allocation[2][2] = 2;

				for (i = 0; i < RNUM; i++) {
					need[2][i] = max[2][i] - allocation[2][i];
					available[i] -= allocation[2][i];
				}
				exit(0);
			}
			else //main process
			{
				while ((pid3 = vfork()) == -1);
				if (pid3 == 0) //p3 allocation
				{
					printf("P3 is allocated<2,1,1>\n");
					allocation[3][0] = 2;
					allocation[3][1] = 1;
					allocation[3][2] = 1;
					int i;
					for (i = 0; i < RNUM; i++) {
						need[3][i] = max[3][i] - allocation[3][i];
						available[i] -= allocation[3][i];
					}
					exit(0);
				}
				else //main process
				{
					while ((pid4 = vfork()) == -1);
					if (pid4 == 0) //p3 allocation
					{
						printf("P4 is allocated<0,0,2>\n");
						allocation[4][0] = 0;
						allocation[4][1] = 0;
						allocation[4][2] = 2;

						for (i = 0; i < RNUM; i++) {
							need[4][i] = max[4][i] - allocation[4][i];
							available[i] -= allocation[4][i];
						}
						exit(0);
					}
					else //main process
					{
						display();
						if (issafe() == true) printf("The system is safe now!\n");
						else printf("The system is not safe\n");

						//////test banker()
						banker();
						exit(0);
					}
				}
			}
		}
	}

	return EXIT_SUCCESS;;
}

