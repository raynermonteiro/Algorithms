package JavaAssessment.Inheritance;

class A
{
    void m1() throws Exception {
        System.out.println("In m1 A");
    }
}
class B extends A
{
    void m1()
    {
        System.out.println("In m1 B");
    }
    void m2()
    {
        System.out.println("In m2 B");
    }
}


public class InheritanceParentChild {

    public static void main(String[] args) throws Exception {
        A a = new B();
        //a.m2(); Not possible since m2 belongs to B
        a.m1();
    }
}

