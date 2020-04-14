package Items;

public abstract class Potion extends Item {
    private int restoredValue;

    public Potion(String name, int restoredValue) {
        super(name);
        this.restoredValue = restoredValue;
    }
}
