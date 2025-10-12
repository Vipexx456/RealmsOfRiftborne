import Menu.*;
import Hero.*;

public class Main {
    public static void main(String[] args) {
        Menu mainMenu = new Menu();
        StartMenu startMenu = new StartMenu();
        CharacterMenu characterMenu = new CharacterMenu();
        
        boolean shouldStartGame = startMenu.displayStartMenu();

        if (!shouldStartGame) {
            return;
        }

        Hero hero =  characterMenu.chooseCharacterMenu();

        mainMenu.mainMenu(hero);

    }
}