package Hello;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class test2 {
    public static void main(String[] args) {

            Scanner cin = new Scanner(System.in);
            String a = cin.next();

            String[] already = new String[1000];

            int len = a.length();
            int num=0;
            for(int i=1;i<=len;i++) { //i代表着目的字串的长度
                String goal = "";
                String m = "";
                for(int j=0;j<len;j++) { //j用于遍历得出每一个目的字串
                    if(j+i<=len) {
                        m = a.substring(j, j+i); //提取出需要计算出现次数的字串
                        int state = 0;
                        for(int n=0;n<num;n++) {
                            if(m.compareTo(already[n])==0) {
                                state=1;
                                break;
                            }
                        }
                        if(state==0) {
                            goal = m;
                            if(num<1000) {
                                already[num] = m;
                                num++;
                                //开始遍历整个字符串,不断得到子串
                                String b = "";
                                int count = 0;
                                for(int k=0;k<len;k++) {
                                    if(k+i<=len) {
                                        b = a.substring(k, k+i);
                                        if(goal.compareTo(b)==0) {
                                            count++;
                                        }
                                    }
                                }
                                if(goal.compareTo("")!=0 && count>0) {
                                    System.out.println("字串"+goal+"在字符串"+a+"中出现了"+count+"次");
                                }
                                goal="";
                                count = 0;
                            }
                        }

                        //goal=a.substring(j, j+i);
                        //System.out.println(goal);
                    }

                }
            }
        }

//        Scanner sc=new Scanner(System.in);
//        String line1=sc.nextLine();
//        HashMap<String,Integer> strcnt = new HashMap<String,Integer>();
//        HashMap<String,Integer> cnt = new HashMap<String,Integer>();
//        int len;
//        for(len=1;len<=line1.length();len++)
//        {
//            for(int j=0;j<line1.length();j++)
//            {
//                String sub=line1.substring(j,j+len);
//                if(strcnt.containsKey(sub))
//                {
//                    int newcnt=strcnt.get(sub)+1;
//                    strcnt.put(sub,newcnt);
//                }else{
//                    strcnt.put(sub,1);
//                    cnt.put(len,cnt.get(len)+1);
//                }
//            }
//        }
//        Set<Integer> keyset=cnt.keySet();
//        Iterator<Integer> iter=keyset.iterator();
//        while(iter.hasNext())
//        {
//
//        }


    }



