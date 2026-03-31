package Week_01.javaMethods.level2;
import java.util.Scanner;

/*An organization took up the exercise to find the Body Mass Index (BMI) of all the persons in a 
 * team of 10 members. For this create a program to find the BMI and display the height, weight, 
 * BMI, and status of each individual
Hint => 
Take user input for the person's weight (kg) and height (cm) and store it in the corresponding 
2D array of 10 rows. The First Column stores the weight and the second column stores the height in cm
Create a Method to find the BMI and status of every person given the person's height and weight 
and return the 2D String array. Use the formula BMI = weight / (height * height). Note unit is kg/m^2. 
For this convert cm to meter
Create a Method that takes the 2D array of height and weight as parameters. Calls the user-defined 
method to compute the BMI and the BMI Status and stores in a 2D String array of height, weight, BMI, and status.
Create a method to display the 2D string array in a tabular format of Person's Height, Weight, BMI, and the Status
Finally, the main function takes user inputs, calls the user-defined methods, and displays the result.
*/

public class CalBMI {
    
    // method to calculate bmi and determine status
    public static String[] calculateBMIAndStatus(double weight, double heightCm) {
        // convert height from cm to meters for bmi formula
        double heightM = heightCm / 100;
        
        // calculate bmi using standard formula
        double bmi = weight / (heightM * heightM);
        
        // determine health status based on who guidelines
        String status;
        if (bmi < 18.4) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal";
        } else if (bmi < 40) {
            status = "Overweight";
        } else {
            status = "Obese";
        }
        
        // return array with height, weight, bmi, status
        String[] result = new String[4];
        result[0] = heightCm + "";
        result[1] = weight + "";
        result[2] = bmi + "";
        result[3] = status;
        
        return result;
    }
    
    // method to process all team members' data
    public static String[][] processBMIData(double[][] data) {
        int numPersons = data.length;
        String[][] result = new String[numPersons][4];
        
        // calculate bmi for each team member
        for (int i = 0; i < numPersons; i++) {
            double weight = data[i][0];
            double height = data[i][1];
            result[i] = calculateBMIAndStatus(weight, height);
        }
        
        return result;
    }
    
    // method to display results in tabular format
    public static void displayBMITable(String[][] bmiData) {
        System.out.println("\nBMI REPORT");
        System.out.println("Person\t\tHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
        
        // display each team member's health data
        for (int i = 0; i < bmiData.length; i++) {
            System.out.println("Person " + (i + 1) + "\t" + 
                             bmiData[i][0] + "\t\t" + 
                             bmiData[i][1] + "\t\t" + 
                             bmiData[i][2] + "\t" + 
                             bmiData[i][3]);
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // organization conducts health checkup for team
        System.out.println("Enter data for 10 team members\n");
        
        // 2d array to store weight and height data
        double[][] teamData = new double[10][2];
        
        // collect health data from all team members
        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.print("  Enter weight (kg): ");
            teamData[i][0] = sc.nextDouble();
            
            System.out.print("  Enter height (cm): ");
            teamData[i][1] = sc.nextDouble();
            System.out.println();
        }
        
        // process data and calculate bmi for entire team
        String[][] bmiResults = processBMIData(teamData);
        
        // display comprehensive health report
        displayBMITable(bmiResults);
        
        sc.close();
    }
}
