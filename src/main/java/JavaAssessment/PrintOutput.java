package JavaAssessment;

public class PrintOutput
{
    public void Pass(String arg)
    {
        arg = "You've got it in you!!";
    }
    public static void main (String[] args)
    {
        PrintOutput test = new PrintOutput();
        String Push = null;
        if(Push!="null")
            System.out.print("Passed");
        else
            System.out.print("Failed");
        test.Pass(Push);
        System.out.print(Push);
    }
}
