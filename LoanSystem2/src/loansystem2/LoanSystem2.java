// Group 3 Final Project
package loansystem2;


import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

public class LoanSystem2 {

    static PrintWriter outputFile = null;
    public static void main(String[] args) {
        LoanCalculations calc = new LoanCalculations();
        ReadFiles rf = new ReadFiles();
        ArrayList<Customer> customers = null;
        try {
           outputFile = new PrintWriter("src\\loansystem2\\Report.txt");
           customers = rf.readCustomerData();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        ArrayList<LoanRequest> loans = null;
        System.out.println("Loan Report:");
        outputFile.println("Loan Report:");//Starting here, we write to the Report.txt file as we print the information in the output window.
        for (int i = 0; i < customers.size(); i++)
        {
            System.out.println("");
            outputFile.println("");

            System.out.println("Customer Name: " + customers.get(i).getName());
            outputFile.println("Customer Name: " + customers.get(i).getName());
            
            System.out.println("Checking Account #: " + customers.get(i).getChecking().getAccountNumber());
            outputFile.println("Checking Account #: " + customers.get(i).getChecking().getAccountNumber());
            
            System.out.println("Savings Account #: " + customers.get(i).getSavings().getAccountNumber());
            outputFile.println("Savings Account #: " + customers.get(i).getSavings().getAccountNumber());
            
            System.out.println("DOB: " + customers.get(i).getdOB ());
            outputFile.println("DOB: " + customers.get(i).getdOB ());
            
            System.out.println("SSN: " + customers.get(i).getsSN ());
            outputFile.println("SSN: " + customers.get(i).getsSN ());
            
            System.out.println("Credit Score: " + customers.get(i).getCreditScore ());
            outputFile.println("Credit Score: " + customers.get(i).getCreditScore ());
            
            System.out.println("");
            
            loans = customers.get(i).getLoans();
            for(int j = 0; j < loans.size(); j++)
            {
                System.out.println("Loan Type " + (j+1) + ": " + loans.get(j).getLoanType());
                outputFile.println("Loan Type " + (j+1) + ": " + loans.get(j).getLoanType());
                
                System.out.println("Loan Length " + (j+1) + ": " + loans.get(j).getLoanLength());
                outputFile.println("Loan Length " + (j+1) + ": " + loans.get(j).getLoanLength());
                
                System.out.println("Loan Amount " + (j+1) + ": " + loans.get(j).getLoanAmount());
                outputFile.println("Loan Amount " + (j+1) + ": " + loans.get(j).getLoanAmount());
                
                System.out.print("Monthly Payments:");
                outputFile.print("Monthly Payments:");
                calc.checkRequest(i,loans.get(j).getLoanAmount(),loans.get(j).getLoanType(),loans.get(j).getLoanLength());
                System.out.println("");
                outputFile.println("");

            }
            System.out.println("");
            outputFile.println("");
        }
        outputFile.close();
          
          
    }
    
}
