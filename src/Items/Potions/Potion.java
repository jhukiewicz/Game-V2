package Items.Potions;

import Characters.Player;
import Items.Item;

public class Potion extends Item {
    private int restoredValue;
    private PotionTypes type;

    public Potion(PotionTypes type) {
        this.type = type;
        switch (type){
            case SMALL:
                restoredValue = 25;
                break;
            case MEDIUM:
                restoredValue = 50;
                break;
            case LARGE:
                restoredValue = 100;
                break;
        }
    }

    @Override
    public boolean use(Player player) {
        player.setHp(player.getHp()+this.restoredValue);
        System.out.println("dodaje " + restoredValue +"hp");
        return true;
    }

    public PotionTypes getType() {
        return type;
    }

    public int getRestoredValue() {
        return restoredValue;
    }
}
