public class Main {

    public static void main(String[] args) {

        // ArithmeticException
        try {
            int a = 10;
            int b = 0;

            System.out.println(a / b);
        }
        catch (ArithmeticException e) {
            System.out.println("ArithmeticException: Cannot divide by zero");
        }

        // NullPointerException
        try {
            String name = null;

            System.out.println(name.length());
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException: Object is null");
        }

        // ArrayIndexOutOfBoundsException
        try {
            int[] numbers = {10, 20, 30};

            System.out.println(numbers[5]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(
                "ArrayIndexOutOfBoundsException: Invalid array index"
            );
        }

        // NumberFormatException
        try {
            String str = "abc";

            int number = Integer.parseInt(str);

            System.out.println(number);
        }
        catch (NumberFormatException e) {
            System.out.println(
                "NumberFormatException: Invalid number format"
            );
        }

        System.out.println("Program completed.");
    }
}
