package hello;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
			Scanner input=new Scanner(System.in);
			Class class1=new Class();
			Student s1=new Student();
			Student s2=new Student();
			Student s3=new Student();
			Student s4=new Student();
			Student s5=new Student();
			class1.classname="Ò»°à";
			class1.classstudent[1]=s1;
			class1.classstudent[2]=s2;
			class1.classstudent[3]=s3;
			class1.classstudent[4]=s4;
			class1.classstudent[5]=s5;
			int i,j,max,min;
			int sum=0;
			System.out.println(class1.classname);
			for(i=1;i<=5;i++)
			{
				System.out.println("name£º");
				class1.classstudent[i].name=input.nextLine();
				System.out.println("age: ");
				class1.classstudent[i].age=input.nextInt();
				System.out.println("sex: ");
				class1.classstudent[i].sex=input.nextLine();
				System.out.println("grades: ");
				for(j=1;j<=6;j++)
				{
					class1.classstudent[i].grade[j]=input.nextInt();
				}
			}
			for(i=1;i<=6;i++) 
			{
				max=1;
				min=1;
			System.out.println("grade"+i+"average:");
				for(j=1;j<=5;j++)
				{
					sum+=class1.classstudent[j].grade[i];
					if(class1.classstudent[j].grade[i]>class1.classstudent[max].grade[i])
						max=j;
					if(class1.classstudent[j].grade[i]<class1.classstudent[min].grade[i])
						min=j;
				}
				float average=0.0f;
				average=sum/5;
				System.out.println(average);
				System.out.println("best:"+class1.classstudent[max].name);
				System.out.println("best:"+class1.classstudent[min].name);
				sum=0;
			}
			for(i=1;i<=5;i++)
			{	sum=0;
				for(j=1;j<=6;j++)
				{
					sum=sum+class1.classstudent[i].grade[j];
				}
				class1.classstudent[i].sum=sum;
			}
			for(i=1;i<=4;i++)
			{
				for(j=i;j<=4-i;j++)
				{
					if(class1.classstudent[j].sum<class1.classstudent[j+1].sum)
					{
						Student temp;
						temp=class1.classstudent[j];
						class1.classstudent[j]=class1.classstudent[j+1];
						class1.classstudent[j+1]=temp;
					}
				}
			}
			for(i=1;i<=5;i++)
			{
				System.out.println(class1.classstudent[i].name+class1.classstudent[i].sum);
			}
		}
	
}
