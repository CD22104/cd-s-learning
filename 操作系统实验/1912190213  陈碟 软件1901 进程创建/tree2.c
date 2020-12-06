#include<stdio.h>
#include<stdlib.h>
#include <unistd.h>
#include<sys/wait.h>
#include<sys/types.h>


int main()
{
  pid_t pid1,pid2,pid3,pid4,pid5;
  signal(SIGCHLD,SIG_IGN);
  while((pid1=fork())==-1);
  if(pid1==0)
    {
	while((pid3=fork())==-1);
		if(pid3==0)

		{
		printf("d,pid=%d,ppid=%d\n",getpid(),getppid());
		
		}
		else
		{ 
		printf("b,pid=%d,ppid=%d\n",getpid(),getppid());
		}
     }
  else 
  {
     while((pid2=fork())==-1);
     if(pid2==0)  
       { 
	while((pid4=fork())==-1);
		if(pid4==0)

		{sleep(0.5);
		printf("e,pid=%d,ppid=%d\n",getpid(),getppid());
		
		}
		else
		{
			while((pid5=fork())==-1);
			if(pid5==0)

			{
			printf("f,pid=%d,ppid=%d\n",getpid(),getppid());
		
			}
			else
			{ sleep(1);
			printf("c,pid=%d,ppid=%d\n",getpid(),getppid());
		 	}
		}
	}
     else 
       { 
	sleep(1.5);
        printf("a,pid=%d,ppid=%d\n",getpid(),getppid());
	}
  }

}
