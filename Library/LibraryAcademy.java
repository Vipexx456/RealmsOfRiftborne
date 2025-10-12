package Library;

import Hero.*;
import Narration.LibraryNarration;

import java.util.Scanner;
import java.util.Random;

public class LibraryAcademy {

    private static Scanner scanner = new Scanner(System.in);
    Random random = new Random(System.nanoTime());
    private LibraryQuest questHandler = new LibraryQuest();
    private LibraryNarration narrationHandler = new LibraryNarration();

    public void libraryAcademy (Hero hero){
        boolean isRoam = true;

        while (isRoam) {
            System.out.println();
            System.out.println("┌───────────────────────────────────────────────┐");
            System.out.println("│      Do you want to roam around? (y/n)        │");
            System.out.println("└───────────────────────────────────────────────┘");
            System.out.print(">>> ");
            String roam = scanner.nextLine();

            if (roam.equalsIgnoreCase("y")) {
                System.out.println();

                System.out.println();
                System.out.println("┌───────────────────────────────┐");
                System.out.println("│     Press enter to continue   │");
                System.out.println("└───────────────────────────────┘");

                String[] timeDelay = {
                    ">>> You are now roaming around... <<<", 
                    ">>> You are now roaming around... <<<", 
                    ">>> You are now roaming around... <<<", 
                    ">>> You are now roaming around... <<<", 
                    ">>> You are now roaming around... <<<"
                };

                for(int i = 0; i < timeDelay.length; i++){
                    scanner.nextLine();
                    System.out.println(timeDelay[i]);
                }

                libraryQuests(hero);

            } else if (roam.equalsIgnoreCase("n")) {
                System.out.println();
                System.out.println("┌───────────────────────────────┐");
                System.out.println("│   Exiting from the Library... │");
                System.out.println("└───────────────────────────────┘");
                return;
            } else {
                System.out.println();
                System.out.println("┌─────────────────────────────┐");
                System.out.println("│  Invalid input! Try again.  │");
                System.out.println("└─────────────────────────────┘");

            }
        }

    }

    public void libraryQuests(Hero hero){

        boolean hasAvailableQuest = !hero.isLibraryQuest1Done() || !hero.isAllRiddlesDone();

        if (!hasAvailableQuest) {
            System.out.println();
            System.out.println("┌────────────────────────────────────────────────────────┐");
            System.out.println("│ You\'ve completed all available quests in the library!  │");
            System.out.println("└────────────────────────────────────────────────────────┘");
            return;
        }

        int quests;

        do {
            quests = random.nextInt(2) + 1;
        } while ((quests == 1 && hero.isLibraryQuest1Done()) || (quests == 2 && hero.isLibraryQuest2Done()));

        switch (quests) {
            case 1:
                narrationHandler.findTheLostBookNarration();
                acceptQuest(hero, 1);
                break;

            case 2:
                narrationHandler.riddlesNarration();
                acceptQuest(hero, 2);
                break;

            default:
                System.out.println();
                System.out.println("┌────────────────────────────────────────────────────────────┐");
                System.out.println("│  Something's wrong with the quest system. Come back later. │");
                System.out.println("└────────────────────────────────────────────────────────────┘");
        }

    }

    private void acceptQuest(Hero hero, int questType) {
        boolean validInput = false;

        while (!validInput) {
            System.out.println();
            System.out.println("┌──────────────────────────────────────────────┐");
            System.out.println("│  Do you want to accept this quest? (y/n)     │");
            System.out.println("└──────────────────────────────────────────────┘");
            System.out.print(">>> ");

            String isAccept = scanner.nextLine();

            if (isAccept.equalsIgnoreCase("y")) {
                switch (questType) {
                    case 1:
                        questHandler.findTheLostBook(hero);
                        hero.setLibraryQuest1Done(true);
                        break;
                    case 2:
                        questHandler.riddles(hero); 

                        if(hero.isAllRiddlesDone()){
                            hero.setLibraryQuest2Done(true); 
                        }

                        break;
                }
                validInput = true;

                //displayStats(hero);

            } else if (isAccept.equalsIgnoreCase("n")) {
                System.out.println();
                System.out.println("┌───────────────────────────┐");
                System.out.println("│      Quest Declined!      │");
                System.out.println("└───────────────────────────┘");
                validInput = true;

            } else {
                System.out.println();
                System.out.println("┌────────────────────────────────────┐");
                System.out.println("│     Invalid input. Try again!      │");
                System.out.println("└────────────────────────────────────┘");
            }
        }
    }

}
