package food_delivery_order_routing_system;
public class Agent {
	private int agentId;
	private int location;
	private boolean available = true;
	
	public Agent(int agentId, int location) {
		this.agentId = agentId;
		this.location = location;
		this.available = true;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public int getAgentId() {
		return agentId;
	}
	
	public int getLocation() {
        return location;
	}
	
	@Override
	public String toString() {
		return "Agent-" + agentId;
	}
}
