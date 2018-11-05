package ee.nkloga;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Atm {

    private static final String MENU_NUMBER = "menuNumber";
    private static final String ID_NUMBER = "idNumber";
    private static final int NUMBER_OF_ACCOUNTS = 10;

    public static BufferedReader createBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private static String readNextLine(BufferedReader in) throws IOException {
        return in.readLine();
    }

    private static int convertStringToInt(String valueString) throws NumberFormatException {
        return Integer.parseInt(valueString);
    }

    private static double convertStringToDouble(String valueString) throws NumberFormatException {
        return Double.parseDouble(valueString);
    }

    public static int userIntInput(BufferedReader in, String type) {
        int min = 0, max = 0;
        if (type.equals(MENU_NUMBER)) {
            min = 1;
            max = 4;
        } else if (type.equals(ID_NUMBER)) {
            min = 0;
            max = NUMBER_OF_ACCOUNTS;
        }
        while (true) { // we end the loop by a return, not by a condition.
            try {
                String valueString = readNextLine(in);
                int intValue = convertStringToInt(valueString);
                if (intValue < min || intValue > max) {
                    throw new NumberFormatException();
                } else {
                    return intValue;
                }
            } catch (IOException ex) {
                System.err.println("The number has not been entered");
            } catch (NumberFormatException ex) {
                System.err.println("Please enter a number");
            }
        }
    }

    public static double getDoubleFromUser(BufferedReader in) {
        //TODO, find a way yo merge with userIntInput
        while (true) { // we end the loop by a return, not by a condition.
            try {
                String valueString = readNextLine(in);
                return convertStringToDouble(valueString);
            } catch (IOException ex) {
                System.err.println("Error: The number has not been entered!");
            } catch (NumberFormatException ex) {
                System.err.println("Error: Please enter a number!");
            }
        }
    }

    public static void main(String[] args) throws IOException {

        ArrayList<Account> listOfAccounts = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_ACCOUNTS; i++) {
            listOfAccounts.add(new Account(i, 100.0));
            listOfAccounts.get(i).setAnnualInterestRate(7.5);
        }

        listOfAccounts.set(0, new Account(1122, 20000));
        listOfAccounts.get(0).setAnnualInterestRate(4.5);
        System.out.println(listOfAccounts.get(0));
        listOfAccounts.get(0).withdraw(2500);
        listOfAccounts.get(0).deposit(3000);
        System.out.println(listOfAccounts.get(0));

        BufferedReader reader = createBufferedReader();
        System.out.println("Enter the account id: ");
        int userInputID = userIntInput(reader, ID_NUMBER);
        System.out.println("The id has been accepted");

        System.out.println(listOfAccounts.get(userInputID));
        boolean menuIteration = true;
        while (menuIteration) {
            System.out.println("Enter 1 to view your current balance, " +
                    "2 for withdrawing money, " +
                    "3 for depositing money or 4 for exiting the main menu.");
            Integer userInputNumber = userIntInput(reader, MENU_NUMBER);
            switch (userInputNumber) {
                case 1:
                    System.out.println(listOfAccounts.get(userInputID));
                    break;
                case 2:
                    System.out.println("Enter the withdraw amount: ");
                    double userInputWithdrawAmount = getDoubleFromUser(reader);
                    listOfAccounts.get(userInputID).withdraw(userInputWithdrawAmount);
                    break;
                case 3:
                    System.out.println("Enter the deposit value: ");
                    double userInputDepositValue = getDoubleFromUser(reader);
                    listOfAccounts.get(userInputID).deposit(userInputDepositValue);
                    break;
                case 4:
                    menuIteration = false;
                    System.out.println("In order to exit, enter your account id again: ");
                    userIntInput(reader, ID_NUMBER);
                    reader.close();
                    break;
                default:
                    System.out.println("Default output"); // not sure why / how should I use default in this context
            }
        }
    }
}
