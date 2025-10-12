package Narration;

import java.util.Scanner;

public class LibraryNarration {

    private static Scanner scanner = new Scanner(System.in);

    public void findTheLostBookNarration(){
        String[] quest1 = {
            "The library hums with ancient energy.",
            "Stacks of tomes rise like towers.",
            "The librarian looks up and says,",
            "\"Student of Mystvale, an important book - The Art of Silent Spells—has gone missing.\"",
            "\"Can you help find it on one of the five nearby shelves?\""
        };

        playDialogueNarration(quest1);

    }

    public void ifQuest1Success(){
        String[] success1 = {
            "You pull a dusty tome from the shelf - its cover glimmers faintly.",  
            "\"The Art of Silent Spells,\" you whisper.",
            "LIBRARIAN: \"Marvelous! You have a keen eye, young scholar. Mystvale could use more minds like yours.\""
        };

        playSuccessOrFailNarration(success1);

    }

    public void ifQuest1Fail(){
        String[] fail1 = {
            "You search carefully, but the shelf holds nothing but cobwebs and old parchment.",
            "LIBRARIAN: \"Hmm… no luck? Don\'t worry. Even the books in this place like to hide.\"",  
            "\"Perhaps next time, they\'ll reveal themselves to you.\""
        };

        playSuccessOrFailNarration(fail1);

    }

    public void riddlesNarration(){
        String[] quest3 = {
            "As you approach the Restricted Section, you see the librarian by a flickering candle.",
            "An ancient tome lies open, letters moving across its pages.",
            "She looks up and says, \"Ah, curious student! This tome opens only to those who answer its riddles.\"",
            "\"Will you try your wit?\""
        };

        playDialogueNarration(quest3);

    }

    public boolean riddle1(){
        boolean continueInput = true;
        boolean isCorrect = false;

        System.out.println();
        System.out.println("┌──────────────────────────────────────────────────────────┐");
        System.out.println("│ Ako\'y maraming pahina, hindi tao ang laman,              │");
        System.out.println("│ kapag binuksan ko\'y pumapasok ang isip at damdamin.      │");
        System.out.println("│ Ano ako?                                                 │");
        System.out.println("└──────────────────────────────────────────────────────────┘");
        System.out.println("┌──────────────────────────────────────────────────────────┐");
        System.out.println("│ I have many pages, yet I am not a person;                │");
        System.out.println("│ When opened, mind and heart enter in.                    │");
        System.out.println("│ What am I?                                               │");
        System.out.println("└──────────────────────────────────────────────────────────┘");


        while(continueInput){
            System.out.print(">>> ");

            String answer1 = scanner.nextLine();
            if(answer1.equalsIgnoreCase("Aklat") || answer1.equalsIgnoreCase("Libro") || answer1.equalsIgnoreCase("Book")){
                System.out.println();
                System.out.println("┌───────────────────────────────┐");
                System.out.println("│       Correct! Good job!      │");
                System.out.println("└───────────────────────────────┘");

                isCorrect = true;
                continueInput = false;
            } else if (answer1.isEmpty()){
                System.out.println("Invalid input! Must be a character/s");
            } else {
                System.out.println();
                System.out.println("┌──────────────────────────────────────────────┐");
                System.out.println("│     Incorrect! Better luck next time!        │");
                System.out.println("└──────────────────────────────────────────────┘");
                
                continueInput = false;
            }

        }

        return isCorrect;

        
    }

    public boolean riddle2(){
        boolean continueInput = true;
        boolean isCorrect = false;

        System.out.println();
        System.out.println("┌──────────────────────────────────────────────────────────┐");
        System.out.println("│ Lumilipad nang walang pakpak, nagdadala ng luha ngunit   │");
        System.out.println("│ hindi umiiyak, sa araw naglalakbay, sa gabi humihinto't  │");
        System.out.println("│ natutulog. Ano ako?                                      │");
        System.out.println("└──────────────────────────────────────────────────────────┘");
        System.out.println("┌──────────────────────────────────────────────────────────┐");
        System.out.println("│ It flies without wings, carries tears but never cries;   │");
        System.out.println("│ By day it travels, by night it stops and rests.          │");
        System.out.println("│ What am I?                                               │");
        System.out.println("└──────────────────────────────────────────────────────────┘");


        while(continueInput){

            System.out.print(">>> ");
            String answer2 = scanner.nextLine();

             if(answer2.equalsIgnoreCase("Ulap") || answer2.equalsIgnoreCase("Ulap") || answer2.equalsIgnoreCase("Clouds")){
                System.out.println();
                System.out.println("┌───────────────────────────────┐");
                System.out.println("│       Correct! Good job!      │");
                System.out.println("└───────────────────────────────┘");



                isCorrect = true;
                continueInput = false;
            } else if(answer2.isEmpty()){
                System.out.println("Invalid input! Answer must be a character\s");
            } else {
                System.out.println();
                System.out.println("┌──────────────────────────────────────────────┐");
                System.out.println("│     Incorrect! Better luck next time!        │");
                System.out.println("└──────────────────────────────────────────────┘");

                isCorrect = false;
                continueInput = false;
            }
        }

        return isCorrect;

    }

    public boolean riddle3(){
        boolean continueInput = true;
        boolean isCorrect = false;

        System.out.println();
        System.out.println("┌──────────────────────────────────────────────────────────┐");
        System.out.println("│ May bahay na matigas, bilog ang anyo,                    │");
        System.out.println("│ sa loob may dilaw na araw na yumuyuko\'t umiikot;         │");
        System.out.println("│ pag piniga, umaalulong ang loob. Ano ako?                │");
        System.out.println("└──────────────────────────────────────────────────────────┘");
        System.out.println("┌──────────────────────────────────────────────────────────┐");
        System.out.println("│ I have a hard round shell,                               │");
        System.out.println("│ Inside, a yellow sun bends and swirls;                   │");
        System.out.println("│ When squeezed, the inside howls. What am I?              │");
        System.out.println("└──────────────────────────────────────────────────────────┘");


        while(continueInput){
            System.out.print(">>> ");

            String answer3 = scanner.nextLine();

            if(answer3.equalsIgnoreCase("Itlog") || answer3.equalsIgnoreCase("Egg")){
                System.out.println();
                System.out.println("┌───────────────────────────────┐");
                System.out.println("│       Correct! Good job!      │");
                System.out.println("└───────────────────────────────┘");

                isCorrect = true;
                continueInput = false;
            } else if(answer3.isEmpty()){
                System.out.println("Invalid input! Answer must be a character\s");
            } else{
                System.out.println();
                System.out.println("┌──────────────────────────────────────────────┐");
                System.out.println("│   Incorrect! Better luck next time!          │");
                System.out.println("└──────────────────────────────────────────────┘");

                isCorrect = false;
                continueInput = false;
            }
        }

        return isCorrect;

    }

    public void playSuccessOrFailNarration(String[] arr){
        for (String line : arr) {
            scanner.nextLine();
            System.out.println(line);
            }
        System.out.println();
    }

    public void playDialogueNarration(String[] arr){

        System.out.println();
        System.out.println("┌──────────────────────────────┐");
        System.out.println("│  Press Enter to continue...  │");
        System.out.println("└──────────────────────────────┘");

        for (String line : arr) {
            scanner.nextLine();
                System.out.println(line);
        }
        
        System.out.println();
        return; 
        
    }
    

}
