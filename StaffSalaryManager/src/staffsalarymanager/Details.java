package staffsalarymanager;

public class Details {
    // Private fields to store employee details
    private int empNumber;
    private String empName;
    private String empSurname;
    private double empSalary;

    // Constructor to initialize employee details 
    public Details(int empNumber, String empName, String empSurname, double empSalary) {
        this.empNumber = empNumber;
        this.empName = empName;
        this.empSurname = empSurname;
        this.empSalary = empSalary;
    }

    // Getter and setter methods for employee number
    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    // Getter and setter methods for employee name
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    // Getter and setter methods for employee surname
    public String getEmpSurname() {
        return empSurname;
    }

    public void setEmpSurname(String empSurname) {
        this.empSurname = empSurname;
    }

    // Getter and setter methods for employee salary
    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }
    
    // Method to increase salary by 10%
    public void getUpdatedSalary() {
        this.empSalary *= 1.10;
    }
}