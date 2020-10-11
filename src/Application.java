import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Application {

    private Scanner scan;
    private String filename;
    private int cCipherKey = 0;
    private String kCipherKey;
    private String vCipherKey;
     private String enc;
    private String dec;
    private String plainText;

    public Application() {
        scan = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        filename = scan.next();
    }

    private void runMenu() throws IOException {
        String response;
        do {
            printMenu();
            System.out.println("Choose one:");
            scan = new Scanner(System.in);
            response = scan.nextLine().toUpperCase();
            switch (response) {
                case "1":
                    useCaesarCipherShift();
                    break;
                case "2":
                    //useKeyedCaesarCipher();
                    break;
                case "3":
                    useVigenereCipher();
                    break;
                case "4":
                    editKey();
                    break;
                case "5":
                    displayKeys();
                    break;
                case "6":
                    displayCiphers();
                    break;
                case "7":
                    displayPlain();
                    break;
                case "8":
                    load();
                    break;
                case "9":
                    save();
                    break;
                case "Q":
                    break;
                default:
                    System.out.println("Try again");
            }
        } while (!(response.equals("Q")));
    }

    private void printMenu() {

        System.out.println("1 - Use Caesar Cipher Shift");
        System.out.println("2 - Use Keyed Caesar Cipher");
        System.out.println("3 - Use Vigenere Cipher");
        System.out.println("4 - Edit key");
        System.out.println("5 - Display key");
        System.out.println("6 - Display all ciphers");
        System.out.println("7 - Display all plain texts");
        System.out.println("8 - Load");
        System.out.println("9 - Save");
        System.out.println("q - Quit");
    }

    private void setcCipherKey() {
        System.out.println("Enter shift");
        cCipherKey = Integer.parseInt(scan.nextLine());
    }

   // private void setkCipherKey() {

   // }

    private void setvCipherKey() {
        System.out.println("Enter key");
        vCipherKey = scan.nextLine();
    }

    private void enterPlain() {
        System.out.println("Enter plain text");
        plainText = scan.nextLine().toUpperCase();
    }

    private void printMessage(){
        System.out.println("Encrypted text is: " + enc);
        System.out.println("Decrypted text is: " + dec);
    }

    private void useCaesarCipherShift() {
        setcCipherKey();
        enterPlain();
        enc = CaesarCipherShift.encrypt(plainText, cCipherKey);
        dec = CaesarCipherShift.decrypt(enc, cCipherKey );
        printMessage();
    }

   // private void useKeyedCaesarCipher() {
       // setkCipherKey();
        //enterPlain();
        //enc = System.out.println(CaesarCipherShift.encrypt("Hello world", 1 ));
        //dec = System.out.println(CaesarCipherShift.decode(encrypt("Hello world", 1));
        ///printMessage();
   // }

    private void useVigenereCipher() {
        setvCipherKey();
        enterPlain();
        enc = VigenereCipher.encrypt(plainText, vCipherKey);
        dec = VigenereCipher.decrypt(enc, vCipherKey);
        printMessage();
    }

    private void editKey() {
        System.out.println("Which cipher's key do you want to edit? \n 1 - Caesar Cipher Shift \n 2 - Keyed Caesar Cipher \n 3 - Vigenere Cipher");
        String answer = scan.nextLine();
        switch (answer) {
            case "1":
                setcCipherKey();
                System.out.println("new shift is: " + cCipherKey);
                break;
            case "2":
                //setkCipherKey();
                //System.out.println("Key is: " + kCipherKey);
                break;
            case "3":
                setvCipherKey();
                System.out.println("Key is: " + vCipherKey);
                break;
        }
    }

    private void displayCiphers() {
        System.out.println("Ciphers are:");
        System.out.println(enc);
    }

    private void displayPlain() {
        System.out.println("Plain texts are:");
        System.out.println(dec);
    }

    private void editcCipherkey(){
        if (cCipherKey == 0){
            System.out.println("No shift for this encryption method");
        }
        System.out.println("Shift is: " + cCipherKey);
    }

    private void editkCipherkey(){
         /*if (kCipherKey == null) {
                    System.out.println("No key for this encryption method");
                }
                    System.out.println("Key is: " + kCipherKey);*/
    }

    private void editvCipherkey(){
        if (vCipherKey == null){
            System.out.println("No key for this encryption method");
        }
        System.out.println("Key is: " + vCipherKey);
    }

    private void displayKeys() {
        System.out.println("Which cipher's key do you want to see? \n 1 - Caesar Cipher Shift \n 2 - Keyed Caesar Cipher \n 3 - Vigenere Cipher");
        String answer = scan.nextLine();
        switch (answer) {
            case "1":
                editcCipherkey();
                break;
            case "2":
               editkCipherkey();
                break;
            case "3":
                editvCipherkey();
                break;
        }
    }

    private void load() throws IOException {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            System.out.println("Reading from file: " + filename);
            String contentLine = br.readLine();
            while (contentLine != null) {
                System.out.println(contentLine);
                contentLine = br.readLine();
            }
        } catch (FileNotFoundException e) {
                System.err.println("The file " + filename + " does not exist.");
            } catch (IOException e) {
                System.err.println("An unexpected error occurred when trying to open the file " + filename);
                System.err.println(e.getMessage());
            }
        }

        private void save() throws IOException {
        PrintWriter output = new PrintWriter(filename, StandardCharsets.UTF_8);
        output.println("Encrypted text is: " + enc);
        output.println("Decrypted text is: " + dec);
        output.close();
    }

    public static void main(String[] args) throws IOException {
        Application app = new Application();
        app.runMenu();
        app.save();
    }
}