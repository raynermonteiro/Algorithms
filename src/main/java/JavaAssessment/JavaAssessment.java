package JavaAssessment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaAssessment
{
    private int anInt = 0;
    public int a = 0;
    public static void main(String args[])
    {
        /*int result = 0;

        Boolean b1 = new Boolean("TRUE");
        Boolean b2 = new Boolean("true");
        Boolean b3 = new Boolean("tRuE");
        Boolean b4 = new Boolean("false");

        if (b1 == b2)result = 1;
        if (b1.equals(b2))result = result + 10;
        if (b2 == b4)result = result + 100;
        if (b2.equals(b4))result = result + 1000;
        if (b2.equals(b3))result = result + 10000;
        System.out.println(result);*/

        //2
        /*int x = 0x80000000;
        System.out.print(x + " and ");
        x = x >>> 31;
        System.out.println(x);*/

        //3
        //test(1);

        //4
        /*FileOutputStream out = null;
        try
        {
            out = new FileOutputStream("output.out");
            out.write(125486);
        }
        catch(IOException io)
        {
            System.out.println("Error");
        }
        finally
        {
            //out.close();
        }*/

        //5
        /*foo(false  , false);*/

        //6
       /* String __$1____str="These Variables!";
        String $s=__$1___str;
        int a=31,b=a++;
        int @q=12;
        if ($s=="These Variables")
            System.out.println("True");
        else
            System.out.println("False");*/


        //7
        /*List<String> list = new ArrayList<String>();
        list.add("DoSelect");
        list.add("InMobi");
        list.add("CampusHash");
        list.add("mKhoj");
        list.add("Microsoft");

        System.out.println("Original: " + list);

        Collections.rotate(list, -2);

        System.out.println("Rotated: " + list);*/

        //8
        /*double a = 354.03;
        int  b = 256;
        byte c = (byte) a;
        byte d = (byte) b;
        System.out.println(c + "\t"  + d);*/

        //9
        int A1[] = {1, 2, 3};
        int A2[] = {1, 2, 3};
        if (A1.equals(A2))
            System.out.println("Same");
        else
            System.out.println("Not same");
    }

    public static void test(int x)
    {
        int odd = 1;
        if(true) //if()odd
        {
            System.out.println("odd");
        }
        else
        {
            System.out.println("even");

        }
    }

    public static void foo( boolean a, boolean b)
    {
        if( a )
        {
            System.out.println("A");
        }
        else if(a && b)
        {
            System.out.println( "A && B");
        }
        else
        {
            if ( !b )
            {
                System.out.println( "notB") ;
            }
            else
            {
                System.out.println( "ELSE" ) ;
            }
        }
    }



}

/*
@Entity
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private List<Contact> contacts;
}*/
