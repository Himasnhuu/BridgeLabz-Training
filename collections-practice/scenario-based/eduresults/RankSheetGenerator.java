package eduresults;

import java.util.ArrayList;
import java.util.List;

public class RankSheetGenerator {

    // Merge sort implementation for merging sorted sublists
    public List<Student> mergeSortedLists(List<List<Student>> districtLists) {
        if (districtLists == null || districtLists.isEmpty()) {
            return new ArrayList<>();
        }

        // Start with the first list
        List<Student> result = districtLists.get(0);

        // Merge each subsequent list
        for (int i = 1; i < districtLists.size(); i++) {
            result = mergeTwoLists(result, districtLists.get(i));
        }

        return result;
    }

    // Merge two sorted lists into one sorted list (descending order by score)
    private List<Student> mergeTwoLists(List<Student> list1, List<Student> list2) {
        List<Student> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            // Higher score comes first (descending order)
            if (list1.get(i).getScore() >= list2.get(j).getScore()) {
                merged.add(list1.get(i));
                i++;
            } else {
                merged.add(list2.get(j));
                j++;
            }
        }

        // Add remaining elements from list1
        while (i < list1.size()) {
            merged.add(list1.get(i));
            i++;
        }

        // Add remaining elements from list2
        while (j < list2.size()) {
            merged.add(list2.get(j));
            j++;
        }

        return merged;
    }

    // Display rank sheet
    public void displayRankSheet(List<Student> students) {
        System.out.println("\n===== State-wide Rank Sheet =====");
        int rank = 1;
        for (Student student : students) {
            System.out.println("Rank " + rank + ": " + student);
            rank++;
        }
    }
}
