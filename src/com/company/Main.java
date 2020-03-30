package com.company;

import Characters.Player;
import Items.Armour.Armour;
import Items.Armour.Chest;
import Items.Armour.Head;
import Items.PlayerInventory.Backpack;

public class Main {

    public static void main(String[] args) {

        Player player = new Player("A",100,40);

        player.setBonusDefense(10);
        player.receiveDamage(50);

        System.out.println(player.getHp());

        Armour armour = new Head("Leather head",15);
        Armour armour1 = new Chest("Chain chest armour", 20);

        player.putArmour(armour);
        player.putArmour(armour1);

        System.out.println(player.getInventory().getHeadArmour()+" "+ player.getInventory().getChestArmour());
        System.out.println(player.getInventory().getArmours());

        Backpack backpack = new Backpack();
       backpack.putInBackpack(armour);

	// write your code here
        //changes 222
        //login
    }
}
