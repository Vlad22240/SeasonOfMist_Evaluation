import java.util.ArrayList;
import java.util.Scanner;

public abstract class Game {

    // Ces variables ont une portée privée car elles ne sont utilisée que dans cette classe.
    private int victory = 0;
    private int defeat = 0;
    private boolean gameWon;
    private boolean isPlaying = true;

    // Cette variable a une portée protégée car elle est initialiséeé dans les classes filles de cette classe.
    protected String gameName;

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public int getVictory() {
        return victory;
    }

    public void setVictory(int victory) {
        this.victory = victory;
    }

    public int getDefeat() {
        return defeat;
    }

    public void setDefeat(int defeat) {
        this.defeat = defeat;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public void setGameWon(boolean gameWon) {
        this.gameWon = gameWon;
    }

    // Chaque jeu a des règles différentes, la méthode est donc abstraite.
    public abstract void showRules();

    // L'algorithme du jeu se trouve dans cette méthode.
    public abstract int gameWon(String[] parameters);

    // Le programme demande au joueur de renseigner des paramètres.
    // Le nombre de paramètres dépend des règles et sera vérifié dans la méthode gameWon() spécifique au jeu.
    public String[] inputPlayer() {
        System.out.println("Veuillez renseigner le nombre de paramètres adéquat aux règles (ou 'exit' pour quitter) : ");
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        if (inputString.equalsIgnoreCase("exit")) {
            isPlaying = false;
            return null;
        }

        return inputString.split(" ");
    }

    // Si le nombre de paramètre n'est pas celui attendu, cette méthode est appelée et la méthode play() est réinitialisée.
    public void wrongInput() {
        System.out.println("Vous avez fourni le mauvais nombre de paramètres. Veuillez recommencer.\n");
        this.play();
    }

    // Le déroulement d'un jeu reste le même quel que soit le jeu.
    public void play() {
        System.out.println("NOUVELLE PARTIE - " + getGameName() + " - : ");
        showRules();
        String[] parameters = inputPlayer();
        int gameWon = gameWon(parameters);
        switch(gameWon) {
            case 0:
                defeat++;
                System.out.println("Dommage, vous avez perdu !");
                break;
            case 1:
                victory++;
                System.out.println("Bravo c'est une belle victoire !");
                break;
            default:
                break;
        }
    }

    // L'affichage du score reste le même quel que soit le jeu.
    public void showScore() {
        System.out.println("Pour le jeu " + getGameName() + ", vous avez gagné " + getVictory() +
                " fois et avez perdu " + getDefeat() + " fois.");
    }
}
