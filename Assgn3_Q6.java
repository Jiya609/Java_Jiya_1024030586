import java.util.Scanner;

class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String msg) {
        super(msg);
    }
}

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String msg) {
        super(msg);
    }
}

class AccountLockedException extends Exception {
    public AccountLockedException(String msg) {
        super(msg);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String correctUsername = "admin";
        String correctPassword = "1234";

        int attempts = 0;
        int maxAttempts = 3;

        try {

            while (attempts < maxAttempts) {

                try {

                    System.out.print("Username: ");
                    String username = sc.nextLine();

                    System.out.print("Password: ");
                    String password = sc.nextLine();

                    if (!username.equals(correctUsername)) {

                        throw new InvalidUsernameException(
                            "Invalid username."
                        );
                    }

                    if (!password.equals(correctPassword)) {

                        throw new InvalidPasswordException(
                            "Invalid password."
                        );
                    }

                    System.out.println(
                        "Login successful!"
                    );

                    break;
                }

                catch (InvalidUsernameException e) {

                    attempts++;

                    System.out.println(
                        e.getMessage()
                    );
                }

                catch (InvalidPasswordException e) {

                    attempts++;

                    System.out.println(
                        e.getMessage()
                    );
                }
            }

            if (attempts == maxAttempts) {

                throw new AccountLockedException(
                    "Account locked after 3 failed attempts."
                );
            }

        }

        catch (AccountLockedException e) {

            System.out.println(
                e.getMessage()
            );
        }

        finally {

            System.out.println(
                "Login system terminated."
            );

            sc.close();
        }
    }
}
