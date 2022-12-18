package playground;



public class CheckingWord {
    public String[] check(String[] userLetter, String genWord){
        String[] genLetter = genWord.split("");
        int[] allGenLetters = new int[33];
        int[] allUserLetters = new int[33];
        int b = 0;
        for (int i =0; i < 5; i++) {
            for (char a = 'а'; a < 'я'; a++) {
                if (genLetter[i].equals(String.valueOf(a))) {
                    allGenLetters[b] += 1;
                }
                if (userLetter[i].toLowerCase().equals(String.valueOf(a))) {
                    allUserLetters[b] += 1;
                }
                b++;
            }
            b = 0;
        }
        boolean duplicate = false;
        String[] alphabet = new String[33];
        for (char a = 'а'; a < 'я'; a++){
            alphabet[b] = String.valueOf(a);
            b++;
        }
        for (int i = 0; i < 33; i++) {
            if (allUserLetters[i] != allGenLetters[i]) {
                for (int j = 0; j < 5; j++) {
                    if (alphabet[i].equals(userLetter[j].toLowerCase())) {
                        if (!userLetter[j].toLowerCase().equals(userLetter[j])) {
                            duplicate = true;
                        }
                        for (int k = 0; k < 5; k++) {
                            if (alphabet[i].equals(genLetter[k]) && j != k && duplicate) {
                                userLetter[k] = "_";
                            }
                        }
                        duplicate = false;
                    }
                }
            }
        }
        return userLetter;
    }
}
