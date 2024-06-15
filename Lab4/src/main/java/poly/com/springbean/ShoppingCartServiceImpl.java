package poly.com.springbean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import poly.com.inter.ShoppingCart;
import poly.com.model.Item;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCart {

    private Map<Integer, Item> map = new HashMap<>();

    @Override
    public Item add(Integer id) {
        Item item = map.get(id);
        if (item == null) {
            item = new Item(id, "Unknown", 0, 1);
            map.put(id, item);
        } else {
            item.setQty(item.getQty() + 1);
        }
        return item;
    }

    @Override
    public void remove(Integer id) {
        map.remove(id);
    }

    @Override
    public Item update(Integer id, int qty) {
        Item item = map.get(id);
        if (item != null) {
            item.setQty(qty);
        }
        return item;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<Item> getItems() {
        return map.values();
    }

    @Override
    public int getCount() {
        return map.values().stream().mapToInt(Item::getQty).sum();
    }

    @Override
    public double getAmount() {
        return map.values().stream()
                .mapToDouble(item -> item.getPrice() * item.getQty())
                .sum();
    }
    
    public class DB { 
    	public static Map<Integer, Item> items = new HashMap<>(); 
    	static {   
    		items.put(1, new Item(1, "Samsung", 10.0, 0));
    		items.put(2, new Item(2, "Nokia 2021", 20.50, 0)); 
    		items.put(3, new Item(3, "iPhone 20", 90.49, 0)); 
    		items.put(4, new Item(4, "Motorola", 15.55, 0));  
    		items.put(5, new Item(5, "Seamen", 8.99, 0));
    		} 
    	} 
}