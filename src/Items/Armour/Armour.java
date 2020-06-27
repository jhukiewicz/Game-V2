package Items.Armour;

import Characters.Player;
import Items.Item;

public abstract class Armour extends Item {
    private double bonusDef;
    private final ArmourType ARMOUR_TYPE;

    public Armour(String name, double bonusDef, ArmourType armourType) {
        super(name);
        this.bonusDef = bonusDef;
        this.ARMOUR_TYPE = armourType;
    }

    public double getBonusDef() {
        return bonusDef;
    }



}
