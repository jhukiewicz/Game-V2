package Items.PlayerInventory;

import Items.Item;
import Items.Potions.Potion;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private List<Item> backpack;


    public Backpack() {
        backpack = new ArrayList<>();
    }

    public void browseBackpack(){
        int nr = 0;
        for (Item item : backpack) {
            System.out.println(Integer.toString(nr) + item);
            nr++;
        }
    }

    public boolean putInBackpack(Item item){
        if (item==null){
            return false;
        }
        backpack.add(item);
        return true;
    }



    public List<Item> getBackpack() {
        return backpack;
    }

    public void setBackpack(List<Item> backpack) {
        this.backpack = backpack;
    }
}
