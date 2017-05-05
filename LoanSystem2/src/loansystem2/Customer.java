// Group 3 Final Project
package loansystem2;

import java.util.ArrayList;

public class Customer {

    private String name;
    private String sSN;
    private int creditScore;
    private String dOB;
    private double salary;
    private CheckingAcc checking;
    private SavingsAcc savings;
    private ArrayList<LoanRequest> loanRequests = new ArrayList(); 

    public Customer(String name, String sSN, int creditScore, String dOB, double salary, SavingsAcc savingsAcc, CheckingAcc checkingAcc) {
        this.name = name;
        this.sSN = sSN;
        this.creditScore = creditScore;
        this.dOB = dOB;
        this.salary = salary;
        this.checking = checkingAcc;
        this.savings = savingsAcc;
    }
    
    public void addLoan(LoanRequest loan){
       loanRequests.add(loan);
    }

    public ArrayList<LoanRequest> getLoans(){
        return this.loanRequests;
    }
    public void generateLoanReport() {

        System.out.println(getName());
    }

    public String getName() {
        return name;
    }

    /**
     * @return the sSN
     */
    public String getsSN() {
        return sSN;
    }

    /**
     * @return the creditScore
     */
    public int getCreditScore() {
        return creditScore;
    }

    /**
     * @return the dOB
     */
    public String getdOB() {
        return dOB;
    }

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @return the checking
     */
    public CheckingAcc getChecking() {
        return checking;
    }

    /**
     * @return the savings
     */
    public SavingsAcc getSavings() {
        return savings;
    }
}
