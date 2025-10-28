import java.util.*;
import javax.crypto.*;
public class des{
    public static void main(String[]args)throws Exception{
        System.out.println("enter plaintext");
        Scanner sc=new Scanner(System.in);
        String plaintext=sc.nextLine();
        KeyGenerator key=KeyGenerator.getInstance("AES");
        SecretKey sk=key.generateKey();
        Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,sk);
        byte[] encbyte=cipher.doFinal(plaintext.getBytes());
        String enctext=Base64.getEncoder().encodeToString(encbyte);
        System.out.println("encrytped text :"+enctext);
        cipher.init(Cipher.DECRYPT_MODE,sk);
        byte[] decbyte=cipher.doFinal(encbyte);
        String dectext=new String(decbyte);
        System.out.println("decrypted text :"+dectext);
    }
}