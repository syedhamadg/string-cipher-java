public class CaesarCipherShift extends Application{
    /*private String text;
    private  int shift;
    private String cipher;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }*/

    public static String encrypt(String text, int shift) {
        String result = "";
        text = text.toUpperCase();
        for(int i=0; i < text.length(); i++) {
            char letters = text.charAt(i);
                if(letters > 'Z') {
                    letters = (char) (letters  - (26 - shift));
                }
            else {
                letters = (char) (letters + shift);
            }
            result += letters;
            //result = result.trim();
        }
        return result.trim();
    }

    public static String decrypt(String cipher, int shift) {
        String result = "";
        cipher = cipher.toUpperCase();
        for (int i = 0; i < cipher.length(); i++) {
            char letters = cipher.charAt(i);
                if (letters < 'A') {
                    letters = (char) (letters +  (26 - shift));
                }
                else {
                    letters = (char) (letters - shift);
                }
                result += letters;
                //result = result.trim();
            }
        return result.trim();
    }
}

