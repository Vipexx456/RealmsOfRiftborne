package Narration;

import java.util.Scanner;

public class OfficeNarration {

    private static Scanner scanner = new Scanner(System.in);

    public void officeNarration(){
        String[] principalOfficeNarration = {
           "As you enter the tall arched doors, the air shifts - calm yet commanding.",
            "Golden light glows across the marble floor and the crest of Mystvale Academy.",
            "A voice stops you.",
            "\"Good day, student,\" the secretary says, her quill hovering over a glowing parchment.",
            "\"Before seeing the Principal, I must verify your experience.\"",
            "She gestures, and a soft light surrounds you as numbers and symbols float in the air.",
            "\"Let\'s see… your experience will decide if you may proceed.\""
        };
        
        playEligibleNarration(principalOfficeNarration);

    }

    public void area1Eligible(){
        String[] area1Principal = {
            "The Principal nods approvingly as you approach.",
            "\"You\'ve shown promise, student,\" he says. \"You are now eligible to explore the Whispering Forest.\"",
            "\"Tread carefully - the forest listens, and it remembers.\""
        };

        playEligibleNarration(area1Principal);

    }

    public void area2Eligible(){
        String[] area2Principal = {
            "The Principal folds his hands behind his back, studying you closely.",
            "\"Impressive progress. You\'ve earned the right to enter the Murkmire Swamp,\" he declares.",
            "\"It\'s a place that tests patience as much as strength - do not lose your focus.\""
        };

        playEligibleNarration(area2Principal);

    }

    public void area3Eligible(){
        String[] area3Principal = {
            "The Principal\'s tone grows solemn as he regards you.",
            "\"You\'ve reached a rare level of mastery,\" he says quietly. \"The Kingdom of Entities now awaits you.\"",
            "\"Beyond its gates lie trials unlike any other. Step forward with courage — and wisdom.\""
        };

        playEligibleNarration(area3Principal);

    }

    public void playEligibleNarration(String[] arr){

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
