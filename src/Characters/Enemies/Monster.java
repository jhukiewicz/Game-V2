package Characters.Enemies;

import Characters.Character;

public abstract class Monster extends Character {

    public Monster(String name, int hp, double attackValue) {
        super(name, hp, attackValue);
    }

    @Override
    public double receiveDamage(double value) {
        setHp(this.getHp()-value);

        if (getHp()<=0){
            setAlive(false);
        }

        return value;
    }

    @Override
    public double attack() {
        return getAttackValue();
    }
}
