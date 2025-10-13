package Boss;

public class Boss {
    private int hp;
    private int attack;
    private int mana;
    private int defense;
    private int speed;
    private String name;
    private String skill1;
    private String skill2;
    private String skill3;
    private String ultimate;
    private int manaCostSkill1;
    private int manaCostSkill2;
    private int manaCostSkill3;
    private int manaCostUltimate;
    private int cooldown1 = 0;
    private int cooldown2 = 0;
    private int cooldown3 = 0;
    private int cooldownU = 0; 
    private int skillCd1;
    private int skillCd2;
    private int skillCd3;
    private int skillCdU;
    private int maxMana;

    public Boss() {

    }

    public Boss(int hp, int attack, int mana, int defense, int speed, String name, String skill1, String skill2, String skill3, String ultimate, int manaCostSkill1, int manaCostSkill2, int manaCostSkill3, int manaCostUltimate, int skillCd1, int skillCd2, int skillCd3 ,int skillCdU) {
        this.hp = hp;
        this.attack = attack;
        this.mana = mana;
        this.defense = defense;
        this.speed = speed;
        this.name = name;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
        this.ultimate = ultimate;
        this.manaCostSkill1 = manaCostSkill1;
        this.manaCostSkill2 = manaCostSkill2;
        this.manaCostSkill3 = manaCostSkill3;
        this.manaCostUltimate = manaCostUltimate;
        this.maxMana = mana;
        this.skillCd1 = skillCd1;
        this.skillCd2 = skillCd2;
        this.skillCd3 = skillCd3;
        this.skillCdU = skillCdU;
    }

    public int basicAttack() {
        double damage = getAttack() * 1.1;

        double manaRecovery = maxMana * 0.2;

        if(manaRecovery+getMana() > maxMana){
            setMana(maxMana);
        } else {
            int addMana = (int) manaRecovery + getMana();
            setMana(addMana);
        }
        
        return (int) Math.round(damage);
    }

    public int skill1(){
        setCooldown1(skillCd1);

        double damage = getAttack() * 1.5;

        int manaReduce = getMana() - manaCostSkill1;
        setMana(manaReduce);

        return (int) Math.round(damage);
    }

    public int skill2(){
        setCooldown2(skillCd2);

        double damage = getAttack() * 1.8;

        int manaReduce = getMana() - manaCostSkill2;
        setMana(manaReduce);
        
        return (int) Math.round(damage);
    }

    public int skill3(){
        setCooldown3(skillCd3);

        double damage = getAttack() * 1.9;

        int manaReduce = getMana() - manaCostSkill3;
        setMana(manaReduce);

        return (int) Math.round(damage);
    }

    public int ultimate(){
        setCooldownU(skillCdU);

        double damage = getAttack() * 2.3;

        int manaReduce = getMana() - manaCostUltimate;
        setMana(manaReduce);

        return (int) Math.round(damage);
    }


    // Setters
    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setCooldown1(int cd1) {
        cooldown1 = cd1;
    }

    public void setCooldown2(int cd2) {
        cooldown2 = cd2;
    }

    public void setCooldown3(int cd3) {
        cooldown3 = cd3;
    }

    public void setCooldownU(int cdU) {
        cooldownU = cdU;
    }

    // Getters
    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getMana() {
        return mana;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public String getSkill1() {
        return skill1;
    }

    public String getSkill2() {
        return skill2;
    }

    public String getSkill3() {
        return skill3;
    }

    public String getUltimate() {
        return ultimate;
    }

    public int getManaCostSkill1(){
        return manaCostSkill1;
    }

    public int getManaCostSkill2(){
        return manaCostSkill2;
    }

    public int getManaCostSkill3(){
        return manaCostSkill3;
    }

    public int getManaCostUltimate(){
        return manaCostUltimate;
    }

    public int getCooldown1() {
        return cooldown1;
    }

    public int getCooldown2() {
        return cooldown2;
    }

    public int getCooldown3() {
        return cooldown3;
    }

    public int getCooldownU() {
        return cooldownU;
    }
}