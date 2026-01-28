package eduresults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // District 1 - sorted list (descending by score)
        List<Student> district1 = Arrays.asList(
            new Student("Alice", 95, "District-1"),
            new Student("Bob", 88, "District-1"),
            new Student("Charlie", 75, "District-1")
        );

        // District 2 - sorted list (descending by score)
        List<Student> district2 = Arrays.asList(
            new Student("David", 98, "District-2"),
            new Student("Eve", 92, "District-2"),
            new Student("Frank", 85, "District-2")
        );

        // District 3 - sorted list (descending by score)
        List<Student> district3 = Arrays.asList(
            new Student("Grace", 90, "District-3"),
            new Student("Henry", 88, "District-3"),
            new Student("Ivy", 80, "District-3")
        );

        // Create list of all district lists
        List<List<Student>> allDistricts = new ArrayList<>();
        allDistricts.add(district1);
        allDistricts.add(district2);
        allDistricts.add(district3);

        // Merge and generate rank sheet
        RankSheetGenerator generator = new RankSheetGenerator();
        List<Student> finalRankList = generator.mergeSortedLists(allDistricts);
        
        // Display the final rank sheet
        generator.displayRankSheet(finalRankList);
    }
}
