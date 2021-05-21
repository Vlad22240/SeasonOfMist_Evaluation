public class Test extends Game {

    public Test() {
        this.gameName = "Test";
    }

    @Override
    public void showRules() {
        System.out.println("Ce jeu permet de compter le nombre de lettres d'une phrase.");
        System.out.println("Vous écrirez autant de mots que vous le souhaitez. S'il y en a moins de 20, c'est gagné, sinon c'est perdu.");
    }

    @Override
    public int gameWon(String[] parameters) {
        if (parameters == null) {
            return -1;
        }
        String s = "";
        for (String parameter: parameters) {
            s += parameter;
        }
        if (s.length() <= 20)
            return 1;
        else
            return 0;
    }
}
