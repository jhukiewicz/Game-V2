package com.Main;

import Characters.Enemies.Monster;
import Characters.Player;
import Maps.Directions;
import Maps.Locations;

import java.util.Map;
import java.util.Scanner;

public class Game {

     static void start(){
        System.out.println("Welcome in adventure game v.2!\n");
        Player player = Player.createPlayer();
        Monster monster;
        Locations locations = new Locations();

         Scanner scanner = new Scanner(System.in);
        int loc = 0;
        while (true){
            System.out.println(locations.getLocations().get(loc).getDescription());
            System.out.println("Choose direction. Available directions: ");
            Map<Directions, Integer> exits = locations.getLocations().get(loc).getExits();

            for (Directions exit: exits.keySet()){
                System.out.println(exit + " ");
            }
            System.out.println();

            Directions direction = Locations.convertToEnum(scanner.nextLine());

            if (exits.containsKey(direction)){
                loc=exits.get(direction);
            }else {
                System.out.println("You cannot go in that direction");
            }

        }



    }


}
