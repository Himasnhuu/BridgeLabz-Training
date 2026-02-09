package food_delivery_order_routing_system;

public class Order {
	private int orderId;
	private int location;
	
	public Order(int orderId, int location) {
		this.orderId = orderId;
		this.location = location;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getLocation() {
        return location;
	}
	
	@Override
	public String toString() {
		return "Order-" + orderId;
	}
}
