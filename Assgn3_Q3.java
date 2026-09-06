import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter first number: ");
            double num1 = Double.parseDouble(sc.nextLine());

            System.out.print("Enter second number: ");
            double num2 = Double.parseDouble(sc.nextLine());

            System.out.print("Enter operator (+, -, *, /): ");
            String operator = sc.nextLine();

            double result;

            switch (operator) {

                case "+":
                    result = num1 + num2;
                    break;

                case "-":
                    result = num1 - num2;
                    break;

                case "*":
                    result = num1 * num2;
                    break;

                case "/":

                    if (num2 == 0) {
                        throw new ArithmeticException(
                            "Cannot divide by zero"
                        );
                    }

                    result = num1 / num2;
                    break;

                default:
                    throw new IllegalArgumentException(
                        "Invalid operator"
                    );
            }

            System.out.println("Result = " + result);

        }
        catch (NumberFormatException e) {

            System.out.println(
                "Error: Please enter valid numbers."
            );
        }
        catch (ArithmeticException e) {

            System.out.println(
                "Error: Division by zero is not allowed."
            );
        }
        catch (IllegalArgumentException e) {

            System.out.println(
                "Error: Invalid operator. Use +, -, * or /."
            );
        }
        finally {

            System.out.println("Calculator program ended.");
        }

        sc.close();
    }
}
