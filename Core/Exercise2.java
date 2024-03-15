
public class Exercise2 {
    public static void main(String[] args) {
        try {
            divideByZero();
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception caught: " + e.getMessage());
        }
    }
    // using throw 
    public static void divideByZero() {
        int numerator = 10;
        int denominator = 0;

        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        int result = numerator / denominator;
        System.out.println("Result: " + result);
    }
    // using throws
    public static void divideByZeroWithThrows() throws ArithmeticException {
        int numerator = 10;
        int denominator = 0;

        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        int result = numerator / denominator;
        System.out.println("Result: " + result);
    }
}
