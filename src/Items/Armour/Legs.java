package Items.Armour;

import Characters.Player;
import Items.Item;

public class Legs extends Armour {

    public Legs(String name, double bonusDef) {
        super(name, bonusDef, ArmourType.LEGS);
    }

    @Override
    public boolean use(Player player) {
        if (player.getInventory().getLegsArmour()!=null){
            Item currentlyEquipped = player.getInventory().getLegsArmour();
            if (!player.getBackpack().getBackpack().contains(currentlyEquipped)) {
                player.getBackpack().putInBackpack(player.getInventory().getLegsArmour());
            }
        }
        player.getInventory().setLegsArmour(this);
        player.getInventory().getArmours().set(2,this);
        player.getBackpack().getBackpack().remove(this);
        return true;
    }


}
