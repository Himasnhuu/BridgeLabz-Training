package Week_01.javaMethods.level3;

public class EmployeeBonus {
    
    // method to generate salary and years of service
    public static int[][] generateEmployeeData(int numEmployees) {
        int[][] employeeData = new int[numEmployees][2];
        
        for (int i = 0; i < numEmployees; i++) {
            // generate 5-digit salary using Math.random()
            employeeData[i][0] = (int)(Math.random() * 90000) + 10000;
            
            // generate years of service (0-15 years)
            employeeData[i][1] = (int)(Math.random() * 16);
        }
        
        return employeeData;
    }
    
    // method to calculate new salary and bonus
    public static double[][] calculateNewSalaryAndBonus(int[][] employeeData) {
        double[][] result = new double[employeeData.length][2];
        
        for (int i = 0; i < employeeData.length; i++) {
            int salary = employeeData[i][0];
            int yearsOfService = employeeData[i][1];
            
            double bonusPercentage;
            
            // determine bonus percentage based on years of service
            if (yearsOfService > 5) {
                bonusPercentage = 0.05; // 5%
            } else {
                bonusPercentage = 0.02; // 2%
            }
            
            double bonusAmount = salary * bonusPercentage;
            double newSalary = salary + bonusAmount;
            
            result[i][0] = newSalary;
            result[i][1] = bonusAmount;
        }
        
        return result;
    }
    
    // method to calculate total amounts
    public static double[] calculateTotals(int[][] employeeData, double[][] newData) {
        double oldSalaryTotal = 0;
        double newSalaryTotal = 0;
        double bonusTotal = 0;
        
        for (int i = 0; i < employeeData.length; i++) {
            oldSalaryTotal += employeeData[i][0];
            newSalaryTotal += newData[i][0];
            bonusTotal += newData[i][1];
        }
        
        return new double[]{oldSalaryTotal, newSalaryTotal, bonusTotal};
    }
    
    public static void main(String[] args) {
        int numEmployees = 10;
        
        System.out.println("ZARA COMPANY BONUS CALCULATOR");
        System.out.println("Number of Employees: " + numEmployees);
        System.out.println("Bonus: 5% for >5 years, 2% for ≤5 years\n");
        
        // generate employee data
        int[][] employeeData = generateEmployeeData(numEmployees);
        
        // calculate new salary and bonus
        double[][] newData = calculateNewSalaryAndBonus(employeeData);
        
        // calculate totals
        double[] totals = calculateTotals(employeeData, newData);
        
        // display in tabular format
        System.out.println("Emp# | Old Salary | Years | Bonus    | New Salary");
        System.out.println("-----|------------|-------|----------|------------");
        
        for (int i = 0; i < numEmployees; i++) {
            System.out.printf("%-4d | ₹%-9d | %-5d | ₹%-7.2f | ₹%-10.2f\n",
                            (i + 1),
                            employeeData[i][0],
                            employeeData[i][1],
                            newData[i][1],
                            newData[i][0]);
        }
        
        System.out.println("-----|------------|-------|----------|------------");
        System.out.printf("Total: ₹%-9.2f         | ₹%-7.2f | ₹%-10.2f\n",
                         totals[0], totals[2], totals[1]);
    }
}
