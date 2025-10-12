package Office;

import Hero.*;
import Narration.*;

public class PrincipalOffice {

    private OfficeNarration narrationHandler = new OfficeNarration();

    public void principalOffice(Hero hero){
        
        if(!hero.haveEntered()){
            narrationHandler.officeNarration(); 
            hero.setHaveEntered(true);
        }

        System.out.println();
        System.out.println("┌──────────────────────────────────────────────┐");
        System.out.println("│  Checking your eligibility. Please wait...   │");
        System.out.println("└──────────────────────────────────────────────┘");


        boolean eligible = false;

        if (!hero.canEnterArea1()) {
            if(hero.getLevel() >= 20) {
                narrationHandler.area1Eligible();
                hero.unlockArea1();

                System.out.println();
                System.out.println("┌──────────────────────────────────────────────────┐");
                System.out.println("│     You may now enter The Forest of Reverie      │");
                System.out.println("└──────────────────────────────────────────────────┘");

                eligible = true;
            }

            

        } else if (!hero.canEnterArea2() && hero.canEnterArea1()) {
            if(hero.getLevel() >= 40) {

                narrationHandler.area2Eligible();
                hero.unlockArea2();

                System.out.println();
                System.out.println("┌──────────────────────────────────────────────┐");
                System.out.println("│      You may now enter The Reverie Edge      │");
                System.out.println("└──────────────────────────────────────────────┘");

                eligible = true;
            }
            

        } else if (!hero.canEnterArea3() && hero.canEnterArea2()) {
            if(hero.getLevel() <= 60) {
                narrationHandler.area3Eligible();
                hero.unlockArea3();
            
                System.out.println();
                System.out.println("┌──────────────────────────────────────────────┐");
                System.out.println("│    You may now enter The Forsaken Lands      │");
                System.out.println("└──────────────────────────────────────────────┘");

                eligible = true;
            }
            
        }

        if (!eligible) {
            System.out.println();
            System.out.println("┌─────────────────────────────────────────────────────┐");
            System.out.println("│       You are not eligible for any new area.        │");
            System.out.println("│       Exiting from the Principal\'s Office...        │");
            System.out.println("└─────────────────────────────────────────────────────┘");

        }
    }

}
