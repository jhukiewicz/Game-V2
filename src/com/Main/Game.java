package com.Main;

import Characters.Enemies.*;
import Characters.Player;
import Items.Armour.Chest;
import Items.Armour.Head;
import Items.Armour.Legs;
import Items.Item;
import Items.PlayerInventory.BrowseInventory;
import Items.Potions.Potion;
import Items.Potions.PotionTypes;
import Items.Weapon.Weapon;
import Maps.ConfigureLocations;
import Maps.Directions;
import Maps.Locations;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Game {

    static void start() {
        System.out.println("Welcome in adventure game v.2!\n");
        Player player = Player.createPlayer();
        Locations locations = new Locations();

        Scanner scanner = new Scanner(System.in);
        ConfigureLocations.addMonstersAndItems(locations);
        player.getPotionsSack().addPotion(new Potion(PotionTypes.MEDIUM));
        int loc = 0;
        while (true) {
            System.out.println(locations.getLocations().get(loc).getDescription());
            System.out.println("Choose direction. Available directions: ");
            Map<Directions, Integer> exits = locations.getLocations().get(loc).getExits();

            for (Directions exit : exits.keySet()) {
                System.out.println(exit + " ");
            }
            System.out.println();

            System.out.println("Press: " +
                    "\nN,S,E,W to move."+
                    "\n1.Inventory" +
                    "\n2.Use potion");

            String decision = scanner.next();

            Directions direction = Locations.convertToEnum(decision);

            try {
                if (exits.containsKey(direction)) {
                    loc = exits.get(direction);
                } else if (Integer.parseInt(decision) == 1) {
                    BrowseInventory.browseItems(player, scanner);
                } else if (Integer.parseInt(decision) == 2) {
                    Combat.usePotion(player, scanner);
                } else {
                    System.out.println("Wrong key!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong key!");
            }

            if (locations.getLocations().get(loc).getMonster() != null && locations.getLocations().get(loc).getMonster().isAlive()) {
                if (!Combat.fight(player, locations.getLocations().get(loc).getMonster())) {
                    System.out.println("You are dead! Game over!");
                    break;
                } else {
                    System.out.println("You won!");

                }
            }

            System.out.println();

            if (locations.getLocations().get(loc).getItem() != null) {
                System.out.println("Obtained: " + locations.getLocations().get(loc).getItem().getName());
                if (locations.getLocations().get(loc).getItem() instanceof Potion) {
                    player.getPotionsSack().addPotion((Potion) locations.getLocations().get(loc).getItem());
                } else {
                    player.getBackpack().putInBackpack(locations.getLocations().get(loc).getItem());
                }
                locations.getLocations().get(loc).setItem(null);
            }

            if (loc == 34) {
                System.out.println("Congratulations, you have defeated the dragon! Unfortunately your princess is in another castle :(  ");
                break;
            }
        }
    }

}
