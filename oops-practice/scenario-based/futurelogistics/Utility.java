package week2.oops.futurelogistics;

public class Utility {

	public GoodsTransport parseDetails(String input) {
		String [] data = input.split(":");
		
//		transportId:transportDate:transportRating:transportType:brickSize:brickQuantity:brickPrice
		
//		transportId:transportDate:transportRating:transportType:timberLength:ti
//		mberRadius:timberType:timberPrice
		
		String transportId = data[0];
		String transportDate = data[1];
		int transportRating = Integer.parseInt(data[2]);
		String transportType = data[3];
		
		if(transportType.equalsIgnoreCase("BrickTransport")) {
			float brickSize = Float.parseFloat(data[4]);
			int brickQuantity = Integer.parseInt(data[5]);
			float brickPrice = Float.parseFloat(data[6]);
			
			return new BrickTransport(transportId, transportDate, transportRating, brickSize, brickQuantity, brickPrice);
			
		}else {
//			private float timberLength;
//			private float timberRadius;
//			private String timberType;
//			private float timberPrice;
			
			float timberLength = Float.parseFloat(data[4]);
			float timberRadius = Float.parseFloat(data[5]);
			String timberType = data[6];
			float timberPrice = Float.parseFloat(data[7]);
			
			return new TimberTransport(transportId, transportDate, transportRating, timberLength, timberRadius, timberType, timberPrice);
		}
		
	}
	
	public boolean validateTransportId(String transportId) {
		if(transportId.startsWith("RTS") && transportId.length()==7 && (transportId.charAt(transportId.length()-1)>='A'&&transportId.charAt(transportId.length()-1)<='Z')) {
			for(int i=3; i<6; i++) {
				if(!Character.isDigit(transportId.charAt(i))) {
					return false;
				}
			}
			return true;
		}
		
		return false;
	}
	
	public String findObjectType(GoodsTransport goodsTransport) {
		if(goodsTransport instanceof BrickTransport) {
			return "BrickTransport";
		}
		if(goodsTransport instanceof TimberTransport) {
			return "TimberTransport";
		}
		
		return "";
		
	}
	
	

}
