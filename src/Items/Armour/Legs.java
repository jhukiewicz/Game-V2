package Items.Armour;

import Characters.Player;

public class Legs extends Armour {

    public Legs(String name, double bonusDef) {
        super(name, bonusDef);
    }

    @Override
    public boolean put(Player player) {
        player.getInventory().setLegsArmour(this);
        player.getInventory().getArmours().set(2,this);
        return true;
    }

    @Override
    public String toString() {
        return super.getName();
    }
}
