package JavaAssessment.Inheritance;


import java.io.IOException;

class A1
{
    void m1() throws ArrayIndexOutOfBoundsException
    {
        System.out.println("In m1 A");
    }
}
class B1 extends A1
{
    void m1() throws IndexOutOfBoundsException
    {
        System.out.println("In m1 B");
    }
}

class A2
{
    void m1() throws IOException
    {
        System.out.println("In m1 A");
    }
}
class B2 extends A2
{
    void m1() //throws Exception this is not possible as it throws a checked exception of higher precission.
    {
        System.out.println("In m1 B");
    }
}

public class ExceptionHandling {
    public static void main(String[] args) {
        A1 a=new B1();
        /*
        *This will work fine as ArrayIndexOutOfBoundsException and
        *IndexOutOfBoundsException are Runtime exceptions and there is no rule for runtime exceptions while
        *method overriding.
        */
        a.m1();
    }
}
