package Items.Armour;

import Characters.Player;

public class Head extends Armour {

    public Head(String name, double bonusDef) {
        super(name, bonusDef, ArmourType.HEAD);
    }

    @Override
    public boolean use(Player player) {
        if (player.getInventory().getHeadArmour()!=null){
            player.getBackpack().putInBackpack(player.getInventory().getHeadArmour());
        }
        player.getInventory().setHeadArmour(this);
        player.getInventory().getArmours().set(0,this);
        return true;
    }



    @Override
    public String toString() {
        return super.getName();
    }
}
