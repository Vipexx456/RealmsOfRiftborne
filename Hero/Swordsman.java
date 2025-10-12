package Hero;

public class Swordsman extends Hero {
    private String skill1 = "Blade Dance";
    private String skill2 = "Blinding Silhouette";
    private String ultimate = "Shattered Sun";
    private int manaCostSkill1 = 50;
    private int manaCostSkill2 = 100;
    private int manaCostUltimate = 250; 
    private int manaCapacity = getMana();

    public Swordsman() {
        super(4000, 500, 700, 350, 100, 0, 0, "Kael Solmere", "Swordsman", "Wooden Sword", "Blade Dance", "Blinding Silhouette", "Shattered Sun");
    }
    
    @Override
    public int basicAttack() {
        int damage = multiplierB(getAttack(), getLevel());
        System.out.println(getName() + " used Basic Attack!");
        System.out.println("Basic Attack deals " + damage + " damage!");

        double manaRecovery = manaCapacity * 0.2;

        if(manaRecovery+getMana() > manaCapacity){
            setMana(manaCapacity);
        } else {
            int addMana = (int) manaRecovery + getMana();
            setMana(addMana);
        }

        return damage;
    }

    @Override
    public int skill1(){
        int damage = multiplier1(getAttack(), getLevel());
        System.out.println(getName() + " used " + skill1 + "!");
        System.out.println(skill1 + " deals " + damage + " damage!");

        int manaReduce = getMana() - manaCostSkill1;
        setMana(manaReduce);

        return damage;
    }

    @Override
    public int skill2(){
        int damage = multiplier2(getAttack(), getLevel());
        System.out.println(getName() + " used " + skill2 + "!");
        System.out.println(skill2 + " deals " + damage + " damage!");

        int manaReduce = getMana() - manaCostSkill2;
        setMana(manaReduce);

        return damage;
    }

    @Override
    public int ultimate(){
        int damage = multiplierU(getAttack(), getLevel());
        System.out.println(getName() + " used " + ultimate + "!");
        System.out.println(ultimate + " deals " + damage + " damage!");

        int manaReduce = getMana() - manaCostUltimate;
        setMana(manaReduce);

        return damage;
    }

    // Getters
    public int getManaCostSkill1(){
        return manaCostSkill1;
    }

    public int getManaCostSkill2(){
        return manaCostSkill2;
    }

    public int getManaCostUltimate(){
        return manaCostUltimate;
    }
}