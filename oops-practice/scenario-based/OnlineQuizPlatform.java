package scenariobased.oops;

import java.util.ArrayList;
import java.util.Scanner;

// Custom Exception
class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

public class OnlineQuizPlatform {
    
    // Compare answers and calculate score
    public static int calculateScore(String[] correctAnswers, String[] userAnswers) 
            throws InvalidQuizSubmissionException {
        
        if (userAnswers.length != correctAnswers.length) {
            throw new InvalidQuizSubmissionException(
                "Answer count mismatch! Expected " + correctAnswers.length + 
                " but got " + userAnswers.length);
        }
        
        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                score++;
            }
        }
        return score;
    }
    
    // Return grade based on score
    public static String getGrade(int score, int total) {
        double percentage = (score * 100.0) / total;
        if (percentage >= 90) return "A";
        else if (percentage >= 75) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 40) return "D";
        else return "F";
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Correct answers
        String[] correctAnswers = {"A", "B", "C", "A", "D"};
        
        // Store scores of multiple users
        ArrayList<Integer> userScores = new ArrayList<>();
        
        System.out.println("=== Online Quiz Platform ===");
        System.out.println("Total Questions: " + correctAnswers.length);
        System.out.print("How many users? ");
        int numUsers = sc.nextInt();
        sc.nextLine();
        
        for (int user = 1; user <= numUsers; user++) {
            System.out.println("\n--- User " + user + " ---");
            String[] userAnswers = new String[correctAnswers.length];
            
            for (int i = 0; i < correctAnswers.length; i++) {
                System.out.print("Q" + (i + 1) + " Answer: ");
                userAnswers[i] = sc.nextLine();
            }
            
            try {
                int score = calculateScore(correctAnswers, userAnswers);
                userScores.add(score);
                String grade = getGrade(score, correctAnswers.length);
                
                System.out.println("\nResult:");
                System.out.println("Score: " + score + "/" + correctAnswers.length);
                System.out.println("Grade: " + grade);
                
            } catch (InvalidQuizSubmissionException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        System.out.println("\n=== All User Scores ===");
        for (int i = 0; i < userScores.size(); i++) {
            System.out.println("User " + (i + 1) + ": " + userScores.get(i) + 
                             "/" + correctAnswers.length);
        }
        
        sc.close();
    }
}
