package Controllers;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by Hunter on 4/19/17.
 */
public class HelloWorld {

    public static String greeting(Language language) {
        Map<Language, String> greetings = new HashMap<Language, String>();
        greetings.put(Language.English, "Hello World");
        greetings.put(Language.Spanish, "Hola Mundo");
        greetings.put(Language.Vietnamese, "Xin Chao The Gioi");
        greetings.put(Language.Italian, "Ciao Mondo");

        return greetings.get(language);
    }

}
