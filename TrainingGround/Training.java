package TrainingGround;

import Hero.*;
import Menu.*;
import Narration.TrainingNarration;
import TrainingGround.Training;

import java.util.Scanner;
import java.util.Random;

public class Training {

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    private TrainingMenu trainingMenuHandler = new TrainingMenu(this);
    private TrainingNarration narrationHandler = new TrainingNarration();
    private StatProgress statProgressHandler = new StatProgress();


    public void trainingGround(Hero hero){

        if(!hero.haveExploredButExited()){
            narrationHandler.exploreNarration();
            hero.setHaveExploredButExited(true);
        }

        if(hero.hasFinishedAllTraining()){

                System.out.println();
                System.out.println("┌──────────────────────────────────────────────┐");
                System.out.println("│     You have completed your training quest   │");
                System.out.println("│        Exiting from training ground...       │");
                System.out.println("└──────────────────────────────────────────────┘");
                return;
        }

        boolean isValid = true;

        while (isValid) {
            System.out.println();
            System.out.println("┌──────────────────────────────────────────────────────┐");
            System.out.println("│    Do you want to accept the training offer? (y/n)   │");
            System.out.println("└──────────────────────────────────────────────────────┘");
            System.out.print(">>> ");

            String wouldAccept = scanner.nextLine();

            if(!hero.haveAcceptedButExited()){
                narrationHandler.acceptedTraining();
                hero.setHaveAcceptedButExited(true);
            }

            if (wouldAccept.equalsIgnoreCase("y")) {
                startTrainingLoop(hero);
                isValid = false; 
            } else if (wouldAccept.equalsIgnoreCase("n")) {
                System.out.println();
                System.out.println("┌──────────────────────────────────────────────┐");
                System.out.println("│           Training offer declined            │");
                System.out.println("│           Exiting from the Gym...            │");
                System.out.println("└──────────────────────────────────────────────┘");

                isValid = false;
                return;
            } else {
                System.out.println();
                System.out.println("┌──────────────────────────────────────────────┐");
                System.out.println("│        Invalid input! Try again...           │");
                System.out.println("└──────────────────────────────────────────────┘");
            }
        }

        return;
    }

