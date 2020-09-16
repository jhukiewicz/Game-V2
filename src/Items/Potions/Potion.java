package Items.Potions;

import Characters.Player;
import Items.Item;

public class Potion extends Item {
    private int restoredValue;
    private PotionTypes type;

    public Potion(PotionTypes type) {
        this.type = type;
        switch (type) {
            case SMALL:
                restoredValue = 25;
                super.setName("Small Potion");
                break;
            case MEDIUM:
                restoredValue = 50;
                super.setName("Medium Potion");
                break;
            case LARGE:
                restoredValue = 100;
                super.setName("Large Potion");
                break;
        }
    }

    @Override
    public boolean use(Player player) {
        player.setHp(player.getHp() + this.restoredValue);
        System.out.println("Restored " + restoredValue + " hp!");
        return true;
    }


    public int getRestoredValue() {
        return restoredValue;
    }


}
