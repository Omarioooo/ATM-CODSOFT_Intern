import java.util.*;
public class Main {
    static Scanner input = new Scanner(System.in);
    static double Balance = 5000.0;  // Start with default balance
    public static void main(String[] args) {
        boolean stillInAccount = true;   // A flag for the loop....
        System.out.println("Hello Sir welcome to our ATM system...");
        do {
            int choice = menu();
            switch (choice) {
                case 1:
                    // Check Balance
                    System.out.println("Your current balance is: $" + Balance);
                    break;

                case 2:
                    // Deposit
                    System.out.print("Enter deposit amount: $");
                    try {
                        double depositAmount = input.nextDouble();
                        deposit(depositAmount);
                    }catch (InputMismatchException e){
                        System.out.println("Invalid input please try again..");
                        input.next();
                    }
                    break;

                case 3:
                    // Withdraw
                    System.out.print("Enter withdrawal amount: $");
                    try {
                        double withdrawAmount = input.nextDouble();
                        withdraw(withdrawAmount);
                    }catch (InputMismatchException e){
                        System.out.println("Invalid input please try again..");
                        input.next();
                    }
                    break;

                case 4:
                    // Exit
                    stillInAccount = false;
                    System.out.println("Thank you for using our ATM system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }while(stillInAccount);

    }

    public static void deposit(double money){
        if(money<0){
            System.out.println("Invalid amount of money please try again... , your balance is still : "+Balance);
        }else{
            Balance+=money;
            System.out.println("you have successfully deposited : "+money+" your balance is became : "+Balance);
        }
    }

    public static void withdraw(double money) {
        if (money <= Balance) {
            Balance -= money;
            System.out.println("you have successfully withdraw :" + money + " your balance is became :" + Balance);
        } else {
            System.out.println("You balance is not enough...");
        }
    }

    public static int menu(){
        int choice = 1;
        System.out.println("");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");

        try {
            choice = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("valid input...checking your balance ");
            input.next();
        }

        return choice;
    }

}