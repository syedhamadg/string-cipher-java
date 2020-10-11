public class KeyedCaesarCipher {

    private static String removeDuplicate(String text) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i < text.length(); i++){
            char c = text.charAt(i);
            if(sb.indexOf(String.valueOf(c)) == -1)
                sb.append(c);
        }
        return sb.toString();
    }

    public static String encrypt(String text, int shift, String key) {
        text = text.toUpperCase();
        key = removeDuplicate(key);
        String result = "";
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String keyedAlpha = key + alphabets;
        keyedAlpha = removeDuplicate(keyedAlpha);
        System.out.println(keyedAlpha);
        //String shiftedAlpha = alphabets.charAt(alphabets.length() - 4) + alphabets.substring(1, alphabets.length() - 4);
        //System.out.println(shiftedAlpha);
        /*for (int i = 0, j = 0; i < alphabets.length(); i++) {

            }
        }*/
        return result;
    }

    public static void main(String arg[]) {
       System.out.println(encrypt("Hello world",4, "LEMON"));
    }

}


