package week2.oops.futurelogistics;
import java.util.*;
public class UserInterface {
	public static void main(String[] args) {
//		String t1 = "RTS120A:12/8/21:5:BrickTransport:6:800:40";
//		String t2 = "RTS113A:12/8/21:4:TimberTransport:20:4:Premium:500";
//		String t3 = "RTS113A:12/8/21:4:TimberTransport:13:4:NonPremium:200";
//		String t4 = "rts1137:12/8/21:4:TimberTransport:13:4:NonPremium:200";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Goods Transport Details");
//		System.out.println("RTS120A:12/8/21:5:BrickTransport:6:800:40");

		String detail = sc.nextLine();
		
		Utility u = new Utility();
		GoodsTransport gt = u.parseDetails(detail);
		boolean flag = u.validateTransportId(gt.getTransportId());

		if (!flag) {
			System.out.println("Transport id " + gt.getTransportId() + " is invalid\nPlease provide a valid record");
			return;
		}

		String objType = u.findObjectType(gt);

		if (objType.equals("BrickTransport")) {

			BrickTransport b = (BrickTransport) gt;

			System.out.println("Transport id: " + b.transportId);
			System.out.println("Date of transport: " + b.transportDate);
			System.out.println("Rating of the transport: " + b.transportRating);
			System.out.println("Quantity of bricks: " + b.getBrickQuantity());
			System.out.println("Brick price: " + b.getBrickPrice());
			System.out.println("Vehicle for transport: " + b.vehicleSelection());
			System.out.println("Total charge: " + b.calculateTotalCharge());
			return;
		}
//
//		Sample Input and Output 3:
//			Enter the Goods Transport details
//			RTS113A:12/8/21:4:TimberTransport:13:4:NonPremium:200
//			Transporter id : RTS113A
//			Date of transport : 12/8/21
//			Rating of the transport : 4
//			Type of the timber : NonPremium
//			Timber price per kilo : 200.0
//			Vehicle for transport : Lorry
//		Total charge : 25264.734
		
		
		if (objType.equals("TimberTransport")) {

			TimberTransport b = (TimberTransport) gt;

			System.out.println("Transport id: " + b.transportId);
			System.out.println("Date of transport: " + b.transportDate);
			System.out.println("Rating of the transport: " + b.transportRating);
			System.out.println("Type of the timber: " + b.getTimberType());
			System.out.println("Timber Price per kilo: " + b.getTimberPrice());
			System.out.println("Vehicle for transport: " + b.vehicleSelection());
			System.out.println("Total Charge: " + b.calculateTotalCharge());
		}

	}
}
