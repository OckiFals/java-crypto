
package ockifals.crypto;

import java.util.Scanner;

public class Diffie {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan nilai p (harus prima) : ");
        int p = input.nextInt();
        System.out.print("Masukan nilai g (generator) : ");
        int g = input.nextInt();
        System.out.print("Masukan nilai secret key A : ");
        int a = input.nextInt();
        System.out.print("Masukan nilai secret key B : ");
        int b = input.nextInt();
        
        int ya = (int) Math.pow(g, a) % p;
        int yb = (int) Math.pow(g, b) % p;
        
        System.out.println("Nilai yA: " + ya);
        System.out.println("Nilai yB: " + yb);
        
        // perhitungan shared key
        int ya2 = (int) Math.pow(yb, a) % p;
        int yb2 = (int) Math.pow(ya, b) % p;
        
        System.out.println("Nilai shared key A: " + ya2);
        System.out.println("Nilai shared key B: " + yb2);
    }
    
}
