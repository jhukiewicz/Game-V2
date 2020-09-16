package Items.Armour;

import Characters.Player;
import Items.Item;

public class Chest extends Armour {


    public Chest(String name, double bonusDef) {
        super(name, bonusDef, ArmourType.CHEST);
    }

    @Override
    public boolean use(Player player) {
        if (player.getInventory().getChestArmour()!=null){
            Item currentlyEquipped = player.getInventory().getChestArmour();
            if (!player.getBackpack().getBackpack().contains(currentlyEquipped)) {
                player.getBackpack().putInBackpack(player.getInventory().getChestArmour());
            }
        }
        player.getInventory().setChestArmour(this);
        player.getInventory().getArmours().set(0,this);
        player.getBackpack().getBackpack().remove(this);
        return true;
    }


}
