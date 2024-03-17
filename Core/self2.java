import java.util.Scanner;

public class self2 {

    public static int div(int numerator, int denominator) throws ArithmeticException{
        if(denominator==0){
            throw new ArithmeticException("Cannot divide by zero exception from method div");
        }
        return numerator/denominator;
    }
    public static void main(String[] args) {
        System.out.println("Enter two numbers : ");
        Scanner sc=new Scanner(
            System.in
        );

        int a=sc.nextInt();

        int b=sc.nextInt();
        int c = -1;
        try{
            c=a/b;
        }
        catch(ArithmeticException e){
            System.out.println("Is it possible to divide by zero?");
        }
        catch(Exception e){
            System.out.println("Any other exception");
        }
        finally{
            sc.close();
            if(c != -1){
                System.out.println("The value of division is " + c);
            }
            else System.out.println("The value of c is not defined");
        }

        try {
            int result=div(a,b);
            System.out.println("Result is " + result);
        } catch (Exception e) {
            System.out.println("Exception called after function execution from main");
        }
    }
}
