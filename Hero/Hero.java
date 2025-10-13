package Hero;

public class Hero {
    private int hp;
    private int attack;
    private int mana;
    private int defense;
    private int speed;
    private int level;
    private int experience;
    private String name;
    private String charClass;
    private String weapon;
    private String skill1;
    private String skill2;
    private String ultimate;
    private int manaCostSkill1;
    private int manaCostSkill2;
    private int manaCostUltimate;
    private int cooldown1 = 0;
    private int cooldown2 = 0;
    private int cooldownU = 0; 
    private int skillCd1;
    private int skillCd2;
    private int skillCdU;
    private int maxMana;

    public Hero(){ 

    }

    public Hero(int hp, int attack, int mana, int defense, int speed, int level, int experience, String name, String charClass, String weapon, String skill1, String skill2, String ultimate, int manaCostSkill1, int manaCostSkill2, int manaCostUltimate, int skillCd1, int skillCd2, int skillCdU) {
        this.hp = hp;
        this.attack = attack;
        this.mana = mana;
        this.defense = defense;
        this.speed = speed;
        this.level = level;
        this.experience = experience;
        this.name = name;
        this.charClass = charClass;
        this.weapon = weapon;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.ultimate = ultimate;
        this.manaCostSkill1 = manaCostSkill1;
        this.manaCostSkill2 = manaCostSkill2;
        this.manaCostUltimate = manaCostUltimate;
        this.maxMana = mana;
        this.skillCd1 = skillCd1;
        this.skillCd2 = skillCd2;
        this.skillCdU = skillCdU;
    }

    public int basicAttack() {
        int damage = multiplierB(getAttack(), getLevel());
        
        double manaRecovery = maxMana * 0.2;

        if(manaRecovery+getMana() > maxMana){
            setMana(maxMana);
        } else {
            int addMana = (int) manaRecovery + getMana();
            setMana(addMana);
        }

        return damage;
    }

    public int skill1(){
        setCooldown1(skillCd1);

        int damage = multiplier1(getAttack(), getLevel());

        int manaReduce = getMana() - manaCostSkill1;
        setMana(manaReduce);

        return damage;
    }

    public int skill2(){
        setCooldown2(skillCd2);

        int damage = multiplier2(getAttack(), getLevel());

        int manaReduce = getMana() - manaCostSkill2;
        setMana(manaReduce);

        return damage;
    }

    public int ultimate(){
        setCooldownU(skillCdU);

        int damage = multiplierU(getAttack(), getLevel());

        int manaReduce = getMana() - manaCostUltimate;
        setMana(manaReduce);

        return damage;
    }

    //damage multiplier methods
    public static int multiplierB(int atk, int L) {
        double multiplier = 1.0 + Math.pow((L - 1) / 59.0, 2);
        double damageDealt = atk * multiplier;
        return (int) Math.round(damageDealt);
    }

    public static int multiplier1(int atk, int L) {
        double multiplier = 1.0 + 1.5 * Math.pow((L - 1) / 59.0, 2);
        double damageDealt = atk * multiplier;
        return (int) Math.round(damageDealt);
    }

    public static int multiplier2(int atk, int L) {
        double multiplier = 1.0 + 2.0 * Math.pow((L - 1) / 59.0, 2);
        double damageDealt = atk * multiplier;
        return (int) Math.round(damageDealt);
    }

