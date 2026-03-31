package week2.oops.futurelogistics;

public class TimberTransport extends GoodsTransport {
	private float timberLength;
	private float timberRadius;
	private String timberType;
	private float timberPrice;

	public TimberTransport(String transportId, String transportDate, int transportRating, float timberLength,
			float timberRadius, String timberType, float timberPrice) {
		super(transportId, transportDate, transportRating);
		this.timberLength = timberLength;
		this.timberRadius = timberRadius;
		this.timberType = timberType;
		this.timberPrice = timberPrice;
	}

	public float getTimberLength() {
		return timberLength;
	}

	public void setTimberLength(float timberLength) {
		this.timberLength = timberLength;
	}

	public float getTimberRadius() {
		return timberRadius;
	}

	public void setTimberRadius(float timberRadius) {
		this.timberRadius = timberRadius;
	}

	public String getTimberType() {
		return timberType;
	}

	public void setTimberType(String timberType) {
		this.timberType = timberType;
	}

	public float getTimberPrice() {
		return timberPrice;
	}

	public void setTimberPrice(float timberPrice) {
		this.timberPrice = timberPrice;
	}

	public String vehicleSelection() {
		double area = 2 * 3.147 * this.timberRadius * this.timberLength;

		String s = area < 250 ? "Truck" : area <= 400 ? "Lorry" : "MonsterLorry";

		return s;

	}

//	Total charge : 25264.734
	
	public float calculateTotalCharge() {
		float volume = (float) 3.147 * this.timberLength * this.timberRadius * this.timberRadius;
		float vPrice = this.vehicleSelection().equals("Truck")  ? 1000 : this.vehicleSelection().equalsIgnoreCase("Lorry") ? 1700 : 3000;
		float tPrice = this.timberType.equals("Premium") ? (float) (volume * this.timberPrice * 0.25)
				: (float) (volume * this.timberPrice * 0.15);

		float tax = (float) (tPrice * 0.3);
		
		float discount = super.transportRating == 5 ? tPrice * (20.0f / 100)
				: (super.transportRating == 4 || super.transportRating == 3) ? tPrice * (10.0f / 100) : 0;
		
		return (vPrice+tPrice+tax-discount);
	}

}
