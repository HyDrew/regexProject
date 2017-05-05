// Group 3 Final Project
package loansystem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReadFiles {

    public ReadFiles() {

    }

    public ArrayList<Customer> readCustomerData() throws FileNotFoundException {
        String name = null;
        String sSN = null;
        int creditScore = -1;
        String dOB = null;
        double salary = -1;
        String accountNumber = "";
        double accountBalance = -1;
        CheckingAcc checking = null;
        SavingsAcc savings = null;
        String loanType = null;
        double loanAmount = -1;
        String loanLength = null;
        Customer customer = null;

        String inputFile = "src\\loansystem2\\CustomerFile.txt";
        ArrayList<Customer> customers = new ArrayList();
        
        File customerFile = new File(inputFile);
        Scanner in = new Scanner(customerFile);
        String line = "";

        while (in.hasNext()) {
            line = in.nextLine();
            if (line.contains("Customer:")) {
                String[] nameArray = line.split(" ");
                name = nameArray[1] + " " + nameArray[2];
            }

            if (line.contains("SSN:")) {
                String[] ssnArray = line.split(" ");
                sSN = ssnArray[1];
            }

            if (line.contains("DOB:")) {
                String[] dobArray = line.split(" ");
                dOB = dobArray[1];
            }

            if (line.contains("Credit Score:")) {
                String[] scoreArray = line.split(" ");
                creditScore = Integer.parseInt(scoreArray[2]);
            }

            if (line.contains("Salary:")) {
                String[] salaryArray = line.split(" ");
                salary = Double.parseDouble(salaryArray[1]);
            }

            if (line.contains("Checking Account:")) {
                String[] checkingArray = line.split(" ");
                accountNumber = checkingArray[2];
            }
            
            if (line.contains("Checking Account Balance:")) {
                String[] checkingArray = line.split(" ");
                accountBalance = Double.parseDouble(checkingArray[3]);
                checking = new CheckingAcc(accountNumber, accountBalance);
            }
            
            if (line.contains("Savings Account:")) {
                String[] savingsArray = line.split(" ");
                accountNumber = savingsArray[2];
            }
            
            if (line.contains("Savings Account Balance:")) {
                String[] savingsArray = line.split(" ");
                accountBalance = Double.parseDouble(savingsArray[3]);
                savings = new SavingsAcc(accountNumber, accountBalance);
                customer = new Customer(name, sSN, creditScore, dOB, salary, savings, checking);
                customers.add(customer);
            }
            
            if (line.contains("Loan Type:")) {
                String[] loanArray = line.split(" ");  
                loanLength = loanArray[2];
                loanType = loanArray[3];
            }
            
            if (line.contains("Loan Amount:")){
                String[] loanArray = line.split(" ");
                loanAmount = Double.parseDouble(loanArray[2]);
                LoanRequest loanRequest = new LoanRequest(loanLength, loanType, loanAmount);
                customer.addLoan(loanRequest);
            }
        }

        in.close();
        return customers;
    }

}
