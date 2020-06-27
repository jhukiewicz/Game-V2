package Items.Armour;

import Characters.Player;

public class Chest extends Armour {


    public Chest(String name, double bonusDef) {
        super(name, bonusDef, ArmourType.CHEST);
    }

    @Override
    public boolean use(Player player) {
        if (player.getInventory().getChestArmour()!=null){
            player.getBackpack().putInBackpack(player.getInventory().getChestArmour());
        }
        player.getInventory().setChestArmour(this);
        player.getInventory().getArmours().set(1,this);

        return true;
    }

    @Override
    public String toString() {
        return super.getName() + " bonus def: " + super.getBonusDef();
    }
}
