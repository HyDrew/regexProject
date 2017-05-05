// Group 3 Final Project
package loansystem2;

import java.io.*;
import java.util.*;
import java.lang.Double;
import java.util.regex.*;
public class LoanRequest {
    private String loanLength;
    private String loanType;
    private double loanAmount;
    
    public LoanRequest(String loanLength, String loanType, double loanAmount) {
        this.loanAmount = loanAmount;
        this.loanType = loanType;
        this.loanLength = loanLength;
    }
    
    public LoanRequest(String loanType, double loanAmount) {
        this.loanAmount = loanAmount;
        this.loanLength = loanLength;
    }

    /**
     * @return the loanLength
     */
    public String getLoanLength() {
        return loanLength;
    }

    /**
     * @return the loanType
     */
    public String getLoanType() {
        return loanType;
    }

    /**
     * @return the loanAmount
     */
    public double getLoanAmount() {
        return loanAmount;
    }
    public static ArrayList<Double> masterList = new ArrayList<Double>();
    private static double primeRate;
    private double interestRate;
    private static String rateTable;
    private static final String algo = "(\\t)(\\d+).(\\d+)[%]";
    
    
    public static void populateInterestTable(String algo, String rateTable)
    {
        Pattern checkInterest = Pattern.compile(algo);
        Matcher matchInterest = checkInterest.matcher(rateTable);
        
        while(matchInterest.find())
        {
           String temp = rateTable.substring(matchInterest.start(), (matchInterest.end()-1));
           Scanner temp1 = new Scanner(temp);
           double temp2 = temp1.nextDouble();
           LoanRequest.addMasterList(temp2);
        }   
    }
    
    public static void setRateTable(String inputFile) throws FileNotFoundException
    {
        File table = new File(inputFile);
        Scanner in = new Scanner(table);
        LoanRequest.rateTable = in.useDelimiter("\\A").next();
        in.close();
    }
    
    public static String getRateTable()
    {
        return rateTable;
    }
    
    public void setInterestRate()
    {
        
    }
    
    public static double getPrimeRate()
    {
        return primeRate;
    }
    
    public static void setPrimeRate(String inputFile) throws FileNotFoundException
    {
        File prime = new File(inputFile);
        try (Scanner in = new Scanner(prime)) {

            while(in.hasNext())
            {
               
                if(in.next().equals("Rate"))
                {
                    String fedRate = in.next();
                    fedRate = fedRate.substring(0, fedRate.length() -1);
                    LoanRequest.primeRate = Double.parseDouble(fedRate);
                }
                
            }
            in.close();
        }
    }
    
    public void setLoanType()
    {
        this.loanType = getLoanType();
    }
    
    
    public static String getAlgo()
    {
        return algo;
    }
    
    public static void addMasterList(double addValue)
    {
        LoanRequest.masterList.add(addValue);
    }
    
    public static void printMasterList()
    {
        for(int i=0; i<LoanRequest.masterList.size(); i++)
        {
            System.out.println("element "+i+" = "+LoanRequest.masterList.get(i));
        }
    }
    
 
}
