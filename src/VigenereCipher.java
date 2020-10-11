public class VigenereCipher extends Application{

    public static String encrypt(String plainText, String key) {
        plainText = plainText.toUpperCase();
        String result = "";
        for (int i = 0, j = 0; i < plainText.length(); i++) {
            if (plainText.charAt(i) < 'A' || plainText.charAt(i) > 'Z')
                continue;
            char newLetters = (char) ((plainText.charAt(i) + key.charAt(j) - 2 * 'A') % 26 + 'A');
            result += newLetters;
            j = ++j % key.length();
        }
        return result;
    }

    public static String decrypt(String cipher, String key) {
        cipher = cipher.toUpperCase();
        String result = "";
        for (int i = 0, j = 0; i < cipher.length(); i++) {
            if (cipher.charAt(i) < 'A' || cipher.charAt(i) > 'Z')
                continue;
            char newLetters = (char)((cipher.charAt(i) - key.charAt(j) + 26) % 26 + 'A');
            result += newLetters;
            j = ++j % key.length();
        }
        return result;
    }
}


