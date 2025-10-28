import java.util.*;
public class df{
    public static void main(String[]args){
        int g=5;
        Random rand=new Random();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a prime number");
        int p=sc.nextInt();
        int a=rand.nextInt(p-2)+1;
        int b=rand.nextInt(p-2)+1;
        int A=(int)(Math.pow(g,a)%p);
        int B=(int)(Math.pow(g,b)%p);
        int secA=(int)(Math.pow(B,a)%p);
        int secB=(int)(Math.pow(A,b)%p);
        System.out.println("Private keys");
        System.out.println("Alice Private Key :"+a);
        System.out.println("Bob private key   :"+b);
        System.out.println("Public key ");
        System.out.println("Alice public key  :"+A);
        System.out.println("Bobs public key   :"+B);
        System.out.println("Alice Secret key  :"+secA);
        System.out.println("Bobs Secret key   :"+secB);
        if(secA==secB){
            System.out.println("secret key exchanged succesfully");
        }
        else{
            System.out.println("secret key exhange failed");
        }
    }
}