    public static int multiplierU(int atk, int L) {
        double multiplier = 1.0 + 2.5 * Math.pow((L - 1) / 59.0, 2);
        double damageDealt = atk * multiplier;
        return (int) Math.round(damageDealt);
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

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public String getName() {
        return name;
    }

    public String getCharClass() {
        return charClass;
    }

    public String getWeapon() {
        return weapon;
    }

    public String getSkill1() {
        return skill1;
    }

    public String getSkill2() {
        return skill2;
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

    public int getManaCostUltimate(){
        return manaCostUltimate;
    }

    public int getCooldown1() {
        return cooldown1;
    }

    public int getCooldown2() {
        return cooldown2;
    }

    public int getCooldownU() {
        return cooldownU;
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

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void setCooldown1(int cd1) {
        cooldown1 = cd1;
    }

    public void setCooldown2(int cd2) {
        cooldown2 = cd2;
    }

    public void setCooldownU(int cdU) {
        cooldownU = cdU;
    }

    // Javines _________________________________________________________________________________________

    // Start Menu Progress _____________________________________________________________________________
    private boolean hasVisitedPrologue = false;

    public boolean hasVisitedPrologue(){
        return hasVisitedPrologue;
    }

    public void setHasVisitedPrologue(boolean done){
        this.hasVisitedPrologue = done;
    }

    // Main Menu Progress________________________________________________________________________________

    private boolean hasVisitedShop = false;
    private boolean hasOpenedInventory = false;
    private boolean hasVisitedAcademy = false;
    private boolean hasVisitedArea1 = false;
    private boolean hasVisitedArea2 = false;
    private boolean hasVisitedArea3 = false;

    public boolean hasVisitedShop(){
        return hasVisitedShop;
    }

    public void setHasVisitedShop(boolean done){
        this.hasVisitedShop = done;
    }

    public boolean hasOpenedInventory(){
        return hasOpenedInventory;
    }

    public void setHasOpenedInventory(boolean done){
        this.hasOpenedInventory = done;
    }

    public boolean hasVisitedAcademy(){
        return hasVisitedAcademy;
    }

    public void setHasVisitedAcademy(boolean done){
        this.hasVisitedAcademy = done;
    }

    public boolean hasVisitedArea1(){
        return hasVisitedArea1;
    }

    public void setHasVisitedArea1(boolean done){
        this.hasVisitedArea1 = done;
    }

    public boolean hasVisitedArea2(){
        return hasVisitedArea2;
    }

    public void setHasVisitedArea2(boolean done){
        this.hasVisitedArea2 = done;
    }

    public boolean hasVisitedArea3(){
        return hasVisitedArea3;
    }

    public void setHasVisitedArea3(boolean done){
        this.hasVisitedArea3 = done;
    }

    //Academy Progress____________________________________________________________________________________

    private boolean hasVisitedGym = false;
    private boolean hasVisitedLibrary = false;
    private boolean hasVisitedOffice = false;

    public boolean hasVisitedLibrary() { 
        return hasVisitedLibrary; 
    }
    public void setVisitedLibrary(boolean visited) { 
        this.hasVisitedLibrary = visited; 
    }

    public boolean hasVisitedGym() { 
        return hasVisitedGym; 
    }

    public void setVisitedGym(boolean visited) { 
        this.hasVisitedGym = visited; 
    }

    public boolean hasVisitedOffice() { 
        return hasVisitedOffice; 
    }
    public void setVisitedOffice(boolean visited) { 
        this.hasVisitedOffice = visited; 
    }

    // Library Quest Progress_____________________________________________________________________________

    private boolean libraryQuest1Done = false;
    private boolean libraryQuest2Done = false;
    private boolean riddle1Done = false;
    private boolean riddle2Done = false;
    private boolean riddle3Done = false;

    public boolean isLibraryQuest1Done() { 
        return libraryQuest1Done; 
    }

    public void setLibraryQuest1Done(boolean done) { 
        this.libraryQuest1Done = done; 
    }

    public boolean isLibraryQuest2Done() { 
        return libraryQuest2Done; 
    }

    public void setLibraryQuest2Done(boolean done) { 
        this.libraryQuest2Done = done; 
    }

    public boolean isRiddle1Done(){
        return riddle1Done;
    }

    public boolean isRiddle2Done(){
        return riddle2Done;
    }

    public boolean isRiddle3Done(){
        return riddle3Done;
    }

    public void setRiddle1Done(boolean done){
        this.riddle1Done = done;
    }

    public void setRiddle2Done(boolean done){
        this.riddle2Done = done;
    }

    public void setRiddle3Done(boolean done){
        this.riddle3Done = done;
    }

    public boolean isAllRiddlesDone() {
        return riddle1Done && riddle2Done && riddle3Done;
    }

    public boolean isRiddleQuestDone() {
        return isAllRiddlesDone();
    }

    // Area Progress
    // Office Progress______________________________________________________________________________
    private boolean canEnterArea1 = false;
    private boolean canEnterArea2 = false;
    private boolean canEnterArea3 = false;
    private boolean haveEntered = false;

    public boolean haveEntered() {
        return haveEntered;
    }

    public void setHaveEntered(boolean done) {
        this.haveEntered = done;
    }

    public boolean canEnterArea1() {
        return canEnterArea1; 
    }

    public boolean canEnterArea2() { 
        return canEnterArea2; 
    }

    public boolean canEnterArea3() { 
        return canEnterArea3; 
    }

    public void unlockArea1() { 
        canEnterArea1 = true; 
    }

    public void unlockArea2() { 
        canEnterArea2 = true; 
    }

    public void unlockArea3() { 
        canEnterArea3 = true; 
    }

    // Training progress_______________________________________________________________________________
    private boolean finishedEndurance = false;
    private boolean finishedStrength = false;
    private boolean finishedDurability = false;
    private boolean finishedManaRefinement = false;
    private int numberOfTrainingFinished = 0;
    private boolean finishedAllTraining = false;
    private boolean haveExploredButExited = false;
    private boolean haveAcceptedButExited = false;

    public boolean hasFinishedEndurance() { 
        return finishedEndurance; 
    }

    public void setFinishedEndurance(boolean finishedEndurance) { 
        this.finishedEndurance = finishedEndurance; 
    }

    public boolean hasFinishedStrength() { 
        return finishedStrength; 
    }

    public void setFinishedStrength(boolean finishedStrength) { 
        this.finishedStrength = finishedStrength; 
    }

    public boolean hasFinishedDurability() { 
        return finishedDurability; 
    }

    public void setFinishedDurability(boolean finishedDurability) { 
        this.finishedDurability = finishedDurability; 
    }

    public boolean hasFinishedManaRefinement() {
         return finishedManaRefinement; 
    }

    public void setFinishedManaRefinement(boolean finishedManaRefinement) { 
        this.finishedManaRefinement = finishedManaRefinement; 
    }

    public int getNumberOfTrainingFinished() { 
        return numberOfTrainingFinished; 
    }

    public void setNumberOfTrainingFinished(int numberOfTrainingFinished) { 
        this.numberOfTrainingFinished = numberOfTrainingFinished; 
    }

    public boolean hasFinishedAllTraining(){
        return finishedAllTraining;
    }

    public void setFinishedAllTraining(boolean done){
        this.finishedAllTraining = true;
    }

    public boolean haveExploredButExited(){
        return haveExploredButExited;
    }

    public void setHaveExploredButExited(boolean done){
        this.haveExploredButExited = done;
    }

    public boolean haveAcceptedButExited(){
        return haveAcceptedButExited;
    }

    public void setHaveAcceptedButExited(boolean done){
        this.haveAcceptedButExited = done;
    }

}