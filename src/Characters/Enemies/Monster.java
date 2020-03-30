package Characters.Enemies;

import Characters.Character;

public abstract class Monster extends Character {

    public Monster(String name, int hp, double attackValue) {
        super(name, hp, attackValue);
    }

    @Override
    public double receiveDamage(double value) {
        return 0;
    }

    @Override
    public double attack() {
        return 0;
    }
}
