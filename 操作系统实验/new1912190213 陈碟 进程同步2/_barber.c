#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<unistd.h>
#include<string.h>
#include<pthread.h>
#include<semaphore.h>
/*模拟理发师问题,说明:
  代码中的sleep语句或者usleep均为模拟真实场景而设置,与理发师问题的解决方案无关.
  代码中有些统计数据和显示也非必须,只为验证程序的正确性而设计.
  这不是理发师问题的唯一解决方案.
  代码仅为教学使用,旨在让学生更好的掌握信号量解决进程同步的一般方法.
  程序运行过程的随机性是因为线程的调度,请同学们分析程序结果,理解线程(进程)调度过程.
  代码:by zhujx*/
#define N 10 //椅子的数量
#define BNUM 1   //理发师线程数
#define CNUM 20 //顾客线程数
sem_t cus,bar,mutex;
int waiting=0; //等待中的顾客数
int count =0; //统计理发师服务的顾客数
int leave=0; //因没有座位而直接离开的顾客数
void *barber() //baber
{
   while(true){  //理发师线程一直运行
       sem_wait(&mutex);
     if(waiting ==0) { 
         sem_post(&mutex);
         //没有顾客，理发师睡觉，等待cus信号
      printf("********没有顾客,理发师正在睡觉!*********\n");
      sem_wait(&cus);
     }
     else 
    { 
         sem_post(&mutex);

         sem_post(&bar);//唤醒一位顾客开始理发

         sem_wait(&mutex);
         waiting--;
         count++;//统计人数
     printf("理发师开始理发,已服务人数:%d\n",count);    
     printf("一位顾客正在理发,等待理发的顾客数: waiting=%d\n",waiting);
     usleep(10000); //非必要语句,控制理发速度,模拟理发师的效率,程序执行过程与该值密切相关.实际也是如此,不是吗?
     printf("该顾客理发结束!\n");
     sem_post(&mutex);
     }     
  }
}

void *customer(void *arg) //customer
{
    sem_wait(&mutex);
     printf("第 %ld 号顾客进店...\n",(unsigned long )arg);
     if(waiting==N) {//没有空位，顾客离开.注意与生产者消费者问题的区别
         leave++;//统计离开人数
         printf("没有座位,第 %ld 号顾客离开!离开人数:%d\n",(unsigned long )arg,leave);    
         sem_post(&mutex);
     } 
     else{
         waiting++;//统计等待人数
         printf("第 %ld 号顾客坐下等待理发:waiting=%d\n",(unsigned long )arg,waiting);
         if (waiting == 1)   //如果是第一位顾客，唤醒理发师
         {
             sem_post(&mutex);
             sem_post(&cus);//唤醒理发师
             printf("理发师被唤醒,正在准备理发!\n");
         }
         else
         {
             sem_post(&mutex);
             sem_wait(&bar);//等待理发师 
         }
         
     }
     usleep(10);  //非必要语句,控制客人离开速度  
}

void main()
{
   int res,i;
   pthread_t barber_thread[BNUM],customer_thread[CNUM];
   //初始化信号量
   sem_init(&mutex, 0, 1);
   sem_init(&cus, 0, 1);
   sem_init(&bar, 0, 1);
 
   for(i=0;i<BNUM;i++){
      
      res=pthread_create(&barber_thread[i],NULL,barber,NULL);
      if(res!=0){perror("Thread creation failure!\n");}
   }
   for(i=0;i<CNUM;i++){
    usleep(100);//非必要语句,控制消费者进店速度,模拟实际场景中的顾客流量.
    res=pthread_create(&customer_thread[i],NULL,customer,(void*)(unsigned long)(i));
    if(res!=0){perror("Thread creation failure!\n");}
   }
    for(i=0;i<CNUM;i++){ //进程等待所有消费者线程结束
         pthread_join(customer_thread[i],NULL);
	}
    sleep(1);
    printf("理发师服务顾客总数:%d\n",count);
    printf("直接离开的顾客总数:%d\n",leave);
    printf("\n");
}






