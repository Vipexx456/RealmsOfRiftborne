package Menu;

import Hero.*;
import Library.LibraryAcademy;
import TrainingGround.*;
import Office.*;

public class AcademyMenu extends Menu{
 
    //private boolean hasVisitedGym = false; 
    //private boolean hasVisitedOffice = false; 
    //private boolean hasVisitedLibrary = false;

    public void academyMapMenu(Hero hero) {
        boolean academyMapMenu = true;
        Training trainingGroundHandler = new Training();
        LibraryAcademy libraryHandler = new LibraryAcademy();
        PrincipalOffice officeHandler = new PrincipalOffice();

        while (academyMapMenu) {
            System.out.println();
            System.out.println("+-------------------------------------+");
            System.out.println("|  --- MYSTVALE ACADEMY MAP MENU ---  |");
            System.out.println("+-------------------------------------+");
            System.out.println("| [1] Library                         |");
            System.out.println("| [2] Gym                             |");
            System.out.println("| [3] Principal's Office              |");
            System.out.println("| [4] Exit Current Location           |");
            System.out.println("+-------------------------------------+");
            System.out.print(">>> ");

            String academyMapMenuChoice = scanner.nextLine();

            switch (academyMapMenuChoice) {
                case "1":

                    if(!hero.hasVisitedLibrary()){
                        libraryNarration();
                        hero.setVisitedLibrary(true);
                    }

                    System.out.println();
                    System.out.println("┌──────────────────────────────────────────────┐");
                    System.out.println("│        You are now inside the Library        │");
                    System.out.println("└──────────────────────────────────────────────┘");
                    System.out.println("┌──────────────────────────────────────────────┐");
                    System.out.println("│     Shh! Be mindful, others are studying     │");
                    System.out.println("└──────────────────────────────────────────────┘");

                    libraryHandler.libraryAcademy(hero);
                    
                    break;
                
                case "2":
                    System.out.println();
                    System.out.println("┌──────────────────────────────────────────────┐");
                    System.out.println("│    You are now inside the Training Ground    │");
                    System.out.println("└──────────────────────────────────────────────┘");
                    System.out.println("┌────────────────────────────────────────────┐");
                    System.out.println("│             Be ready to train              │");
                    System.out.println("└────────────────────────────────────────────┘");

                    if (!hero.hasVisitedGym()) {
                        gymNarration();
                        hero.setVisitedGym(true);

                    }
                    
                    System.out.println();
                    System.out.println("┌─────────────────────────────────────────────┐");
                    System.out.println("│ Do you want to explore the training ground? │");
                    System.out.println("│                   (y/n)                     │");
                    System.out.println("└─────────────────────────────────────────────┘");
                    System.out.print(">>> ");
                    String exploreInput = scanner.nextLine();

                    if (exploreInput.equalsIgnoreCase("y")) {
                        trainingGroundHandler.trainingGround(hero);
                    } else {
                        System.out.println("┌──────────────────────────────────────────────┐");
                        System.out.println("│     Exiting from the Training Ground...      │");
                        System.out.println("│            Exiting from the Gym              │");
                        System.out.println("└──────────────────────────────────────────────┘");
                        return;
                    }
                    

                    break;

                case "3":
                    
                    if (!hero.hasVisitedOffice()) {
                        principalOfficeNarration();
                        hero.setVisitedOffice(true);
                    } 

                    System.out.println();
                    System.out.println("┌──────────────────────────────────────────────┐");
                    System.out.println("│         You are now inside the Office        │");
                    System.out.println("└──────────────────────────────────────────────┘");
                    System.out.println("┌────────────────────────────────────────────┐");
                    System.out.println("│       May the odds be in your favor        │");
                    System.out.println("└────────────────────────────────────────────┘");
                    System.out.println();

                    officeHandler.principalOffice(hero);
                    
                    break;

                case "4":
                    System.out.println();
                    System.out.println("┌───────────────────────────────────────────┐");
                    System.out.println("│    You have left your current location    │");
                    System.out.println("└───────────────────────────────────────────┘");

                    academyMapMenu = false;
 
                    break;
                

                default:
                    System.out.println();
                    System.out.println("┌─────────────────────────────┐");
                    System.out.println("│  Invalid choice. Try again! │");
                    System.out.println("└─────────────────────────────┘");
            }
        }    
    }
}