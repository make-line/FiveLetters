package playground;

import java.util.HashMap;
import java.util.Map;

public class CheckingWord {
    public String[] check(String[] userLetter, String genWord) {
        String[] genLetter = genWord.split("");
        String[] result = new String[5];
        Map<Integer, String> userMap = new HashMap<>();
        Map<Integer, String> genMap = new HashMap<>();
        for (int j = 0; j < 5; j++) {
            genMap.put(j, genLetter[j]);
            userMap.put(j, userLetter[j].toLowerCase());
            if (!genMap.containsValue(userMap.get(j))){
                result[j] = "_";
            }
        }
        for (int i = 0; i < 5; i ++){
            if (genMap.get(i).equals(userMap.get(i)) && !userMap.get(i).equals("0")) {
                result[i] = userLetter[i].toUpperCase();
                userMap.put(i, "0");
                genMap.put(i, "0");
            }
            for (int j = 0; j < 5; j++) {
                if (genMap.get(i).equals(userMap.get(j)) && i != j && !userMap.get(j).equals("0")){
                    result[j] = userLetter[j];
                    userMap.put(j, "0");
                }
            }
        }
        return result;
    }
}
