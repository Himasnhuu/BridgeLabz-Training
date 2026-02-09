package food_delivery_order_routing_system;
import java.util.*;
public class DeliveryService {
	private Queue<Order> orderQueue = new LinkedList<>();
	private List<Agent> agents = new ArrayList<>();
	private Map<Order, Agent> activeDeliveries = new HashMap<>();
	
	public void addOrder(Order order) {
		orderQueue.add(order);
	}
	
	public void addAgent(Agent agent) {
		agents.add(agent);
	}
	
	public void assignOrders() throws NoAgentAvailableException{
		if (orderQueue.isEmpty()) {
			return;
		}
		Order order = orderQueue.poll();
		Agent nearestAgent = findNearestAvailableAgent(order);
		
		if(nearestAgent == null) {
			throw new NoAgentAvailableException("No delivery agents available");
		}
		
		nearestAgent.setAvailable(false);
		activeDeliveries.put(order, nearestAgent);
		
		System.out.println(order + " assigned to " + nearestAgent);
	}
	
	private Agent findNearestAvailableAgent(Order order) {
		Agent nearest = null;
		int minDistance = Integer.MAX_VALUE;
		
		for(Agent agent : agents) {
			if(agent.isAvailable()) {
				int distance = Math.abs(agent.getLocation() - order.getLocation());
				if (distance < minDistance) {
					minDistance = distance;
					nearest = agent;
				}
			}
		}
		return nearest;
	}
	
	public void cancelOrder(Order order) {
		Agent agent = activeDeliveries.remove(order);
		if (agent != null) {
			agent.setAvailable(true);
			System.out.println(order + " cancelled. " + agent + " is now available.");
		} else {
			System.out.println(order + " not found in active deliveries.");
		}
	}
	
	public void viewActiveDeleveries() {
		for (Map.Entry<Order, Agent> entry : activeDeliveries.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}
}
