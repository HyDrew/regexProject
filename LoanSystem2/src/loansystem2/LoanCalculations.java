// Group 3 Final Project
package loansystem2;

import java.io.*;
import java.util.ArrayList;
import static loansystem2.LoanSystem2.outputFile;
import java.util.*;

public class LoanCalculations 
{
    private boolean approved = true;
    private double monthlyPayment = -1;
    private double overallPrice = -1;
    private double armMonthlyPayment = -1;
    ArrayList<Customer> customers = null;
    private double[] interestRates = new double[30];
    
    public LoanCalculations()//Populates LoanRequest table and prime rate
    {
     ReadFiles rf = new ReadFiles();
        try {
           this.customers = rf.readCustomerData();
           LoanRequest.setRateTable("src\\loansystem2\\GigCityRate.txt");
           LoanRequest.populateInterestTable(LoanRequest.getAlgo(), LoanRequest.getRateTable());
           LoanRequest.setPrimeRate("src\\loansystem2\\FederalReserve.txt");
                   
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        for(int i=0;i<=29;i++) //Converts masterList rates into calculatable percentages and places them in their respective spots in an array
        {
            interestRates[i]=(((LoanRequest.masterList.get(i)/100)/12)+((LoanRequest.getPrimeRate()/100))/12);
        }
        
    }
    public void mortgage15Yrs(int customer, double amount)
    {
        int switcher = 1;//Determines Credit Score Catagory
        if(customers.get(customer).getCreditScore()<=550)
            switcher=1;
        if(customers.get(customer).getCreditScore()>=551)
            switcher=2;
        if(customers.get(customer).getCreditScore()>=681)
            switcher=3;
        
        
        double savingsAndChecking;//Next line adds customers savings and checkings
        savingsAndChecking=(customers.get(customer).getSavings().getBalance())+(customers.get(customer).getChecking().getBalance());
        double customerSalary = customers.get(customer).getSalary();
        if(savingsAndChecking>=(amount*.035)&&((customers.get(customer).getSalary())>=amount*.22))
            approved=true;//Approves if first if is true
        else if(savingsAndChecking>=(amount*.285)&&((customers.get(customer).getSalary())>=amount*.22))
            approved=true;//Approves if first if is !true and else if is true
        switch(switcher)
        {            
            case 1:
            {
                if(approved=true)
                {   //Calculates Mortgage Payments                                           v adds 1 to interest rates for calculation v            
                    monthlyPayment = (amount*(((interestRates[6])*(Math.pow(interestRates[6]+1,180)))/(Math.pow(interestRates[6]+1,180)-1)));
                    overallPrice = monthlyPayment*180;
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                     System.out.println("Not Approved\n");
                break;
            }
            
            case 2:
            {
                if (approved=true)
                {   //Calculates Mortgage Payments                                           v adds 1 to interest rates for calculation v
                    monthlyPayment = (amount*(((interestRates[7])*(Math.pow(interestRates[7]+1,180)))/(Math.pow(interestRates[7]+1,180)-1)));
                    overallPrice = monthlyPayment*180;
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                     System.out.println("Not Approved\n");
                break;
            }
            
            case 3:
            {
                if (approved=true)
                {   //Calculates Mortgage Payments                                           v adds 1 to interest rates for calculation v
                    monthlyPayment = (amount*(((interestRates[8])*(Math.pow(interestRates[8]+1,180)))/(Math.pow(interestRates[8]+1,180)-1)));
                    overallPrice = monthlyPayment*180;
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                     System.out.println("Not Approved\n");
                break;
            }
        }
    }
    
    public void mortgage20Yrs(int customer, double amount)
    {
        int switcher = 1;
        if(customers.get(customer).getCreditScore()<=550)
            switcher=1;
        if(customers.get(customer).getCreditScore()>=551)
            switcher=2;
        if(customers.get(customer).getCreditScore()>=681)
            switcher=3;
        
        
        double savingsAndChecking;//Next line adds customers savings and checkings
        savingsAndChecking=(customers.get(customer).getSavings().getBalance())+(customers.get(customer).getChecking().getBalance());
        double customerSalary = customers.get(customer).getSalary();
        if(savingsAndChecking>=(amount*.035)&&((customers.get(customer).getSalary())>=amount*.4))
            approved=true;
        else if(savingsAndChecking>=(amount*.285)&&((customers.get(customer).getSalary())>=amount*.22))
            approved=true;
        
        switch(switcher)
        {           
            case 1:
            {
                if(approved=true)
                {   //Calculates Mortgage Payments                                           v adds 1 to interest rates for calculation v
                    monthlyPayment = (amount*(((interestRates[3])*(Math.pow(interestRates[3]+1,240)))/(Math.pow(interestRates[3]+1,240)-1)));
                    overallPrice = monthlyPayment*240;
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                     System.out.println("Not Approved\n");
                break;
            }
            
            case 2:
            {
                if (approved=true)
                {   //Calculates Mortgage Payments                                           v adds 1 to interest rates for calculation v
                    monthlyPayment = (amount*(((interestRates[4])*(Math.pow(interestRates[4]+1,240)))/(Math.pow(interestRates[4]+1,240)-1)));
                    overallPrice = monthlyPayment*240;
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                     System.out.println("Not Approved\n");
                break;
            }
            
            case 3:
            {
                if (approved=true)
                {   //Calculates Mortgage Payments                                           v adds 1 to interest rates for calculation v
                    monthlyPayment = (amount*(((interestRates[5])*(Math.pow(interestRates[5]+1,240)))/(Math.pow(interestRates[5]+1,240)-1)));
                    overallPrice = monthlyPayment*240;
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                     System.out.println("Not Approved\n");
                break;
            }
        }
    }
    
    public void mortgage30Yrs(int customer, double amount)
    {
        int switcher = 1;
        if(customers.get(customer).getCreditScore()<=550)
            switcher=1;
        if(customers.get(customer).getCreditScore()>=551)
            switcher=2;
        if(customers.get(customer).getCreditScore()>=681)
            switcher=3;
        
        
        double savingsAndChecking;//Next line adds customers savings and checkings
        savingsAndChecking=(customers.get(customer).getSavings().getBalance())+(customers.get(customer).getChecking().getBalance());
        double customerSalary = customers.get(customer).getSalary();
        if(savingsAndChecking>=((amount)*.035)&&((customers.get(customer).getSalary())>=(amount)*.4))
            approved=true;
        else if(savingsAndChecking>=(amount*.285)&&((customers.get(customer).getSalary())>=amount*.22))
            approved=true;
        switch(switcher)
        {           
            case 1:
            {
                if(approved=true)                                       
                {   //Calculates Mortgage Payments                                           v adds 1 to interest rates for calculation v
                    monthlyPayment = ((amount)*(((interestRates[0])*(Math.pow(interestRates[0]+1,360)))/(Math.pow(interestRates[0]+1,360)-1)));
                    overallPrice = monthlyPayment*360;
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                     System.out.println("Not Approved\n");
                break;
            }
            
            case 2:
            {
                if (approved=true)                                      
                {   //Calculates Mortgage Payments                                           v adds 1 to interest rates for calculation v
                    monthlyPayment = ((amount)*(((interestRates[1])*(Math.pow(interestRates[1]+1,360)))/(Math.pow(interestRates[1]+1,360)-1)));
                    overallPrice = monthlyPayment*360;
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                     System.out.println("Not Approved\n");
                break;
            }
            
            case 3:
            {
                if (approved=true)                                      
                {   //Calculates Mortgage Payments                                           v adds 1 to interest rates for calculation v
                    monthlyPayment = ((amount)*(((interestRates[2])*(Math.pow(interestRates[2]+1,360)))/(Math.pow(interestRates[2]+1,360)-1)));
                    overallPrice = monthlyPayment*360;  
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                     System.out.println("Not Approved\n");
                
                break;
                
            }
        }
       
    }
    
    public void arm3Yr(int customer, double amount)
    {
        int switcher = 1;
        if(customers.get(customer).getCreditScore()<=550)
            switcher=1;
        if(customers.get(customer).getCreditScore()>=551)
            switcher=2;
        if(customers.get(customer).getCreditScore()>=681)
            switcher=3;
        
        
        double savingsAndChecking;//Next line adds customers savings and checkings
        savingsAndChecking=(customers.get(customer).getSavings().getBalance())+(customers.get(customer).getChecking().getBalance());
        double customerSalary = customers.get(customer).getSalary();
        if(savingsAndChecking>=(amount*.285)&&((customers.get(customer).getSalary())>=amount*.22))
            approved=true;
        switch(switcher)
        {
            case 1:
            {
                if(approved=true)                                          
                {   //Calculates Mortgage Payments                                           v adds 1 to interest rates for calculation v        
                    armMonthlyPayment = (amount*(((interestRates[15])*(Math.pow(interestRates[15]+1,360)))/(Math.pow(interestRates[15]+1,360)-1)));
                    monthlyPayment = (((amount-(armMonthlyPayment*36)))*(((.004)*(Math.pow(1.004,324)))/(Math.pow(1.004,324)-1)));
                    overallPrice = (monthlyPayment*324)+(armMonthlyPayment*36);
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                     System.out.println("Not Approved\n");
                break;
            }
            
            case 2:
            {
                if (approved=true)                                     
                {   //Calculates Mortgage Payments                                           v adds 1 to interest rates for calculation v
                    armMonthlyPayment = (amount*(((interestRates[16])*(Math.pow(interestRates[16]+1,360)))/(Math.pow(interestRates[16]+1,360)-1)));
                    monthlyPayment = (((amount-(armMonthlyPayment*36)))*(((.0026)*(Math.pow(1.0026,324)))/(Math.pow(1.0026,324)-1)));
                    overallPrice = (monthlyPayment*324)+(armMonthlyPayment*36);
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                    System.out.println("Not Approved\n");
                break;
            }
            
            case 3:
            {
                if (approved=true)                                       
                {   //Calculates Mortgage Payments                                           v adds 1 to interest rates for calculation v
                    armMonthlyPayment = (amount*(((interestRates[17])*(Math.pow(interestRates[17]+1,360)))/(Math.pow(interestRates[17]+1,360)-1)));
                    monthlyPayment = ((amount-(armMonthlyPayment*36))*(((.0011)*(Math.pow(1.0011,324)))/(Math.pow(1.0011,324)-1)));
                    overallPrice = (monthlyPayment*324)+(armMonthlyPayment*36);
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                    System.out.println("Not Approved\n");
                break;
            }
        }
    }
    
    public void arm5Yr(int customer, double amount)
    {
        int switcher = 1;
        if(customers.get(customer).getCreditScore()<=550)
            switcher=1;
        if(customers.get(customer).getCreditScore()>=551)
            switcher=2;
        if(customers.get(customer).getCreditScore()>=681)
            switcher=3;
        
        
        double savingsAndChecking;//Next line adds customers savings and checkings
        savingsAndChecking=(customers.get(customer).getSavings().getBalance())+(customers.get(customer).getChecking().getBalance());
        double customerSalary = customers.get(customer).getSalary();
        if(savingsAndChecking>=(amount*.285)&&((customers.get(customer).getSalary())>=amount*.22))
            approved=true;
        switch(switcher)
        {
            case 1:
            {
                if(approved=true)                                         
                {   //Calculates Mortgage Payments                                           v adds 1 to interest rates for calculation v        
                    armMonthlyPayment = (amount*(((interestRates[12])*(Math.pow(interestRates[12]+1,360)))/(Math.pow(interestRates[12]+1,360)-1)));
                    monthlyPayment = (((amount-(armMonthlyPayment*60)))*(((.004)*(Math.pow(1.004,300)))/(Math.pow(1.004,300)-1)));
                    overallPrice = (monthlyPayment*300)+(armMonthlyPayment*60);
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                     System.out.println("Not Approved\n");
                break;
            }
            
            case 2:
            {
                if (approved=true)                                     
                {   //Calculates Mortgage Payments                                           v adds 1 to interest rates for calculation v
                    armMonthlyPayment = (amount*(((interestRates[13])*(Math.pow(interestRates[13]+1,360)))/(Math.pow(interestRates[13]+1,360)-1)));
                    monthlyPayment = (((amount-(armMonthlyPayment*60)))*(((.0026)*(Math.pow(1.0026,300)))/(Math.pow(1.0026,300)-1)));
                    overallPrice = (monthlyPayment*300)+(armMonthlyPayment*60);
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                    System.out.println("Not Approved\n");
                break;
            }
            
            case 3:
            {
                if (approved=true)                                        
                {   //Calculates Mortgage Payments                                           v adds 1 to interest rates for calculation v
                    armMonthlyPayment = (amount*(((interestRates[14])*(Math.pow(interestRates[14]+1,360)))/(Math.pow(interestRates[14]+1,360)-1)));
                    monthlyPayment = ((amount-(armMonthlyPayment*60))*(((.0011)*(Math.pow(1.0011,300)))/(Math.pow(1.0011,300)-1)));
                    overallPrice = (monthlyPayment*300)+(armMonthlyPayment*60);
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                    System.out.println("Not Approved\n");
                break;
            }
        }
    }
    
    public void arm7Yr(int customer, double amount)
    {
        int switcher = 1;
        if(customers.get(customer).getCreditScore()<=550)
            switcher=1;
        if(customers.get(customer).getCreditScore()>=551)
            switcher=2;
        if(customers.get(customer).getCreditScore()>=681)
            switcher=3;
        
        
        double savingsAndChecking;//Next line adds customers savings and checkings
        savingsAndChecking=(customers.get(customer).getSavings().getBalance())+(customers.get(customer).getChecking().getBalance());
        double customerSalary = customers.get(customer).getSalary();
        if(savingsAndChecking>=(amount*.285)&&((customers.get(customer).getSalary())>=amount*.22))
            approved=true;
        switch(switcher)
        {
            case 1:
            {
                if(approved=true)                                          
                {   //Calculates Mortgage Payments                                           v adds 1 to interest rates for calculation v        
                    armMonthlyPayment = (amount*(((interestRates[9])*(Math.pow(interestRates[9]+1,360)))/(Math.pow(interestRates[9]+1,360)-1)));
                    monthlyPayment = (((amount-(armMonthlyPayment*84)))*(((.004)*(Math.pow(1.004,276)))/(Math.pow(1.004,276)-1)));
                    overallPrice = (monthlyPayment*276)+(armMonthlyPayment*84);
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                     System.out.println("Not Approved\n");
                break;
            }
            
            case 2:
            {
                if (approved=true)                                     
                {   //Calculates Mortgage Payments                                           v adds 1 to interest rates for calculation v
                    armMonthlyPayment = (amount*(((interestRates[10])*(Math.pow(interestRates[10]+1,360)))/(Math.pow(interestRates[10]+1,360)-1)));
                    monthlyPayment = (((amount-(armMonthlyPayment*84)))*(((.0026)*(Math.pow(1.0026,276)))/(Math.pow(1.0026,276)-1)));
                    overallPrice = (monthlyPayment*276)+(armMonthlyPayment*84);
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                    System.out.println("Not Approved\n");
                break;
            }
            
            case 3:
            {
                if (approved=true)                                        
                {   //Calculates Mortgage Payments                                           v adds 1 to interest rates for calculation v
                    armMonthlyPayment = (amount*(((interestRates[11])*(Math.pow(interestRates[11]+1,360)))/(Math.pow(interestRates[11]+1,360)-1)));
                    monthlyPayment = ((amount-(armMonthlyPayment*84))*(((.0011)*(Math.pow(1.0011,276)))/(Math.pow(1.0011,276)-1)));
                    overallPrice = (monthlyPayment*276)+(armMonthlyPayment*84);
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                    System.out.println("Not Approved\n");
                break;
            }
        }
    }
    
    public void carLoan36Mo(int customer, double amount)
    {
        int switcher = 1;
        if(customers.get(customer).getCreditScore()<=550)
            switcher=1;
        if(customers.get(customer).getCreditScore()>=551)
            switcher=2;
        if(customers.get(customer).getCreditScore()>=681)
            switcher=3;
        
        
        double savingsAndChecking;//Next line adds customers savings and checkings
        savingsAndChecking=(customers.get(customer).getSavings().getBalance())+(customers.get(customer).getChecking().getBalance());
        double customerSalary = customers.get(customer).getSalary();
        if(savingsAndChecking>=(amount*.285)&&((customers.get(customer).getSalary())>=amount*.22))
            approved=true;
        switch(switcher)
        {
            case 1:
            {
                
                if(approved=true)                                          
                {        
                    monthlyPayment = (amount*(((interestRates[24])*(Math.pow(interestRates[24]+1,36)))/(Math.pow(interestRates[24]+1,36)-1)));
                    overallPrice = monthlyPayment*36;
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                     System.out.println("Not Approved\n");
                break;
            }
            
            case 2:
            {
                if (approved=true)                                     
                {
                    monthlyPayment = (amount*(((interestRates[25])*(Math.pow(interestRates[25]+1,36)))/(Math.pow(interestRates[25]+1,36)-1)));
                    overallPrice = monthlyPayment*36;
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                    System.out.println("Not Approved\n");
                break;
            }
            
            case 3:
            {
                if (approved=true)                                        
                {                  
                    monthlyPayment = (amount*(((interestRates[26])*(Math.pow(interestRates[26]+1,36)))/(Math.pow(interestRates[26]+1,36)-1)));
                    overallPrice = monthlyPayment*36;
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                    System.out.println("Not Approved\n");
                break;
            }
        }
    }
    
    
    public void carLoan48Mo(int customer, double amount)
    {
        int switcher = 1;
        if(customers.get(customer).getCreditScore()<=550)
            switcher=1;
        if(customers.get(customer).getCreditScore()>=551)
            switcher=2;
        if(customers.get(customer).getCreditScore()>=681)
            switcher=3;
        
        
        double savingsAndChecking;//Next line adds customers savings and checkings
        savingsAndChecking=(customers.get(customer).getSavings().getBalance())+(customers.get(customer).getChecking().getBalance());
        double customerSalary = customers.get(customer).getSalary();
        if(savingsAndChecking>=(amount*.035)&&((customers.get(customer).getSalary())>=amount*.4))
            approved=true;
        else if(savingsAndChecking>=(amount*.285)&&((customers.get(customer).getSalary())>=amount*.22))
            approved=true;
        switch(switcher)
        {
            case 1:
            {
                
                if(approved=true)                                          
                {        
                    monthlyPayment = (amount*(((interestRates[21])*(Math.pow(interestRates[21]+1,48)))/(Math.pow(interestRates[21]+1,48)-1)));
                    overallPrice = monthlyPayment*48;
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                     System.out.println("Not Approved\n");
                break;
            }
            
            case 2:
            {
                if (approved=true)                                     
                {
                    monthlyPayment = (amount*(((interestRates[22])*(Math.pow(interestRates[22]+1,48)))/(Math.pow(interestRates[22]+1,48)-1)));
                    overallPrice = monthlyPayment*48;
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                    System.out.println("Not Approved\n");
                break;
            }
            
            case 3:
            {
                if (approved=true)                                        
                {                  
                    monthlyPayment = (amount*(((interestRates[23])*(Math.pow(interestRates[23]+1,48)))/(Math.pow(interestRates[23]+1,48)-1)));
                    overallPrice = monthlyPayment*48;
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                    System.out.println("Not Approved\n");
                break;
            }
        }
    }
    
    public void carLoan60Mo(int customer, double amount)
    {
        int switcher = 1;
        if(customers.get(customer).getCreditScore()<=550)
            switcher=1;
        if(customers.get(customer).getCreditScore()>=551)
            switcher=2;
        if(customers.get(customer).getCreditScore()>=681)
            switcher=3;
        
        
        double savingsAndChecking;//Next line adds customers savings and checkings
        savingsAndChecking=(customers.get(customer).getSavings().getBalance())+(customers.get(customer).getChecking().getBalance());
        double customerSalary = customers.get(customer).getSalary();
        if(savingsAndChecking>=(amount*.035)&&((customers.get(customer).getSalary())>=amount*.4))
            approved=true;
        else if(savingsAndChecking>=(amount*.285)&&((customers.get(customer).getSalary())>=amount*.22))
            approved=true;
        switch(switcher)
        {
            case 1:
            {
                
                if(approved=true)                                          
                {        
                    monthlyPayment = (amount*(((interestRates[18])*(Math.pow(interestRates[18]+1,60)))/(Math.pow(interestRates[18]+1,60)-1)));
                    overallPrice = monthlyPayment*60;
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                     System.out.println("Not Approved\n");
                break;
            }
            
            case 2:
            {
                if (approved=true)                                     
                {
                    monthlyPayment = (amount*(((interestRates[19])*(Math.pow(interestRates[19]+1,60)))/(Math.pow(interestRates[19]+1,60)-1)));
                    overallPrice = monthlyPayment*60;
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                    System.out.println("Not Approved\n");
                break;
            }
            
            case 3:
            {
                if (approved=true)                                        
                {                  
                    monthlyPayment = (amount*(((interestRates[20])*(Math.pow(interestRates[20]+1,60)))/(Math.pow(interestRates[20]+1,60)-1)));
                    overallPrice = monthlyPayment*60;
                    System.out.printf("%7.2f\n",monthlyPayment);
                    System.out.printf("Overall Cost: %7.2f\n",overallPrice);
                    approved=false;
                }
                
                else
                    System.out.println("Not Approved\n");
                break;
            }
        }
    }
    
    
    public void creditCardInterest(int customer, double amount)
    {
        int switcher = 1;
        if(customers.get(customer).getCreditScore()<=550)
            switcher=1;
        if(customers.get(customer).getCreditScore()>=551)
            switcher=2;
        if(customers.get(customer).getCreditScore()>=681)
            switcher=3;
        approved=true;
        
        switch(switcher)
        {
            case 1:
            {
                
                if(approved=true)                                          
                {        
                    monthlyPayment = (((amount*(interestRates[27]*12)/365)*30)+amount);
                    System.out.printf("%7.2f\n",monthlyPayment);                    
                    approved=false;
                }
                
                else
                     System.out.println("Not Approved\n");
                break;
            }
            
            case 2:
            {
                if (approved=true)                                     
                {
                    monthlyPayment =(((amount*(interestRates[28]*12)/365)*30)+amount);                    
                    System.out.printf("%7.2f\n",monthlyPayment);                    
                    approved=false;
                }
                
                else
                    System.out.println("Not Approved\n");
                break;
            }
            
            case 3:
            {
                if (approved=true)                                        
                {                  
                    monthlyPayment =(((amount*(interestRates[29]*12)/365)*30)+amount);                  
                    System.out.printf("%7.2f\n",monthlyPayment);
                    approved=false;
                }
                
                else
                    System.out.println("Not Approved\n");
                break;
            }
        }
    }
    
    public void checkRequest(int i,double loanAmount, String loanType, String loanLength)
    {
        if(loanType.equals("Mortgage")&&loanLength.equals("30yr"))
            mortgage30Yrs(i,loanAmount);
        else if(loanType.equals("Mortgage")&&loanLength.equals("20yr"))
            mortgage20Yrs(i,loanAmount);
        else if(loanType.equals("Mortgage")&&loanLength.equals("15yr"))
            mortgage15Yrs(i,loanAmount);
        else if(loanType.equals("ARM")&&loanLength.equals("7yr"))
            arm7Yr(i,loanAmount);
        else if(loanType.equals("ARM")&&loanLength.equals("5yr"))
            arm5Yr(i,loanAmount);
        else if(loanType.equals("ARM")&&loanLength.equals("3yr"))
            arm3Yr(i,loanAmount);
        else if(loanType.equals("Car")&&loanLength.equals("60mo"))
            carLoan60Mo(i,loanAmount);
        else if(loanType.equals("Car")&&loanLength.equals("48mo"))
            carLoan48Mo(i,loanAmount);
        else if(loanType.equals("Car")&&loanLength.equals("36mo"))
            carLoan36Mo(i,loanAmount);
        else if(loanType.equals("Credit")&&loanLength.equals("null"))
            creditCardInterest(i,loanAmount);
        
    }
    
}
