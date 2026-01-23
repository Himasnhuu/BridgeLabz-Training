package insurance;

import java.time.LocalDate;
import java.util.*;

public class PolicyManagementSystem {
    
    private HashSet<Policy> hashSetPolicies;
    private LinkedHashSet<Policy> linkedHashSetPolicies;
    private TreeSet<Policy> treeSetPolicies;
    
    public PolicyManagementSystem() {
        hashSetPolicies = new HashSet<>();
        linkedHashSetPolicies = new LinkedHashSet<>();
        treeSetPolicies = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));
    }
    
    // Store policies in different sets
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }
    
    // Retrieve all unique policies using HashSet
    public Set<Policy> getAllPolicies() {
        return new HashSet<>(hashSetPolicies);
    }
    
    // Retrieve policies in insertion order using LinkedHashSet
    public Set<Policy> getPoliciesInInsertionOrder() {
        return new LinkedHashSet<>(linkedHashSetPolicies);
    }
    
    // Retrieve policies sorted by expiry date using TreeSet
    public Set<Policy> getPoliciesByExpiryDate() {
        return new TreeSet<>(treeSetPolicies);
    }
    
    // Retrieve policies expiring within next 30 days
    public List<Policy> getPoliciesExpiringSoon() {
        List<Policy> expiringSoon = new ArrayList<>();
        LocalDate now = LocalDate.now();
        LocalDate thirtyDaysLater = now.plusDays(30);
        
        for (Policy policy : hashSetPolicies) {
            if (!policy.getExpiryDate().isBefore(now) && 
                !policy.getExpiryDate().isAfter(thirtyDaysLater)) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }
    
    // Retrieve policies with specific coverage type
    public List<Policy> getPoliciesByCoverageType(String coverageType) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                result.add(policy);
            }
        }
        return result;
    }
    
    // Find duplicate policies based on policy number
    public List<Policy> findDuplicates(List<Policy> policies) {
        Set<String> seen = new HashSet<>();
        List<Policy> duplicates = new ArrayList<>();
        
        for (Policy policy : policies) {
            if (!seen.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }
    
    // Performance comparison
    public void performanceComparison(int numOperations) {
        Random rand = new Random();
        
        // Test HashSet
        long startTime = System.nanoTime();
        for (int i = 0; i < numOperations; i++) {
            Policy p = new Policy("P" + rand.nextInt(1000), "Name", LocalDate.now(), "Health", 100);
            hashSetPolicies.add(p);
            hashSetPolicies.contains(p);
            hashSetPolicies.remove(p);
        }
        long hashSetTime = System.nanoTime() - startTime;
        
        // Test LinkedHashSet
        startTime = System.nanoTime();
        for (int i = 0; i < numOperations; i++) {
            Policy p = new Policy("P" + rand.nextInt(1000), "Name", LocalDate.now(), "Health", 100);
            linkedHashSetPolicies.add(p);
            linkedHashSetPolicies.contains(p);
            linkedHashSetPolicies.remove(p);
        }
        long linkedHashSetTime = System.nanoTime() - startTime;
        
        // Test TreeSet
        startTime = System.nanoTime();
        for (int i = 0; i < numOperations; i++) {
            Policy p = new Policy("P" + rand.nextInt(1000), "Name", LocalDate.now(), "Health", 100);
            treeSetPolicies.add(p);
            treeSetPolicies.contains(p);
            treeSetPolicies.remove(p);
        }
        long treeSetTime = System.nanoTime() - startTime;
        
        System.out.println("Performance Comparison (" + numOperations + " operations):");
        System.out.println("HashSet: " + hashSetTime / 1_000_000 + " ms");
        System.out.println("LinkedHashSet: " + linkedHashSetTime / 1_000_000 + " ms");
        System.out.println("TreeSet: " + treeSetTime / 1_000_000 + " ms");
    }
    
    public static void main(String[] args) {
        PolicyManagementSystem pms = new PolicyManagementSystem();
        
        // Add sample policies
        pms.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(15), "Health", 500));
        pms.addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(45), "Auto", 750));
        pms.addPolicy(new Policy("P003", "Carol", LocalDate.now().plusDays(20), "Home", 600));
        pms.addPolicy(new Policy("P004", "David", LocalDate.now().plusDays(5), "Health", 550));
        
        System.out.println("All Policies:");
        pms.getAllPolicies().forEach(System.out::println);
        
        System.out.println("\nPolicies in Insertion Order:");
        pms.getPoliciesInInsertionOrder().forEach(System.out::println);
        
        System.out.println("\nPolicies Sorted by Expiry Date:");
        pms.getPoliciesByExpiryDate().forEach(System.out::println);
        
        System.out.println("\nPolicies Expiring Soon:");
        pms.getPoliciesExpiringSoon().forEach(System.out::println);
        
        System.out.println("\nHealth Policies:");
        pms.getPoliciesByCoverageType("Health").forEach(System.out::println);
        
        System.out.println("\n");
        pms.performanceComparison(1000);
    }
}
