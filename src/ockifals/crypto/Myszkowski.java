package ockifals.crypto;

import java.util.Arrays;
import java.util.Scanner;

public class Myszkowski {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukan pesan : ");
        String pesan = input.next();
        
        System.out.print("Masukan kunci : ");
        String kunci = input.next();
        
        String ciphertext = myszkEncrypt(kunci, pesan);
        System.out.print("Ciphertext : ");
        System.out.println(ciphertext);
    }
    
    public static String myszkEncrypt(String key, String pt) {
        char[] chars = key.toCharArray();
        Arrays.sort(chars);
        String alphabet = String.valueOf(chars);
	String ct = "";

        // iterasi sebanyak jumlah karakter kunci
	for (int i = 0; i < alphabet.length(); i++) {
            //System.out.println(i);
            // iterasi sebanyak total karakter dari pesan
            for (int row = 0; row*key.length() < pt.length(); row++) {
                //System.out.println(row);
                // iterasi untuk mengambil huruf yang berada dibawah kata kunci yang telah diurutkan
		for (int col = 0; col < key.length(); col++) {
                    //System.out.println(col);
                    if (row*key.length() + col >= pt.length())
			continue;
                    
                    if (key.charAt(col) == alphabet.charAt(i)) {
			ct += pt.charAt(row*key.length()+col);
                    }
                }
            }
	}
	return ct;
    }
}
