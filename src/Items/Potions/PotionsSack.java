package Items.Potions;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PotionsSack {

    private List<Potion> smallPotions = new ArrayList<>();
    private List<Potion> mediumPotions = new ArrayList<>();
    private List<Potion> largePotions = new ArrayList<>();
    private Map<Integer, List<Potion>> potions = new HashMap<>();


    public PotionsSack() {
        potions.put(0, smallPotions);
        potions.put(1, mediumPotions);
        potions.put(2, largePotions);


    }

    public boolean addPotion(Potion potion) {
        if (potion != null) {
            switch (potion.getRestoredValue()) {
                case 25:
                    potions.get(0).add(potion);
                    break;
                case 50:
                    potions.get(1).add(potion);
                    break;
                case 100:
                    potions.get(2).add(potion);
                    break;
            }
            return true;
        }
        return false;
    }

    public Map<Integer, List<Potion>> getPotions() {
        return potions;
    }

}
