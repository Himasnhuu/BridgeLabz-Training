/*
 * Election Booth Manager ️
Design a polling booth system.
● Take age input.
● Use if to check if eligible (>=18).
● Record vote (1, 2, or 3 for candidates).
● Loop for multiple voters, exit on special code.*/

package scenariobased;
import java.util.Scanner;

public class ElectionBoothManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // polling booth opens for voting
        System.out.println("POLLING BOOTH SYSTEM");
        System.out.println("Candidates:");
        System.out.println("1. Candidate A");
        System.out.println("2. Candidate B");
        System.out.println("3. Candidate C");
        System.out.println("Enter -1 to close polling booth\n");
        
        // vote counters for each candidate
        int votesForCandidateA = 0;
        int votesForCandidateB = 0;
        int votesForCandidateC = 0;
        int totalVotersCounted = 0;
        int rejectedVoters = 0;
        
        // polling booth remains open throughout the day
        while(true) {
            System.out.println("New Voter");
            System.out.print("Enter voter's age (-1 to close booth): ");
            int age = sc.nextInt();
            
            // presiding officer closes polling booth at end of day
            if(age == -1) {
                break;
            }
            
            // check voter eligibility as per indian constitution (18+ years)
            if(age < 18) {
                System.out.println("Sorry! You are not eligible to vote.");
                System.out.println("Minimum voting age is 18 years \n");
                rejectedVoters++;
                continue;
            }
            
            // eligible voter proceeds to electronic voting machine
            System.out.println("You are eligible to vote!");
            System.out.print("Cast your vote (1/2/3): ");
            int vote = sc.nextInt();
            
            // record vote in evm
            if(vote == 1) {
                votesForCandidateA++;
                totalVotersCounted++;
                System.out.println("Vote recorded for Candidate A\n");
            } else if(vote == 2) {
                votesForCandidateB++;
                totalVotersCounted++;
                System.out.println("Vote recorded for Candidate B\n");
            } else if(vote == 3) {
                votesForCandidateC++;
                totalVotersCounted++;
                System.out.println("Vote recorded for Candidate C\n");
            } else {
                System.out.println("Invalid vote! Please choose 1, 2, or 3.\n");
                rejectedVoters++;
            }
        }
        
        // election commission counts votes after polling closes
        System.out.println("\nPOLLING CLOSED");
        System.out.println("ELECTION RESULTS : ");
        System.out.println("Candidate A: " + votesForCandidateA + " votes");
        System.out.println("Candidate B: " + votesForCandidateB + " votes");
        System.out.println("Candidate C: " + votesForCandidateC + " votes");
        System.out.println("\nTotal Valid Votes: " + totalVotersCounted);
        System.out.println("Rejected/Ineligible: " + rejectedVoters);
        
        // declare winner based on maximum votes
        if(votesForCandidateA > votesForCandidateB && votesForCandidateA > votesForCandidateC) {
            System.out.println("\nWinner: Candidate A with " + votesForCandidateA + " votes!");
        } else if(votesForCandidateB > votesForCandidateA && votesForCandidateB > votesForCandidateC) {
            System.out.println("\nWinner: Candidate B with " + votesForCandidateB + " votes!");
        } else if(votesForCandidateC > votesForCandidateA && votesForCandidateC > votesForCandidateB) {
            System.out.println("\nWinner: Candidate C with " + votesForCandidateC + " votes!");
        } else {
            System.out.println("\nIt's a tie! Recount needed.");
        }
        
        System.out.println();
        
        sc.close();
    }
}
