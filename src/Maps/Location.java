package Maps;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int ID;
    private final String description;
    private final Map<Directions, Integer> exits;
    private boolean isMonster;

    public Location(int ID, String description) {
        this.ID = ID;
        this.description = description;
        this.exits = new HashMap<>();
        this.isMonster = false;
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
}
