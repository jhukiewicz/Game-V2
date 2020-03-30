package Items.PlayerInventory;

import Items.Item;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private List<Item> backpack;
    public Backpack() {
        backpack = new ArrayList<>();
    }

    public boolean putInBackpack(Item item){
        if (item==null){
            return false;
        }
        backpack.add(item);
        return true;
    }

    

}
