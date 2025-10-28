import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.*;
public class des{
    public static void main(String[]args)throws Exception{
        Random rand=new Random();
        Scanner sc=new Scanner(System.in);
        int g=5;
        System.out.println("enter the prime number");
        int p=sc.nextInt();
        int a=rand.nextInt(p-2)+1;
        int b=rand.nextInt(p-2)+1;
        int A=(int)Math.pow(g,a)%p;
        int B=(int)Math.pow(g,b)%p;
        int secretA=(int)Math.pow(B,a)%p;
        int secretB=(int)Math.pow(A,b)%p;
        System.out.println("private key of a"+a);
        System.out.println("private key of b"+b);
        System.out.println("Public key of a"+A);
        System.out.println("Public key of b"+B);
        System.out.println("Secret key Exchnaged");
        System.out.println("Secret key of A"+secretA);
        System.out.println("Secret key of B"+secretB);
        if(secretA==secretB){
            System.out.println("key exchange successful");
            System.out.println("enter plaintext");
            String plaintext=sc.nextLine();
            String key=String.valueOf(secretA);
            SecretKey secretkey=new SecretKeySpec(key.getBytes(),"DES");
            Cipher cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,secretkey);
            byte[] encbyte=cipher.doFinal(plaintext.getBytes());
            String enctext=Base64.getEncoder().encodeToString(encbyte);
            System.out.println("encrytped text"+enctext);
            cipher.init(Cipher.DECRYPT_MODE,secretkey);
            byte[] decbyte=cipher.doFinal(encbyte);
            String dectext=new String(decbyte);
            System.out.println("decrypted text:"+dectext);
        }
        else{
            System.out.println("key exchange failed");
        }
    }
}