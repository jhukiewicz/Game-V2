package Items.Weapon;

import Characters.Player;
import Items.Item;

public class Weapon extends Item {
    private double attackValue;
    public Weapon(String name, double attackValue) {
        super(name);
        this.attackValue = attackValue;
    }

    @Override
    public boolean use(Player player) {
         if(player.getInventory().getWeapon()!=null){
            Item currentlyEquipped = player.getInventory().getWeapon();
            if (!player.getBackpack().getBackpack().contains(currentlyEquipped)) {
                player.getBackpack().putInBackpack(player.getInventory().getWeapon());
            }
        }
        player.getInventory().setWeapon(this);
        player.getBackpack().getBackpack().remove(this);
        return true;
    }

    public double getAttackValue() {
        return attackValue;
    }

    @Override
    public String toString() {
        return super.getName() + " bonus attack: " + getAttackValue();

    }
}
