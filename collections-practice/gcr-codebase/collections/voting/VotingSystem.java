package voting;

import java.util.*;

public class VotingSystem {
    
    private HashMap<String, Integer> votes;
    
    public VotingSystem() {
        votes = new HashMap<>();
    }
    
    // Cast a vote for a candidate
    public void vote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
    }
    
    // Get results sorted by candidate name
    public TreeMap<String, Integer> getResultsSortedByName() {
        return new TreeMap<>(votes);
    }
    
    // Get results sorted by vote count (descending)
    public LinkedHashMap<String, Integer> getResultsSortedByVotes() {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(votes.entrySet());
        entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        LinkedHashMap<String, Integer> sorted = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            sorted.put(entry.getKey(), entry.getValue());
        }
        return sorted;
    }
    
    // Get total votes
    public int getTotalVotes() {
        return votes.values().stream().mapToInt(Integer::intValue).sum();
    }
    
    // Get winner
    public String getWinner() {
        if (votes.isEmpty()) return null;
        
        return votes.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);
    }
    
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        
        // Cast votes
        system.vote("Alice");
        system.vote("Bob");
        system.vote("Alice");
        system.vote("Charlie");
        system.vote("Bob");
        system.vote("Alice");
        
        System.out.println("Results sorted by candidate name:");
        system.getResultsSortedByName().forEach((k, v) -> 
            System.out.println(k + ": " + v + " votes"));
        
        System.out.println("\nResults sorted by vote count:");
        system.getResultsSortedByVotes().forEach((k, v) -> 
            System.out.println(k + ": " + v + " votes"));
        
        System.out.println("\nTotal votes: " + system.getTotalVotes());
        System.out.println("Winner: " + system.getWinner());
    }
}
