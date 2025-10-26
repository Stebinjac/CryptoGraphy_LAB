import java.util.Scanner;
public class SimpleHillCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] key = { {3, 3}, {2, 5} }; // example key
        System.out.print("Enter text (A-Z): ");
        String text = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "");
        if (text.length() % 2 != 0) text += "X"; // pad if odd
        String enc = encrypt(text, key);
        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + decrypt(enc, key));
        sc.close();
    }
    static String encrypt(String t, int[][] k) {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < t.length(); i += 2) {
            int p1 = t.charAt(i) - 'A', p2 = t.charAt(i + 1) - 'A';
            r.append((char) (((k[0][0]*p1 + k[0][1]*p2) % 26) + 'A'));
            r.append((char) (((k[1][0]*p1 + k[1][1]*p2) % 26) + 'A'));
        }
        return r.toString();
    }
    static String decrypt(String t, int[][] k) {
        int det = (k[0][0]*k[1][1] - k[0][1]*k[1][0] + 26) % 26;
        int inv = 0; 
        for (int i = 1; i < 26; i++) 
        if ((det*i)%26 == 1) 
        inv = i;
        int[][] invK = {
            { ( k[1][1]*inv)%26, (-k[0][1]*inv + 26)%26 },
            { (-k[1][0]*inv + 26)%26, ( k[0][0]*inv)%26 }
        };
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < t.length(); i += 2) {
            int c1 = t.charAt(i) - 'A', c2 = t.charAt(i + 1) - 'A';
            r.append((char) (((invK[0][0]*c1 + invK[0][1]*c2) % 26) + 'A'));
            r.append((char) (((invK[1][0]*c1 + invK[1][1]*c2) % 26) + 'A'));
        }
        return r.toString();
    }
}

