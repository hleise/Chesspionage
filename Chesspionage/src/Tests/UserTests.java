package Tests;

import Model.*;

/**
 * Created by Raymond on 4/22/17.
 */
public class UserTests {
    public static void main(String[] args){
        System.out.println("Running UserTests");
        testAnon();
        testUser();
        testWins();
        testLosses();
    }

    private static void testAnon(){
        User user = new User();
        System.out.println("testAnon: Should return Anonymous, 0, 0");
        System.out.print(user.getUsername());
        System.out.print(user.getWins());
        System.out.println(user.getLosses());
    }

    private static void testUser(){
        User user = new User("User");
        System.out.println("testUser: Should return User, 0, 0");
        System.out.print(user.getUsername());
        System.out.print(user.getWins());
        System.out.println(user.getLosses());
    }

    private static void testWins(){
        User user = new User();
        System.out.println("testWins: Should return [something]");
    }

    private static void testLosses(){
        User user = new User();
        System.out.println("testLosses: Should return [something]");
    }


}
