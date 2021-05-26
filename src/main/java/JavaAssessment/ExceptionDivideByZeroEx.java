package JavaAssessment;

public class ExceptionDivideByZeroEx {
    public static void main(String args[]) {
        double c=-1;
        try{
            c= 4/0;
        }catch (Exception e) {
            System.err.print("Exception");
        } finally {
             System.err.print("Finally ");
        }
    }
}
