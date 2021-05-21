import java.util.Arrays;

public class Anagram extends Game {

    // Ce constructeur permet de nommer le jeu.
    public Anagram() {
        this.gameName = "Anagramme";
    }

    @Override
    public void showRules() {
        System.out.println("Définition : Une anagramme est un mot formé en changeant de place les lettres d'un autre mot. Attention, les accents sont pris en compte. (Une anagramme de gare est rage.)");
        System.out.println("Vous écrirez deux mots, si le deuxième est une anagramme du premier, alors c'est gagné. Sinon c'est perdu.");
    }


    @Override
    public int gameWon(String[] parameters) {
        if (parameters == null) {
            return -1;
        }
        else if (parameters.length != 2) {
            wrongInput();
            return -1;
        }
        String word1 = parameters[0].toLowerCase();
        String word2 = parameters[1].toLowerCase();
        if (word1.length() != word2.length()) {
            return 0;
        }
        char[] a1 = word1.toCharArray();
        char[] a2 = word2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        if (Arrays.equals(a1, a2)) {
            return 1;
        }
        else
            return 0;
    }
}
