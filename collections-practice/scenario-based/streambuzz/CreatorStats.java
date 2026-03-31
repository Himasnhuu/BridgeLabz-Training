package week4collections.streambuzz;

public class CreatorStats {

	private String name;
	private double[] likes;

	public CreatorStats(String name, double[] likes) {
		this.name = name;
		this.likes = likes;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double[] getLikes() {
		return this.likes;
	}

}
