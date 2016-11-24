package codewars;

public class MorseCodeDecoder {
    public static String decode(String morseCode) {

        char[] morseChars = morseCode.trim().toCharArray();
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        int spaceCnt = 0;

        for (int i = 0; i < morseCode.length(); i++) {

            if (Character.toString(morseChars[i]).equalsIgnoreCase(" ")) {
                if (spaceCnt == 0) {
                    //String s = MorseCode.get(word.toString());
                    System.out.println(word.toString());
                    //result.append(s);
                    word = new StringBuilder();
                    spaceCnt++;
                } else if (spaceCnt == 2) {
                    result.append(" ");
                    System.out.println("put space");
                    spaceCnt = 0;
                } else {
                    spaceCnt++;
                }
            } else {
                word.append(morseChars[i]);
                spaceCnt = 0;
            }
        }
        System.out.println(word.toString());

        return result.toString();
    }

    public static void main(String[] args) {
        decode(".... . -.--   .--- ..- -.. .");
    }
}