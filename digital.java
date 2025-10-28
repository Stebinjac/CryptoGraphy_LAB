import java.util.*;
import javax.crypto.*;
import java.security.*;
public class digital{
    public static void main(String[]args)throws Exception{
        String str="hello";
        KeyPairGenerator kgp=KeyPairGenerator.getInstance("RSA");
        kgp.initialize(2048);
        KeyPair kp=kgp.generateKeyPair();
        PublicKey pu=kp.getPublic();
        PrivateKey pr=kp.getPrivate();
        Signature sign=Signature.getInstance("SHA256withRSA");
        sign.initSign(pr);
        sign.update(str.getBytes());
        byte[] digitext=sign.sign();
        System.out.println(digitext);
        str="Hello";
        Signature verify=Signature.getInstance("SHA256withRSA");
        verify.initVerify(pu);
        verify.update(str.getBytes());
        Boolean ver=verify.verify(digitext);
        System.out.println(ver);
    }
}