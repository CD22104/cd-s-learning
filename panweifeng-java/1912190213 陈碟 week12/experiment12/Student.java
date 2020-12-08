package experiment12;

import oracle.jrockit.jfr.StringConstantPool;

import java.util.Comparator;

public abstract class Student implements Comparable{
    public String xm;
    public String xb;
    public int age;

    public String getXm() {
        return xm;
    }

    public String getXb() {
        return xb;
    }

    public int getAge() {
        return age;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static Comparator<Student> NameComparator = new Comparator<Student>() {

        public int compare(Student s1, Student s2) {
            String name1 = s1.getXm().toUpperCase();
            String name2 = s2.getXm().toUpperCase();

            // 正序排列
            return name1.compareTo(name2);

            // 逆序排列
            //return StudentName2.compareTo(StudentName1);
        }};
}
