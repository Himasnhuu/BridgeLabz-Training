package week4collections.streambuzz;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.List;
import java.util.Map;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean flag = true;

		Program p = new Program();
		while (flag) {

			System.out.println(
					"1. Register Creator\r\n" + "2. Show Top Posts\r\n" + "3. Calculate Average Likes\r\n" + "4. Exit");

			int n = sc.nextInt();
			sc.nextLine();
			switch (n) {

			case 1:
				System.out.println("Enter Creator name:");
				String name = sc.nextLine();
				System.out.println("Enter weekly likes(Week 1 to 4)");
				double[] likes = new double[4];
				likes[0] = sc.nextDouble();
				likes[1] = sc.nextDouble();
				likes[2] = sc.nextDouble();
				likes[3] = sc.nextDouble();

				CreatorStats cs = new CreatorStats(name, likes);

				p.registerCreator(cs);

				System.out.println("Creator registered successfully");
				break;

			case 2:
				System.out.println("Enter like threshold:");
				int tl = sc.nextInt();
				sc.nextLine();
				
				
				
				Map<String, Integer> d = new HashMap<>();
				d= (Map<String, Integer>) p.getTopPostCounts(EngagementBoard, tl);
				
				if(d.isEmpty()) {
					System.out.println("No top-performing posts this week");
					break;
				}
				
				for(String x:d.keySet()) {
					System.out.println(x+" - "+d.get(x));
				}
				break;
				
			case 3:
				int avg = (int) p.CalculateAverageLikes();
				
				System.out.println("Overall average weekly likes: "+avg);
				break;
				
			case 4:
				System.out.println("Logging off - Keep Creating with StreamBuzz!");
				flag = false;
				break;
				
			default:
				System.out.println("Invalid Choice");
				break;
			}

		}

		sc.close();
	}

	public static List<CreatorStats> EngagementBoard = new ArrayList<>();

	public void registerCreator(CreatorStats record) {
		EngagementBoard.add(record);

	}

	public Dictionary<String, Integer> getTopPostCounts(List<CreatorStats> records, double likeThreshold) {

		Dictionary<String, Integer> hm = new Hashtable<>();

		int l = records.size();
		for (int i = 0; i < l; i++) {
			int count = 0;
			CreatorStats data = records.get(i);
			String name = data.getName();
			double[] wl = data.getLikes();

			for (double x : wl) {
				if (x >= likeThreshold) {
					count++;
				}

			}
			if (count > 0) {
				hm.put(name, count);
			}
		}

		return hm;
	}

	public double CalculateAverageLikes() {
		int l = EngagementBoard.size();
		int count = 0;
		double sum = 0;
		for (int i = 0; i < l; i++) {
			double[] arr = EngagementBoard.get(i).getLikes();
			for (double x : arr) {
				sum += x;
				count++;
			}
		}

		return sum / count;
	}

}
