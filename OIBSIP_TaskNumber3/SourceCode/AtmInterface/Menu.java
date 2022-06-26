package AtmInterface;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class Menu extends Account {
    Scanner sc = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("#,##,##,##,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(100, 1234);
                data.put(101, 4567);
                data.put(102, 7890);
                data.put(103, 9123);

                System.out.println("Welcome to the ATM Interface");
                System.out.println("Enter your account Number");
                setAccountNumber(sc.nextInt());

                System.out.print("Enter your PIN Number: ");
                setPinNumber(sc.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid Character(s). Only Numbers." + "\n");
                x = 2;
            }
            int cn = getAccountNumber();
            int pn = getPinNumber();
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            } else
                System.out.println("\n" + "****Wrong Account Number or Pin Number****" + "\n");
        } while (x == 1);
    }

    public void getAccountType() {
        System.out.println("Select the Account you Want to Access: ");
        System.out.println(" Press 1 - Current Account");
        System.out.println(" Press 2 - Saving Account");
        System.out.println(" Press 3 - Exit");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank You for using this ATM");
                break;

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("Current Account: ");
        System.out.println(" Press 1 - View Balance");
        System.out.println(" Press 2 - Withdraw Funds");
        System.out.println(" Press 3 - Deposit Funds");
        System.out.println(" Press 4 - Exit");
        System.out.print("Choice: ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Current Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank You for using this ATM");
                break;

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getChecking();
        }
    }

    public void getSaving() {
        System.out.println("Saving Account: ");
        System.out.println(" Press 1 - View Balance");
        System.out.println(" Press 2 - Withdraw Funds");
        System.out.println(" Press 3 - Deposit Funds");
        System.out.println(" Press 4 - Exit");
        System.out.println("Choice: ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;

            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank You for using this ATM");
                break;

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getSaving();
        }
    }
}