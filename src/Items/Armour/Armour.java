package Items.Armour;

import Characters.Player;
import Items.Item;

public abstract class Armour extends Item {
    private double bonusDef;

    public Armour(String name, double bonusDef) {
        super(name);
        this.bonusDef = bonusDef;
    }


    public double getBonusDef() {
        return bonusDef;
    }
}
