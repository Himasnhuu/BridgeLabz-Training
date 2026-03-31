package smartcheckout;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<String> itemNames;

    public Customer(String name) {
        this.name = name;
        this.itemNames = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addItem(String itemName) {
        itemNames.add(itemName);
    }

    public List<String> getItemNames() {
        return itemNames;
    }

    @Override
    public String toString() {
        return name + " (Items: " + itemNames + ")";
    }
}
