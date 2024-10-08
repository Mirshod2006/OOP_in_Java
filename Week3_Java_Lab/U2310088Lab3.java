package Week3_Java_Lab;

class Employee {
    private String employeeName;
    private int employeeId;
    private double baseSalary;
    private static int employeeCount = 0;

    Employee(String name, int id, double salary) {
        this.employeeName = name;
        this.employeeId = id;
        this.baseSalary = salary;
        employeeCount++;  
    }

    public String getName() {
        return this.employeeName;
    }

    public int getId() {
        return this.employeeId;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public void setName(String name) {
        this.employeeName = name;
    }

    public void setId(int id) {
        this.employeeId = id;
    }

    public void setBaseSalary(double salary) {
        this.baseSalary = salary;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee Name: " + this.employeeName);
        System.out.println("Employee ID: " + this.employeeId);
        System.out.println("Base Salary: $" + this.baseSalary);
    }

    public double calculateSalary() {
        return this.baseSalary;
    }

    public static void displayEmployeeCount() {
        System.out.println("Total Number of Employees: " + employeeCount);
    }
}

class FullTimeEmployee extends Employee {
    private double annualBonus;

    FullTimeEmployee(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.annualBonus = bonus;
    }

    public void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("Annual Bonus: " + this.annualBonus);
    }

    @Override
    public double calculateSalary() {
        return this.getBaseSalary() + this.annualBonus;
    }

    public double calculateBonus(double performanceBonus) {
        return this.annualBonus + performanceBonus;
    }

    public double calculateBonus(double performanceBonus, double specialAllowance) {
        return this.annualBonus + performanceBonus + specialAllowance;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;
    private final double MAX_HOURLY_RATE = 50.0;

    PartTimeEmployee(String name, int id, double salary, int hours, double rate) {
        super(name, id, salary);
        this.hoursWorked = hours;
        this.hourlyRate = rate > MAX_HOURLY_RATE ? MAX_HOURLY_RATE : rate; // Restrict hourly rate
    }

    public void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("Hours Worked: " + this.hoursWorked);
        System.out.println("Hourly Rate: " + this.hourlyRate);
    }

    @Override
    public double calculateSalary() {
        return this.getBaseSalary() + (this.hoursWorked * this.hourlyRate);
    }
}

class Intern extends Employee {
    private String universityName;

    Intern(String name, int id, double salary, String universityName) {
        super(name, id, salary);
        this.universityName = universityName;
    }

    public void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("University Name: " + this.universityName);
    }
}

public class U2310088Lab3 {
    public static void main(String[] args) {
        FullTimeEmployee fullTimeEmp = new FullTimeEmployee("John Doe", 101, 50000, 10000);
        PartTimeEmployee partTimeEmp = new PartTimeEmployee("Jane Smith", 102, 15000, 20, 45.0);
        Intern intern = new Intern("Sam Brown", 103, 5000, "XYZ University");

        System.out.println("\nFull-Time Employee Details:");
        fullTimeEmp.displayEmployeeDetails();
        System.out.println("Calculated Salary: $" + fullTimeEmp.calculateSalary());

        System.out.println("\nPart-Time Employee Details:");
        partTimeEmp.displayEmployeeDetails();
        System.out.println("Calculated Salary: $" + partTimeEmp.calculateSalary());

        System.out.println("\nIntern Employee Details:");
        intern.displayEmployeeDetails();
        System.out.println("Calculated Salary: $" + intern.calculateSalary());

        System.out.println("\nFull-Time Employee Bonus (with performance bonus): $" + fullTimeEmp.calculateBonus(5000));
        System.out.println("Full-Time Employee Bonus (with performance bonus and special allowance): $" + fullTimeEmp.calculateBonus(5000, 2000));
        Employee.displayEmployeeCount();
    }
}

