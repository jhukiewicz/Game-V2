package Items.PlayerInventory;

import Items.Armour.Armour;
import Items.Armour.Chest;
import Items.Armour.Head;
import Items.Armour.Legs;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private Chest chestArmour;
    private Head headArmour;
    private Legs legsArmour;

    private List<Armour> armours = new ArrayList<>() {{
        add(headArmour);
        add(chestArmour);
        add(legsArmour);
    }};

    public Inventory() {
    }


    public Chest getChestArmour() {
        if (chestArmour == null) {
            return null;
        }
        return chestArmour;
    }

    public void setChestArmour(Chest chestArmour) {
        this.chestArmour = chestArmour;
    }

    public Head getHeadArmour() {
        if (headArmour == null) {
            return null;
        }
        return headArmour;
    }

    public void setHeadArmour(Head headArmour) {
        this.headArmour = headArmour;
    }

    public Legs getLegsArmour() {
        if (legsArmour == null) {
            return null;
        }
        return legsArmour;
    }

    public void setLegsArmour(Legs legsArmour) {
        this.legsArmour = legsArmour;
    }

    public List<Armour> getArmours() {
        return armours;
    }

    public void setArmours(List<Armour> armours) {
        this.armours = armours;
    }

}
