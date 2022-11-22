 import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;

public class BlowFish {
    public static void main(String[] args) throws Exception {

        KeyGenerator kg= KeyGenerator.getInstance("Blowfish");
        kg.init(128);
        Key sk = kg.generateKey();
        Cipher co = Cipher.getInstance("Blowfish/CFB/NoPadding");
        co.init(Cipher.ENCRYPT_MODE,sk);

        Base64.Encoder encoder = Base64.getEncoder();
        byte iv[] = co.getIV();
        if(iv!=null){
            System.out.println("Initialization vector of the Cipher:" + encoder.encodeToString(iv));
        }
        FileInputStream fin = new FileInputStream("inputFile.txt");
        FileOutputStream fout = new FileOutputStream("outputFile.txt");
        CipherOutputStream cout = new CipherOutputStream(fout,co);
        int input;
        while((input = fin.read()) != -1) {
            cout.write(input);
        }

        fin.close();
        cout.close();
    }
}