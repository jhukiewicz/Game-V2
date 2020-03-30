package Characters;

public abstract class Character {
    private String name;
    private double hp;
    private double attackValue;
    private boolean isAlive;

    public Character(String name, int hp, double attackValue ) {
        this.name = name;
        this.hp = hp;
        this.attackValue = attackValue;
        this.isAlive=true;
    }

    public abstract double receiveDamage(double value);
    public abstract double attack();

    public boolean isAlive() {
        if (hp <= 0) {
            isAlive = false;
        }
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getAttackValue() {
        return attackValue;
    }

    public void setAttackValue(double attackValue) {
        this.attackValue = attackValue;
    }

}
