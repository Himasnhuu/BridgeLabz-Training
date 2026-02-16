package scenariobased;

import java.util.*;

// UC11 → Interface
interface EmpWageBuilder {
    void computeWage();
}

// UC7 → Class Refactor
class CompanyEmpWage implements EmpWageBuilder {

    String companyName;
    int wagePerHour;
    int maxDays;
    int maxHours;
    int totalWage;

    // UC13 → Store daily wages
    ArrayList<Integer> dailyWages = new ArrayList<>();

    CompanyEmpWage(String companyName,
                   int wagePerHour,
                   int maxDays,
                   int maxHours) {

        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.maxDays = maxDays;
        this.maxHours = maxHours;
    }

    // UC8 + UC10 → Compute wage
    public void computeWage() {

        int totalHours = 0;
        int totalDays = 0;

        while (totalDays < maxDays &&
               totalHours < maxHours) {

            int empHours = getWorkingHours();

            totalHours += empHours;
            totalDays++;

            int dailyWage = empHours * wagePerHour;
            dailyWages.add(dailyWage);
        }

        totalWage = totalHours * wagePerHour;
    }

    // UC3 + UC4
    int getWorkingHours() {

        int empType =
            (int)(Math.random() * 3);

        switch (empType) {

            case 1: return 8; // Full time
            case 2: return 4; // Part time
            default: return 0; // Absent
        }
    }

    // UC9
    int getTotalWage() {
        return totalWage;
    }

    void printReport() {

        System.out.println("\nCompany : " + companyName);
        System.out.println("Daily Wages : " + dailyWages);
        System.out.println("Total Wage : " + totalWage);
    }
}

// MAIN CLASS
public class EmployeeWageComputation {

    static ArrayList<CompanyEmpWage> companyList =
        new ArrayList<>();

    public static void main(String[] args) {

        System.out.println(
            "WELCOME TO EMPLOYEE WAGE COMPUTATION PROGRAM\n");

        // UC1
        System.out.println("UC1 → Attendance Check");
        System.out.println(
            "Employee is " +
            (isPresent() ? "PRESENT" : "ABSENT"));

        // UC2
        System.out.println("\nUC2 → Daily Wage");
        System.out.println(
            "Daily Wage : " + (20 * 8));

        // UC3
        System.out.println("\nUC3 → Part Time Added");
        int hoursUC3 =
            (int)(Math.random() * 2) == 1 ? 8 : 4;
        System.out.println(
            "Working Hours : " + hoursUC3);

        // UC4
        System.out.println("\nUC4 → Switch Case Wage");
        System.out.println(
            "Wage : " + (hoursUC3 * 20));

        // UC5
        System.out.println("\nUC5 → Monthly Wage");
        System.out.println(
            "Monthly Wage : " +
            calculateMonthlyWage(100));

        // UC6
        System.out.println(
            "\nUC6 → Wages till condition");

        int totalHours = 0;
        int totalDays = 0;

        while (totalDays < 20 &&
               totalHours < 100) {

            int hrs = getHours();
            totalHours += hrs;
            totalDays++;
        }

        System.out.println(
            "Total Hours : " + totalHours);
        System.out.println(
            "Total Wage : " +
            (totalHours * 20));

        // UC7,8,9,10
        System.out.println(
            "\nUC7–UC10 → Class & Multiple Companies");

        addCompany("TCS", 20, 20, 100);
        addCompany("Infosys", 25, 22, 120);

        for (CompanyEmpWage c : companyList) {
            c.computeWage();
        }

        // UC13
        for (CompanyEmpWage c : companyList) {
            c.printReport();
        }

        // UC14
        System.out.println(
            "\nUC14 → Query Wage by Company");

        System.out.println(
            "Total Wage for TCS : " +
            getTotalWageByCompany("TCS"));
    }

    // UC1
    static boolean isPresent() {
        return (int)(Math.random() * 2) == 1;
    }

    // UC5
    static int calculateMonthlyWage(int hrs) {
        return hrs * 20;
    }

    // UC6 helper
    static int getHours() {

        int empType =
            (int)(Math.random() * 3);

        switch (empType) {
            case 1: return 8;
            case 2: return 4;
            default: return 0;
        }
    }

    // UC10
    static void addCompany(String name,
                           int wagePerHour,
                           int days,
                           int hours) {

        companyList.add(
            new CompanyEmpWage(
                name,
                wagePerHour,
                days,
                hours));
    }

    // UC14
    static int getTotalWageByCompany(String name) {

        for (CompanyEmpWage c : companyList) {

            if (c.companyName.equals(name)) {
                return c.getTotalWage();
            }
        }
        return 0;
    }
}
