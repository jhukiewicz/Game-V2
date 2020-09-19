package Items.PlayerInventory;

import Characters.Player;
import Items.Item;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BrowseInventory {

    public static boolean browseItems(Player player, Scanner scanner) {
        System.out.println("Equipped items: ");
        for (Item equipped : player.getInventory().getArmours()) {
            if (equipped != null) {
                System.out.println(equipped);
            }
        }
        if (player.getInventory().getWeapon() != null) {
            System.out.println(player.getInventory().getWeapon());
        }


        System.out.println("Your backpack: ");
        player.getBackpack().browseBackpack();


        while (true) {
            System.out.println("\nBonus def: " + player.getBonusDefense());
            System.out.println("Bonus attack: " + player.getBonusAttack());

            System.out.println("Choose option: " +
                    "\n1.Equip item"
                    + "\n2.Quit");


            int decision = 0;
            try {
                decision = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong key!");
                scanner.next();
            }

            switch (decision) {
                case 1:
                    if (!player.getBackpack().getBackpack().isEmpty()) {
                        System.out.println("Chose item: ");
                        player.getBackpack().browseBackpack();
                        try {
                            int selectedItem = scanner.nextInt();
                            player.useItem(player.getBackpack().getBackpack().get(selectedItem - 1));
                        } catch (InputMismatchException | IndexOutOfBoundsException d) {
                            System.out.println("Wrong key!");
                        }
                    } else {
                        System.out.println("Your backpack is empty!");
                        break;
                    }

                case 2:
                    return false;
            }

        }
}}
