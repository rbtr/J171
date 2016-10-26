package csc171.project02.view;

import csc171.project02.controller.BankController;
import csc171.project02.model.AbstractAccount;
import csc171.project02.model.AbstractTransaction;
import csc171.project02.model.BankFactory;
import sun.misc.ExtensionInstallationException;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * Cli.java
 * Version 1.0
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015
 * Assignment: PROJECT 02
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen
 * Last Revised: 4/11/15
 */

/**
 * A commandline interface the BankController. This UI still satisfies the MVC design pattern, it just is text instead
 * of graphics based.
 */
public class Cli {

    private final BankController bankController;

    private Scanner scanner;

    private Cli(BankController bankController) {
        this.bankController = bankController;
        scanner = new Scanner(System.in);
    }

    /**
     * This method creates an instance of the Cli Object with an empty Bank Object in the BankController
     * @return A Cli Object with a BankController that has an empty Bank attached to it
     */
    public static Cli withEmptyBank() {
        return new Cli(new BankController(BankFactory.getEmptyBank()));
    }

    /**
     * This method creates an instance of the Cli Object with a populated Bank Object (from the BankFactory)
     * @return A Cli Object with a BankController that has a populated Bank attached to it
     */
    public static Cli withPopulatedBank() {
        return new Cli(new BankController(BankFactory.getBank()));
    }

    /**
     * This method runs the interaction layer for the BankController
     */
    public void interact() {
        System.out.print("Welcome to " + bankController.getBankName() + "\n");
        System.out.print("\nWould you like to\n1) Log in\n2) Create an account\n:>");

        int selection = -1;
        while (selection < 1 || selection > 2) {
            try {
                selection = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid selection\n:>");
            }
        }

        switch (selection) {
            case 1:
                logIn();
                break;
            case 2:
                createCustomer();
                break;
        }

        boolean advance;

        do {
            printAccounts();

            System.out.print("\nWould you like to:\n1) View accounts\n2) Create a new account\n:>");

            selection = -1;
            while (selection < 1 || selection > 2) {
                try {
                    selection = scanner.nextInt();
                } catch (Exception e) {
                    System.out.print("Invalid selection\n:>");
                }
            }

            switch (selection) {
                case (2):
                    createAccount();
                    break;
            }

            System.out.print("\nSelect an account to continue: \n#");

            long accountNumber = -1;
            while (accountNumber < 0) {
                try {
                    accountNumber = scanner.nextLong();
                    bankController.selectAccount(accountNumber);
                } catch (Exception e) {
                    System.out.print("Invalid account number. \nEnter account #");
                }
            }

            printAccount();
            System.out.print("\nWhat would you like to do?\n1) Deposit\n2) Withdraw\n:>");

            selection = -1;
            while (selection < 1 || selection > 2) {
                try {
                    selection = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid selection\n:>");
                }
            }

            switch (selection) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
            }

            System.out.print("Transaction History:\n");
            printTransactionHistory();

            System.out.print("\nContinue?\n(yes/n)\n:>");

            try {
                advance = isInputYes(scanner.next());
            } catch (Exception e) {
                advance = false;
            }
        } while (advance);
    }

    private boolean isInputYes(String s) {
        return s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes");
    }

    private void printTransactionHistory() {
        for (AbstractTransaction t : bankController.getAccountTransactions().values()) {
            System.out.println(t);
        }
    }

    private void withdraw() {
        double value = -1;
        do {
            System.out.print("Enter withdrawal amount\n$");
            try {
                value = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid amount\n:>");
            }
        } while (value < 0);

        bankController.withdraw(value);
    }

    private void deposit() {
        double value = -1;
        do {
            System.out.print("Enter deposit amount\n$");
            try {
                value = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid amount\n:>$");
            }
        } while (value < 0);

        bankController.deposit(value);
    }

    private void createAccount() {
        System.out.print("Select an account type\n1) Checking\n2) Savings\n:>");
        int selection = -1;
        while (selection < 1 || selection > 2) {
            try {
                selection = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid selection\n:>");
            }
        }
        switch (selection) {
            case 1:
                bankController.createCheckingAccount();
                break;
            case 2:
                System.out.print("Enter an interest rate:\n%");
                float rate = -1;

                while (rate < 0) {
                    try {
                        rate = scanner.nextFloat();
                    } catch (Exception e) {
                        System.out.print("Invalid interest rate. Enter an interest rate:\n%");
                    }
                }

                bankController.createSavingsAccount(rate);
        }

        printAccounts();
    }

    private void printAccount() {
        System.out.println("Selected Account");
        System.out.println(bankController.getAccount());
    }

    private void printAccounts() {
        System.out.println("Accounts");
        for (AbstractAccount a : bankController.getAccounts().values()) {
            System.out.println(a);
        }
    }

    private void logIn() {
        System.out.println("Log in to " + bankController.getBankName());


        boolean valid = false;
        while (!valid) {

            // I'M SORRY

            try {
                System.out.print("Username: ");
                String username = scanner.next();

                try {
                    System.out.print("Password: ");
                    String password = scanner.next();

                    try {
                        bankController.authenticateCustomer(username, password);
                        valid = true;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } catch (Exception e) {
                    System.out.println("Invalid password\n:>");
                }

            } catch (Exception e) {
                System.out.println("Invalid username\n:>");
            }
        }
    }

    private void createCustomer() {
        System.out.print("Provide some information to create your account");
        System.out.print("\nEnter first name: ");
        String firstname = scanner.next();

        System.out.print("\nEnter last name: ");
        String lastname = scanner.next();

        System.out.print("\nEnter birth year: ");
        int birthyear = -1;
        while (birthyear < 0) {
            try {
                birthyear = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid year, try again\n:>");
            }
        }

        System.out.print("\nEnter birth month: ");
        int birthmonth = -1;
        while (birthmonth < 0) {
            try {
                birthmonth = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid month, try again\n:>");
            }
        }

        System.out.print("\nEnter birth day: ");
        int birthday = -1;
        while (birthday < 0) {
            try {
                birthday = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid day, try again\n:>");
            }
        }

        Calendar calendar = Calendar.getInstance();
        calendar.set(birthyear, birthmonth + 1, birthday);
        Date birthdate = calendar.getTime();

        System.out.print("\nEnter your desired username: ");
        String username = scanner.next();

        System.out.print("\nEnter your password: ");
        String password = scanner.next();

        boolean valid = false;
        while (!valid) {
            try {
                bankController.createCustomer(username, password, firstname, lastname, birthdate);
                valid = true;
            } catch (IllegalStateException e) {
                System.out.println(e);
                System.out.print("Enter username: ");
                username = scanner.next();
            }
        }
    }
}
