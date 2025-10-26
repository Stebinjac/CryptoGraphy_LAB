import java.util.*;
public class ceaser{
    public static String encrypt(String text,int shift){
        String enc="";
        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);
            if(ch>='A'&& ch<='Z'){
                enc=enc+(char)((ch+shift-'A')%26 +'A');
            }
            if(ch>='a'&& ch<='z'){
                enc=enc+(char)((ch+shift-'a')%26 +'a');
            }
            else{
                enc=enc+ch;
            }
        }
        System.out.println("Encrytped text:"+enc);
        return enc;
    }
    public static String decrypt(String text,int shift){
        String dec="";
        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);
            if(ch>='A'&& ch<='Z'){
                dec=dec+(char)((ch-shift-'A')%26 +'A');
            }
            if(ch>='a'&& ch<='z'){
                dec=dec+(char)((ch-shift-'a')%26 +'a');
            }
            else{
                dec=dec+ch;
            }
        }
        System.out.println("decrytped text:"+dec);
        return dec;
    }
    public static void main (String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter text");
        String msg=sc.nextLine();
        System.out.println("enter key");
        int shift=sc.nextInt();
        String enc=encrypt(msg,shift);
        decrypt(enc,shift);
    }
}