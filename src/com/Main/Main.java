package com.Main;

import Characters.Enemies.Dragon;
import Characters.Enemies.Monster;
import Characters.Enemies.Slime;
import Characters.Player;
import Items.Armour.Armour;
import Items.Armour.Chest;
import Items.Armour.Head;
import Items.Armour.Legs;
import Items.Item;
import Items.PlayerInventory.Backpack;
import Items.Potions.Potion;
import Items.Potions.PotionTypes;
import Items.Potions.PotionsSack;
import Maps.Location;
import Maps.Locations;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

//        Game.start();
        Player player = new Player("Murt", 100, 50);
        Monster dragon = new Dragon();
        Potion potion1 = new Potion(PotionTypes.SMALL);
        Potion potion2 = new Potion(PotionTypes.MEDIUM);
//
//
//        System.out.println(player.getHp());
//        player.getPotionsSack().addPotion(potion1);
//        player.getPotionsSack().addPotion(potion2);
//
//
        player.getBackpack().putInBackpack(new Chest("DUZY zbrojka",15));
        player.getBackpack().putInBackpack(new Chest("mala zbroja",15));
        player.getBackpack().putInBackpack(new Head("duzy kask",15));
        player.getBackpack().putInBackpack(new Legs("male nogawki",15));

//        Game.browseItems(player);

//        Combat.fight(player,dragon);


//        Combat.usePotion(player,scanner);




//        Combat.fight(player,dragon);
//        Game.start();
Game.browseItems(player,scanner);



    }
}
