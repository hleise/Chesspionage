package Model;

/**
 * Created by Raymond on 4/22/17.
 */

public class Application {
    //Fields
    private User user;
    private Game game;

    //Constructors
    public Application(){
        //Do something
        user = new User();
    }

    //Methods
    public void startGame(){
        //Create an instance of the game and run it
    }

    public void changeSettings(){
        //View user settings, later add customization
    }

    public void howToPlay(){
        //Pull up the "How to Play" screen
    }
}
