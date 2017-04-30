package com.chesspionage.model;

public class User {
  //Fields
  private String username;
  private int wins;
  private int losses;

  //Constructors
  public User() {
    username = "Anonymous";
    wins = 0;
    losses = 0;
  }

  public User(String username) {
    this.username = username;
    wins = 0;
    losses = 0;
  }

  //Methods
  public boolean login(String username, String password) {
        /*
        Provided a username and password, search the database for the user and try to pull their information.

        Returns true on success and false on failure
         */

    return false;
  }

  public boolean logout() {
        /*
        Try to logout of an account

        Returns true on success and false on failure
         */

    return false;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getWins() {
    return wins;
  }

  public void setWins(int wins) {
    this.wins = wins;
  }

  public int getLosses() {
    return losses;
  }

  public void setLosses(int losses) {
    this.losses = losses;
  }
}
