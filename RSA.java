import java.util.*;
import javax.crypto.*;
import java.security.*;
public class rsa{
    public static void main(String[]args)throws Exception{
        Scanner sc=new Scanner(System.in);
        KeyPairGenerator kpg=KeyPairGenerator.getInstance("RSA");
        kpg.initialize(512);
        KeyPair kp=kpg.generateKeyPair();
        PublicKey pu=kp.getPublic();
        PrivateKey pr=kp.getPrivate();
        System.out.println("enter string");
        String str=sc.nextLine();
        Cipher cipher=Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,pu);
        byte[] encbyte=cipher.doFinal(str.getBytes());
        String enctext=Base64.getEncoder().encodeToString(encbyte);
        System.out.println("Encrypted text:"+enctext);
        cipher.init(Cipher.DECRYPT_MODE,pr);
        byte[] decbyte=cipher.doFinal(encbyte);
        String dectext=new String(decbyte);
        System.out.println("decrypted text:"+dectext);
    }
}