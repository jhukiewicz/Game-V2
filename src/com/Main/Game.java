package com.Main;

import Characters.Enemies.*;
import Characters.Player;
import Items.Armour.Armour;
import Items.Armour.Chest;
import Items.Potions.Potion;
import Items.Potions.PotionTypes;
import Maps.Directions;
import Maps.Location;
import Maps.Locations;

import java.util.Map;
import java.util.Scanner;

public class Game {

    static void start() {
        System.out.println("Welcome in adventure game v.2!\n");
        Player player = Player.createPlayer();
        Monster monster = null;
        Locations locations = new Locations();

        Scanner scanner = new Scanner(System.in);
        addMonstersAndItems(locations);
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
                    "\n1.Inventory" +
                    "\n2.Use potion");

            String decision = scanner.nextLine();

            Directions direction = Locations.convertToEnum(decision);

            try {
                if (exits.containsKey(direction)) {
                    loc = exits.get(direction);
                } else if (Integer.parseInt(decision) == 1) {
                    browseItems(player,scanner);
                } else if (Integer.parseInt(decision) == 2) {
                    Combat.usePotion(player, scanner);
                } else {
                    System.out.println("Wrong key!");
                }
            }catch (NumberFormatException e ){
                System.out.println("Wrong key!");
            }

            if (locations.getLocations().get(loc).getMonster() != null && locations.getLocations().get(loc).getMonster().isAlive()) {
                if (!Combat.fight(player, locations.getLocations().get(loc).getMonster())) {
                    System.out.println("You are dead! Game over!");
                    break;
                }else {
                    System.out.println("You won!" );
                    if (locations.getLocations().get(loc).getItem()!=null){
                        System.out.println("Obtained: " + locations.getLocations().get(loc).getItem());
                    player.getBackpack().putInBackpack(locations.getLocations().get(loc).getItem());
                    }

                }
            }

            System.out.println();

            if (loc == 34) {
                break;
            }


        }

    }

    private static void addMonstersAndItems(Locations locations) {
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

        locations.getLocations().get(1).setItem(new Chest("SUperduperchest",44));


    }

    public static boolean browseItems(Player player, Scanner scanner){
        System.out.println("Equipped items: ");
        for (Armour armour : player.getInventory().getArmours()){
            if (armour!=null) {
                System.out.println(armour);
            }
        }

        System.out.println("Your backpack: ");
        player.getBackpack().browseBackpack();



        while (true){
            System.out.println("Choose option: " +
                    "\n1.Equip item"
            +"\n2.Quit");

            int decision = scanner.nextInt();

            switch (decision){
                case 1:
                    System.out.println("Chose item: ");
                    player.getBackpack().browseBackpack();
//                    choseItem(player,scanner);
                    break;
                case 2:
                    return false;
            }


              int selectedItem = scanner.nextInt();

            player.useItem(player.getBackpack().getBackpack().get(selectedItem-1));

        }


    }

//    private static boolean choseItem(Player player, Scanner scanner){
//
//
//    }



}
