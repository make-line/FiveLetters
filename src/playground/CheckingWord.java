package playground;


import java.util.Objects;

public class CheckingWord {
    public String[] check(String[] userLetter, String genWord){
        String[] genLetter = genWord.split("");
        int[] allGenLetters = new int[33];
        int[] allUserLetters = new int[33];
        int b = 0;
        int c = 0;
        for (char a = 'а'; a < 'я'; a++){
            if (genLetter[c].equals(String.valueOf(a))){
                allGenLetters[b] += 1;
            }
            if (userLetter[c].equals(String.valueOf(a))){
                allUserLetters[b] += 1;
            }
            b++;
        }
        String[] userWord2 = new String[5];
        boolean doubles = false;
        int checkPoint = 0;
        for (int i = 0; i < 5; i ++){
            userWord2[i] = userLetter[i].toLowerCase();
        }
        for (int i = 0; i < 33; i++){
            if (allUserLetters[i] != allGenLetters[i]){
                if (allUserLetters[i] > allGenLetters[i]){
                    while (checkPoint < 2){
                        checkPoint ++;
                        for (int j = 0; j < 5; j++){
                            if (!Objects.equals(userWord2[j], userLetter[j]) && allUserLetters[i] > allGenLetters[i]){
                                doubles = true;
                            }
                            if (doubles && Objects.equals(userWord2[j], userLetter[j]) && allUserLetters[i] > allGenLetters[i]) {
                                userLetter[j] = "_";
                            }
                            if (!doubles && checkPoint > 1 && Objects.equals(userWord2[j], userLetter[j]) && allUserLetters[i] > allGenLetters[i]){
                                userLetter[j] = "_";
                                checkPoint += 1;
                                break;
                            }
                        }
                        doubles = false;
                    }
                    checkPoint = 0;
                }
            }
        }
        return userLetter;
    }
}