    public void startTrainingLoop(Hero hero) {
        boolean continueTraining = true;

        int originalHp = hero.getHp();
        int originalAtk = hero.getAttack();
        int originalDef = hero.getDefense(); 
        int originalMana = hero.getMana(); 
        int originalSpeed = hero.getSpeed();
        int originalExperience = hero.getExperience();
        int originalLevel = hero.getLevel();

        while (continueTraining) {

            //trainingAccepted(hero);

            if(hero.getNumberOfTrainingFinished() == 4){
                System.out.println();
                System.out.println("┌──────────────────────────────────────────────────────┐");
                System.out.println("│  You have finished your training. Congratulations!   │");
                System.out.println("└──────────────────────────────────────────────────────┘");

                statProgressHandler.displayXPandLevel(hero, 2500);

                hero.setFinishedAllTraining(true);
                break;
            }

            boolean isValidInput = false;

            while (!isValidInput) {
                System.out.println();
                System.out.println("┌──────────────────────────────────────────────┐");
                System.out.println("│    Do you want to continue training? (y/n)   │");
                System.out.println("└──────────────────────────────────────────────┘");
                System.out.print(">>> ");

                String continueChoice = scanner.nextLine();

                if (continueChoice.equalsIgnoreCase("y")) {
                    trainingMenuHandler.trainingMenu(hero);
                    isValidInput = true; 
                } 
                else if (continueChoice.equalsIgnoreCase("n")) {
                    System.out.println();
                    System.out.println("┌───────────────────────────────────────────────────┐");
                    System.out.println("│        Are you sure you want to quit? (y/         │");
                    System.out.println("│    Any training progress will not be recorded     │");
                    System.out.println("└───────────────────────────────────────────────────┘");

                    System.out.print(">>> ");
                    String confirmQuit = scanner.nextLine();

                    if (confirmQuit.equalsIgnoreCase("y")) {
                        System.out.println();
                        System.out.println("┌──────────────────────────────────────────┐");
                        System.out.println("│ You decided to end your training session │");
                        System.out.println("└──────────────────────────────────────────┘");

                        if (!hero.hasFinishedAllTraining()) {
                            hero.setHp(originalHp);
                            hero.setAttack(originalAtk);
                            hero.setDefense(originalDef);
                            hero.setMana(originalMana);
                            hero.setSpeed(originalSpeed);
                            hero.setExperience(originalExperience); 
                            hero.setLevel(originalLevel);

                            hero.setFinishedEndurance(false);
                            hero.setFinishedStrength(false);
                            hero.setFinishedDurability(false);
                            hero.setFinishedManaRefinement(true);
                            hero.setNumberOfTrainingFinished(0);
                            hero.setFinishedAllTraining(false);
                            
                            System.out.println("┌───────────────────────────────────────┐");
                            System.out.println("│       Your progress was reset         │");
                            System.out.println("└───────────────────────────────────────┘");

                        }
                    
                        System.out.println("┌──────────────────────────────────────────────┐");
                        System.out.println("│     Exiting from the Training Ground...      │");
                        System.out.println("│            Exiting from the Gym              │");
                        System.out.println("└──────────────────────────────────────────────┘");

                        return; 
                    } 
                    else if (confirmQuit.equalsIgnoreCase("n")) {
                        System.out.println();
                        System.out.println("┌──────────────────────────────────────────────┐");
                        System.out.println("│          Continuing your training...         │");
                        System.out.println("└──────────────────────────────────────────────┘");

                        isValidInput = true;
                    } 
                    else {
                        System.out.println();
                        System.out.println("┌───────────────────────────────────────────────────────────┐");
                        System.out.println("│       Invalid input! Continuing training by default       │");
                        System.out.println("└───────────────────────────────────────────────────────────┘");

                        isValidInput = true;
                    }
                } 
                else {
                    System.out.println();
                    System.out.println("┌──────────────────────────────────────────────┐");
                    System.out.println("│           Invalid input! Try again           │");
                    System.out.println("└──────────────────────────────────────────────┘");

                }
            }
        }
 
        System.out.println("┌──────────────────────────────────────────────┐");
        System.out.println("│     Exiting from the Training Ground...      │");
        System.out.println("│            Exiting from the Gym              │");
        System.out.println("└──────────────────────────────────────────────┘");

    }

    public void sparringMechanism(Hero hero, String trainingType){
        int chanceofWin = random.nextInt(10);
        StatProgress statProgressHandler = new StatProgress();

        if(chanceofWin < 7){
            hero.setNumberOfTrainingFinished(hero.getNumberOfTrainingFinished() + 1);
            System.out.println();
            System.out.println("┌───────────────────────────────┐");
            System.out.println("│     Success! You did well!    │");
            System.out.println("└───────────────────────────────┘");

            switch(trainingType.toLowerCase()){
                case "endurance":
                    hero.setFinishedEndurance(true);
                    statProgressHandler.endurance(hero);
                    break;

                case "strength":
                    hero.setFinishedStrength(true);
                    statProgressHandler.strength(hero);
                    break;

                case "durability":
                    hero.setFinishedDurability(true);
                    statProgressHandler.durability(hero);
                    break;

                case "mana refinement":
                    hero.setFinishedManaRefinement(true);
                    statProgressHandler.mana(hero);
                    break;
            } 


        } else {
            System.out.println();
            System.out.println("┌───────────────────────────────────┐");
            System.out.println("│    Defeated. You still did well   │");
            System.out.println("└───────────────────────────────────┘");

        }
    }

    public void generalTrainingPrompt(Hero hero, String trainingType){

        System.out.println();
        System.out.println("┌──────────────────────────────────────────────┐");
        System.out.println("│            Training is on-going...           │");
        System.out.println("│          Press enter to continue...          │");
        System.out.println("└──────────────────────────────────────────────┘");

        String[] timeDelay = {
            ">>> Battle is on going... Please wait... <<<", 
            ">>> Battle is on going... Please wait... <<<", 
            ">>> Battle is on going... Please wait... <<<", 
            ">>> Battle is on going... Please wait... <<<", 
            ">>> Battle is on going... Please wait... <<<"
        };

        for(int i = 0; i < timeDelay.length; i++){
            scanner.nextLine();
            System.out.println(timeDelay[i]);
        }

        sparringMechanism(hero, trainingType);

        return;

    }


}
