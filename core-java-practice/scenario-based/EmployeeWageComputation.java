package scenariobased;

public class EmployeeWageComputation {
    public static void main(String[] args) {

        // display welcome message
        System.out.println("WELCOME TO EMPLOYEE WAGE COMPUTATION PROGRAM.\n");

        System.out.println("-------------------------------------------------------------------");

        // UC2: calculate and display daily wage
        Double d = useCase2();
        System.out.println("Daily Employee wage is " + d);
        System.out.println("------------------------------------------------------------------");

        // UC3 & UC4: determine employment type and calculate wage using switch
        String s2 = useCase3() == true ? "FULL TIME" : "PART TIME";
        double d1 = s2.equals("FULL TIME") ? useCase4(true) : useCase4(false);
        System.out.println("Employee is " + s2 + " and its daily wage is " + d1);
        System.out.println("-------------------------------------------------------------------");

        // UC6: calculate wages till condition of 20 days or 100 hours is met
        int totalDays = 0;
        int totalHours = 0;
        int i = 1;
        while(totalDays < 20 && totalHours <= 100) {
            // UC1: check employee attendance
            String isPresent = useCase1() == true ? "PRESENT" : "ABSENT";
            System.out.print("Day " + i + " Employee is " + isPresent);

            if(isPresent.equals("PRESENT")) {
                totalHours += useCase6();
                totalDays += 1;
                System.out.print(", Working hours = " + 8);
                System.out.println();
            } else {
                totalDays += 1;
                System.out.println();
            }

            i++;

        }
        System.out.println("-------------------------------------------------------------------");
        
        // UC5: calculate monthly wage based on total hours worked
        Double mWage = useCase5(totalHours);
        System.out.print("\nTotal Working hours of the Employee : " + totalHours);
        System.out.print("\nMonthly Wage of the Employee : " + mWage);
        System.out.println("\n\n-------------------------------------------------------------------");

    }

    // UC1: check employee attendance randomly
    static boolean useCase1() {
        return ((int)(Math.random() * 2) == 0) ? false : true;
    }

    // UC2: calculate daily wage (wage per hour * full day hours)
    static double useCase2() {
        double dailyWage = 20 * 8;
        return dailyWage;
    }

    // UC3: randomly determine full-time or part-time status
    static boolean useCase3() {
        return (int)(Math.random() * 2) == 0 ? false : true;
    }

    // UC4: calculate wage using switch case based on employment type
    static double useCase4(boolean x) {

        // convert boolean to integer for switch case
        int z = x == true ? 1 : 0;

        switch (z) {

            case 1:
                return 20 * 8; // full time wage

            case 0:
                return 20 * 8; // part time wage

            default:
                return 0;
        }
    }

    // UC5: calculate monthly wage based on total hours worked
    static double useCase5(int h) {
        return 20 * h;
    }

    // UC6: return working hours per day
    static int useCase6() {
        return 8;
    }

}
