package com.chesspionage;

import com.chesspionage.model.Game;
import com.chesspionage.model.User;
import java.util.Scanner;

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

  public static void main(String[] args) {
    System.out.print("\033[H\033[2J");
    System.out.flush();

    System.out.println("Welcome to Chesspionage!");

    System.out.println("What's your name?");

    Scanner user_input = new Scanner(System.in);
    String name = user_input.next();

    System.out.print("\033[H\033[2J");
    System.out.flush();

    System.out.println("Hello " + name);
    String age = user_input.next();

    System.out.print("\033[H\033[2J");
    System.out.flush();

    System.out.println("Oh, I remember when I was " + age);
  }
}
