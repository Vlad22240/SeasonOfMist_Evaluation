import java.util.Random;

public class GameRunner {

    // Création d'une liste de tous les jeux existants. En cas de création d'un nouveau jeu, il suffit de l'instancier ici.
    Game[] gameList = {new Anagram(), new Palindrom(), new Test()};


    public void play() {

        // Le jeu est joué indéfiniment tant que le joueur n'indique pas 'exit' qui modifie la variable isPlaying de la classe du jeu.
        while (true) {
            // On prend un jeu au hasard parmi ceux existants.
            Game newGame = gameList[new Random().nextInt(gameList.length)];
            newGame.play();


            for (Game game : gameList) {
                game.showScore();
            }

            System.out.println();

            if (!newGame.isPlaying()) {
                System.out.println("Merci d'avoir joué !");
                break;
            }
        }
    }


}