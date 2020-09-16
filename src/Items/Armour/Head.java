package Items.Armour;

import Characters.Player;
import Items.Item;

public class Head extends Armour {

    public Head(String name, double bonusDef) {
        super(name, bonusDef, ArmourType.HEAD);
    }

    @Override
    public boolean use(Player player) {
        if (player.getInventory().getHeadArmour()!=null){
            Item currentlyEquipped = player.getInventory().getHeadArmour();
            if (!player.getBackpack().getBackpack().contains(currentlyEquipped)) {
                player.getBackpack().putInBackpack(player.getInventory().getHeadArmour());
            }
        }
        player.getInventory().setHeadArmour(this);
        player.getInventory().getArmours().set(1,this);
        player.getBackpack().getBackpack().remove(this);
        return true;
    }




}
