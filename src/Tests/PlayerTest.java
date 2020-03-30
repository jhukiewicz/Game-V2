package Tests;

import Characters.Player;
import Items.Armour.Armour;
import Items.Armour.Chest;
import Items.Armour.Legs;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;

    @org.junit.Before
    public void setup(){
        player = new Player("Player",100,20);
    }


    @org.junit.Test
    public void putArmour_notNull(){
        Armour armour = new Chest("Leather Chest",15);
        assertTrue(player.putArmour(armour));
    }

    @org.junit.Test
    public void putArmour_null(){
        Armour armour = null;
        assertFalse(player.putArmour(armour));
    }

    @org.junit.Test
    public void receiveDamage_noDefence() {
        player.receiveDamage(50);
        assertEquals(50,player.getHp(),0);
    }

    @org.junit.Test
    public void receiveDamage_withDefence() {
        player.putArmour(new Chest("Chest armour",15));
        player.receiveDamage(50);
        assertEquals(57.5,player.getHp(),0);
    }

    @org.junit.Test
    public void attack() {
        player.setBonusAttack(10);
        assertEquals(30,player.attack(),0);
    }

    @org.junit.Test
    public void isAlive_true(){
        assertTrue(player.isAlive());
    }

    @org.junit.Test
    public void isAlive_false(){
        player.receiveDamage(100);
        assertFalse(player.isAlive());
    }

    @org.junit.Test
    public void uptadeBonusDefense(){
        Armour armour = new Chest("Chest armour",15);
        Armour armour1 = new Legs("Legs armour", 20);

        player.putArmour(armour);
        player.putArmour(armour1);

        assertEquals(35,player.getBonusDefense(),0);
    }
}