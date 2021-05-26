package JavaAssessment.Inheritance;

class Parent
{
    int a=100;
    public void display()
    {
        System.out.println("Display in parent A: "+a);
    }
}

class Child extends Parent
{
    int b=200;

    public void display()
    {
        System.out.println("Display in parent B: "+b);
    }
}

public class MethodCalling
{
    public static void main(String args[])
    {
        Parent obj = new Child();
        obj.display();
    }
}
