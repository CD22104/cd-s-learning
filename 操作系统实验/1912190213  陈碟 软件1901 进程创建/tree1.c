#include<stdio.h>
#include<stdlib.h>
#include <unistd.h>
#include<sys/wait.h>
#include<sys/types.h>

int main()
{
  pid_t pid1,pid2,pid3;
  while((pid1=fork())==-1);
  if(pid1==0) //p1
    {
        while((pid2=fork())==-1);
	if(pid2==0)
	{
		while((pid3=fork())==-1);
		if(pid3==0)

		{wait(NULL);
		printf("d,pid=%d,ppid=%d\n",getpid(),getppid());
		
		}
		else
		{ wait(NULL);
		printf("c,pid=%d,ppid=%d\n",getpid(),getppid());
		
		}
	}
	else
	{   wait(NULL);
	 printf("b,pid=%d,ppid=%d\n",getpid(),getppid());
	
	} 
     }
  else  //p
  {wait(NULL);
    printf("a,pid=%d,ppid=%d\n",getpid(),getppid());
	
  }

}
