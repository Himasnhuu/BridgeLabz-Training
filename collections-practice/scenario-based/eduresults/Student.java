package eduresults;

public class Student {
    private String name;
    private int score;
    private String district;

    public Student(String name, int score, String district) {
        this.name = name;
        this.score = score;
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getDistrict() {
        return district;
    }

    @Override
    public String toString() {
        return name + " (Score: " + score + ", District: " + district + ")";
    }
}
