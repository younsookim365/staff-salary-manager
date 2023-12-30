package staffsalarymanager;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

/*------------------------------------------------------start------------------------------------------------------*/
//Java application that increases staff salaries
public class StaffSalaryManager {
    
    /*------------------------------------------main method start------------------------------------------*/
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean validInput = false;
            boolean employeeDetailsEntered = false;
            int empNumber = 0;
            String empName = "";
            String empSurname = "";
            double empSalary;
            
            do {
                try {
                    // Get employee details if not entered yet
                    if (!employeeDetailsEntered) {
                        System.out.print("Enter the employee number >> ");
                        empNumber = scanner.nextInt();
                        scanner.nextLine(); 
                        
                        System.out.print("Enter the employee's first name >> ");
                        empName = scanner.nextLine();
                        
                        System.out.print("Enter the employee's surname >> ");
                        empSurname = scanner.nextLine();
                        
                        employeeDetailsEntered = true;
                    }
                    
                    // Get employee salary
                    System.out.print("Enter the employee salary >> ");
                    empSalary = scanner.nextDouble();
                    
                    // Create Details object with entered information
                    Details employee = new Details(empNumber, empName, empSurname, empSalary);
                    
                    // Print employee details
                    printDetails(employee);
                    
                    // Ask user if they want to see the deductions report
                    System.out.print("Would you like to see the increased salary with deductions? Enter (1) to view the deductions report or any other key to exit.");
                    String choiceInput = scanner.next();
                    
                    // If user chooses to see deductions report, print it
                    if (choiceInput.equals("1")) {
                        salaryDeductions(employee);
                    }
                    
                    System.out.println("Application Complete");
                    validInput = true;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid input.");
                    // Consume the invalid input
                    scanner.nextLine(); 
                }
            } while (!validInput);
        }
    }
    /*-------------------------------------------main method end-------------------------------------------*/ 

    // Method to print the details of an employee
    public static void printDetails(Details employee) {
        System.out.println("EMPLOYEE DETAILS REPORT");
        System.out.println("****************************");
        System.out.println("EMPLOYEE NUMBER:      " + employee.getEmpNumber());
        System.out.println("EMPLOYEE FIRST NAME:  " + employee.getEmpName());
        System.out.println("EMPLOYEE SURNAME:     " + employee.getEmpSurname());
        System.out.println("ORIGINAL SALARY:      R " + formatAmount(employee.getEmpSalary()));
        
        // Update the salary 
        employee.getUpdatedSalary();
        
        System.out.println("INCREASED SALARY:      R " + formatAmount(employee.getEmpSalary()));
        double increasedAmount = employee.getEmpSalary() - employee.getEmpSalary() / 1.10; 
        System.out.println("INCREASED AMOUNT:     R " + formatAmount(increasedAmount));
        System.out.println("************ ****************");
    }

    // Method to calculate and print salary deductions of an employee
    public static void salaryDeductions(Details employee) {
        System.out.println("EMPLOYEE DEDUCTIONS REPORT");
        System.out.println("***************************");
        System.out.println("SALARY:            R " + formatAmount(employee.getEmpSalary()));
        double taxAmount = 0.18 * employee.getEmpSalary();
        double medicalAidAmount = 0.125 * employee.getEmpSalary();
        double carAllowanceAmount = 0.08 * employee.getEmpSalary();
        double uifAmount = 0.02 * employee.getEmpSalary();
        double totalDeductions = taxAmount + medicalAidAmount + carAllowanceAmount + uifAmount;
        double takeHomePay = employee.getEmpSalary() - totalDeductions;

        System.out.println("TAX:               R " + formatAmount(taxAmount));
        System.out.println("MEDICAL AID:       R " + formatAmount(medicalAidAmount));
        System.out.println("CAR ALLOWANCE:     R " + formatAmount(carAllowanceAmount));
        System.out.println("UIF:               R " + formatAmount(uifAmount));
        System.out.println("Take Home Pay:     R " + formatAmount(takeHomePay));
        System.out.println("***************************");
    }

    // Method to format amount with two decimal places
    private static String formatAmount(double amount) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.00", symbols);
        return df.format(amount);
    }    
}
/*-------------------------------------------------------end-------------------------------------------------------*/
