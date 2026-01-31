package week2.oops.futurelogistics;

public class BrickTransport extends GoodsTransport {

	private float brickSize;
	private int brickQuantity;
	private float brickPrice;

	public BrickTransport(String transportId, String transportDate, int transportRating, float brickSize,
			int brickQuantity, float brickPrice) {
		super(transportId, transportDate, transportRating);
		this.brickSize = brickSize;
		this.brickQuantity = brickQuantity;
		this.brickPrice = brickPrice;
	}

	public float getBrickSize() {
		return brickSize;
	}

	public void setBrickSize(float brickSize) {
		this.brickSize = brickSize;
	}

	public int getBrickQuantity() {
		return brickQuantity;
	}

	public void setBrickQuantity(int brickQuantity) {
		this.brickQuantity = brickQuantity;
	}

	public float getBrickPrice() {
		return brickPrice;
	}

	public void setBrickPrice(float brickPrice) {
		this.brickPrice = brickPrice;
	}

	public String vehicleSelection() {
		if (this.brickQuantity < 300) {
			return "Truck";
		}

		if (this.brickQuantity >= 300 && this.brickQuantity <= 500) {
			return "Lorry";
		}

		return "MonsterLorry";
	}

	public float calculateTotalCharge() {
		float bPrice = this.brickPrice * this.brickQuantity;
		float vPrice = this.vehicleSelection().equals("Truck")  ? 1000 : this.vehicleSelection().equalsIgnoreCase("Lorry") ? 1700 : 3000;
		float tax = bPrice * (30.0f / 100);
		float tPrice = bPrice + vPrice;

		float discount = super.transportRating == 5 ? bPrice * (20.0f / 100)
				: (super.transportRating == 4 || super.transportRating == 3) ? bPrice * (10.0f / 100) : 0;

		return tPrice - discount + tax;

	}

}
