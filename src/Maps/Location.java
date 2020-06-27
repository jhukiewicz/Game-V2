package Maps;

import Characters.Enemies.Monster;
import Items.Item;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int ID;
    private final String description;
    private final Map<Directions, Integer> exits;
    private Monster Monster;
    private Item item;

    public Location(int ID, String description) {
        this.ID = ID;
        this.description = description;
        this.exits = new HashMap<>();
    }


    public void addExit(Directions direction, int location ){
        exits.put(direction,location);
    }

    public int getID() {
        return ID;
    }

    public String getDescription() {
        return description;
    }

    public Map<Directions, Integer> getExits() {
        return exits;
    }

    public Monster getMonster() {
        return Monster;
    }

    public void setMonster(Monster monster) {
        Monster = monster;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
