#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<string.h>
int main(int argc,char * argv[])
{
   int i=0;
   int len;
   if(argc<=1) {printf("%d\n",argc);return 0;}
   char * s =argv[1];
   printf("启动后台加密进程,进程号:%d\n",getpid());
   len = strlen(s);//取长度
   for(i=0;i<len;i++){
         if((s[i]>64 && s[i]<91) || (s[i]>96 && s[i]<123)){ //字符串加密
             if(s[i]=='z') s[i]='A';
             else if(s[i]=='Z') s[i]='a';
             else s[i] = s[i] + 1;             
         }
         else s[i] = s[i];
    }
    printf("加密后:%s\n",s);   
    return 1;  
}
