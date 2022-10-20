import java.util.Scanner;
public class CaesarCipher
{
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static String encrypt(String message, int key)
    {
        String encrypted = "";
        for (int i = 0; i < message.length(); i++)
        {
            char ch = message.charAt(i);
            int index = ALPHABET.indexOf(ch);
            int newIndex = (index + key) % 26;
            char newChar = ALPHABET.charAt(newIndex);
            encrypted += newChar;
        }
        return encrypted;
    }
    public static String decrypt(String message, int key)
    {
        String decrypted = "";
        for (int i = 0; i < message.length(); i++)
        {
            char ch = message.charAt(i);
            int index = ALPHABET.indexOf(ch);
            int newIndex = (index - key) % 26;
            if (newIndex < 0)
            {
                newIndex = ALPHABET.length() + newIndex;
            }
            char newChar = ALPHABET.charAt(newIndex);
            decrypted += newChar;
        }
        return decrypted;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message to be encrypted: ");
        String message = sc.nextLine();
        String messageLower = message.toLowerCase();
        System.out.println("Enter the Encryption key: ");
        int ekey = sc.nextInt();
        String encrypted = encrypt(messageLower, ekey);
        System.out.println("Encrypted message: " + encrypted);
        System.out.println("Enter the Decryption key: ");
        int dkey = sc.nextInt();
        if (dkey == ekey)
        {
            String decrypted = decrypt(encrypted, dkey);

            if(decrypted.equals(messageLower))
            {
                System.out.println("Decrypted message: " + message);
            }
        }
        else
        {
            System.out.println("Invalid Decryption key");
        }
    }
}