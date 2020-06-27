package com.Main;

import Characters.Enemies.Monster;
import Characters.Player;
import Characters.Character;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Combat {


    public static boolean fight(Player player, Monster monster) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You encountered " + monster.getName() + "! \n");

        int action = 0;
        while (monster.isAlive() && player.isAlive()) {

            System.out.println("Choose your action. Press: \n" +
                    "1.Attack\n" +
                    "2.Use potion");

            System.out.println(player.getName() + " hp: " + player.getHp() + "\n"
                    + monster.getName() + " hp: " + monster.getHp());

            try {
                action = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong key!");
                scanner.next();
            }

            switch (action) {
                case 1:
                    System.out.println(player.getName() + " attacks and deals " + attack(player, monster) + " damage!");
                    System.out.println(monster.getName() + " attacks and deals " + attack(monster, player) + " damage!");
                    break;
                case 2:
                    if (usePotion(player, scanner)) {
                        System.out.println(monster.getName() + "attacks and deals " + attack(monster, player) + " damage!");
                        break;
                    }
            }
        }


        if (!player.isAlive()) {
            return false;
        } else {
            return true;

        }
    }

    public static double attack(Character character1, Character character2) {

        return character2.receiveDamage(character1.attack());
    }

    public static boolean usePotion(Player player, Scanner scanner) {

        System.out.println("Select potion");

        while (true) {
            for (int i = 0; i <= 2; i++) {
                if (i == 0) {
                    System.out.println("1.Small potion (" + player.getPotionsSack().getPotions().get(i).size() + ")");
                } else if (i == 1) {
                    System.out.println("2.Medium potion (" + player.getPotionsSack().getPotions().get(i).size() + ")");
                } else {
                    System.out.println("3.Large potion (" + player.getPotionsSack().getPotions().get(i).size() + ")");
                }
            }
            System.out.println("4.Quit");

            int decision = -1;
            try {
                decision = scanner.nextInt() - 1;
            } catch (InputMismatchException e) {
                System.out.println("Wrong key! Use numbers only.");
                scanner.next();
            }

//            scanner.nextLine();

            if (decision >= 0 && decision < 3) {
                try {
                    player.useItem(player.getPotionsSack().getPotions().get(decision).get(0));
                    player.getPotionsSack().getPotions().get(decision).remove(0);
                    return true;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("You don't have that kind of potion!");
                }
            } else if (decision == 3) {
                return false;
            }
        }
    }
}
