package Maps;

import Characters.Enemies.*;
import Items.Armour.Chest;
import Items.Armour.Head;
import Items.Armour.Legs;
import Items.Potions.Potion;
import Items.Potions.PotionTypes;
import Items.Weapon.Weapon;

public class ConfigureLocations {
    public static void addMonstersAndItems(Locations locations) {
        locations.getLocations().get(1).setMonster(new Slime());
        locations.getLocations().get(3).setMonster(new Slime());
        locations.getLocations().get(8).setMonster(new Skeleton());
        locations.getLocations().get(11).setMonster(new Skeleton());
        locations.getLocations().get(15).setMonster(new Skeleton());
        locations.getLocations().get(16).setMonster(new Slime());
        locations.getLocations().get(22).setMonster(new Orc());
        locations.getLocations().get(24).setMonster(new Ogre());
        locations.getLocations().get(29).setMonster(new Skeleton());
        locations.getLocations().get(33).setMonster(new Ogre());
        locations.getLocations().get(34).setMonster(new Dragon());

        locations.getLocations().get(1).setItem(new Chest("Leather Chest Armour", 10));
        locations.getLocations().get(3).setItem(new Potion( PotionTypes.SMALL));
        locations.getLocations().get(8).setItem(new Head("Old Helmet", 5));
        locations.getLocations().get(11).setItem(new Legs("Leather pants", 5));
        locations.getLocations().get(15).setItem(new Potion( PotionTypes.MEDIUM));
        locations.getLocations().get(16).setItem(new Chest("Chain mail", 15));
        locations.getLocations().get(22).setItem(new Potion(PotionTypes.LARGE));
        locations.getLocations().get(29).setItem(new Legs("Chausses", 10));
        locations.getLocations().get(33).setItem(new Head("Iron Helmet", 8));
        locations.getLocations().get(7).setItem(new Potion(PotionTypes.SMALL));
        locations.getLocations().get(12).setItem(new Head("Iron Helmet", 8));
        locations.getLocations().get(6).setItem(new Weapon("Iron Sword", 8));
        locations.getLocations().get(28).setItem(new Weapon("Two Handed Sword of Doom™", 20));


    }
}
