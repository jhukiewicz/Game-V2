package Characters;

import Items.Armour.Armour;
import Items.Item;
import Items.PlayerInventory.Backpack;
import Items.PlayerInventory.Inventory;

import java.util.Scanner;

public class Player extends Character {
    private double bonusAttack;
    private double bonusDefense;
    private Backpack backpack;
    private Inventory inventory;


    public Player(String name, int hp, double attackValue) {
        super(name, hp, attackValue);
        this.backpack = new Backpack();
        this.inventory = new Inventory();
    }


    public boolean useItem(Item item) {
        item.use(this);
        updateBonusDefense();
        return true;
    }

    public double updateBonusDefense() {

        double bonusDef = 0;

        for (Armour armour : getInventory().getArmours()) {

            if (armour != null) {
                bonusDef += armour.getBonusDef();
            }
        }

        setBonusDefense(bonusDef);

        return bonusDef;
    }

    @Override
    public double receiveDamage(double value) {
        double receivedDamage = value - (bonusDefense / 100 * value);
        setHp(getHp() - receivedDamage);
        return receivedDamage;
    }


    public static Player createPlayer(){
        System.out.println("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return new Player(name,100,15);
    }



    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public double attack() {
        return getAttackValue() + bonusAttack;
    }


    public double getBonusAttack() {
        return bonusAttack;
    }

    public void setBonusAttack(double bonusAttack) {
        this.bonusAttack = bonusAttack;
    }

    public double getBonusDefense() {
        return bonusDefense;
    }

    public void setBonusDefense(double bonusDefense) {
        this.bonusDefense = bonusDefense;
    }
}
