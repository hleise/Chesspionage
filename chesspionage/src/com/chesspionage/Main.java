package com.chesspionage;

import java.util.Scanner;

public class Main {

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
