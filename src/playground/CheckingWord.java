package playground;

import java.util.HashMap;
import java.util.Map;

public class CheckingWord {
    public String[] check(String[] userLetter, String genWord) {
        String[] genLetter = genWord.split("");
        String[] result = new String[5];
        Map<Character, Integer> map = new HashMap<>();
        map.put('т', 6);
        boolean duplicate = false;
        for (int j = 0; j < 5; j++) {
            //if (String.valueOf(a).equals(userLetter[j].toLowerCase())) {
            if (!userLetter[j].toLowerCase().equals(userLetter[j])) {
                duplicate = true;
                result[j] = userLetter[j];
            }
            for (int k = 0; k < 5; k++) {
                if (userLetter[j].toLowerCase().equals(genLetter[k]) && j != k && duplicate) {
                    result[k] = "_";
                }
            }
            duplicate = false;
            //}
        }
        //}
        return result;
    }
}
