
public class Palindrom extends Game {

    // Ce constructeur permet de nommer le jeu.
    public Palindrom() {
        this.gameName = "Palindrome";
    }

    @Override
    public void showRules() {
        System.out.println("Définition : Un palindrome est un mot ou groupe de mots qui peut se lire indifféremment de gauche à droite " +
                "ou de droite à gauche en gardant le même sens sans tenir compte des espaces. Attention toutefois, les ponctuations et les accents sont pris en compte (ex. la mariee ira mal ; Roma Amor ; kayak).");
        System.out.println("Vous écrirez un mot ou un groupe de mot, si votre contribution est un palindrome, alors c'est gagné. Sinon c'est perdu.");
    }


    @Override
    public int gameWon(String[] parameters) {
        if (parameters == null) {
            return -1;
        }
        String s = parameters[0];
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return 0;
            }
        }
        return 1;
    }

}
