import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Type exit to end"); // opening message
        System.out.print("Calculate: ");
        System.out.println();
        String userIn = input.nextLine(); // get user input

        Calculator calc = new Calculator(); // creating a calculator object
        while (!userIn.equals("exit")){ // Keeps getting user input until its user quits
            calc.Calculator(userIn);
            System.out.print("Calculate: ");
            System.out.println();
            userIn = input.nextLine();
        }

    }
}
