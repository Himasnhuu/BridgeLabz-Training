package food_delivery_order_routing_system;

public class Main {
	public static void main(String[] args) {
		DeliveryService service = new DeliveryService();
		
		service.addAgent(new Agent(1, 10));
		service.addAgent(new Agent(2, 20));
		
		service.addOrder(new Order(101, 12));
		service.addOrder(new Order(102, 18));
		
		try {
			service.assignOrders();
			service.assignOrders();
			service.assignOrders();
		} catch (NoAgentAvailableException e) {
			System.err.println(e.getMessage());
		}
		System.out.println();
		service.viewActiveDeleveries();
	}
}
