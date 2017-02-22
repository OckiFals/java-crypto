
package ockifals.crypto;


import java.util.Scanner;

public class Rsa {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan nilai p : ");
        int p = input.nextInt();
        System.out.print("Masukan nilai q : ");
        int q = input.nextInt();
        System.out.print("Masukan nilai m : ");
        int m = input.nextInt();
        
        // mencari nilai n
        int n = p*q;
        
        int totem = (p-1)*(q-1);    
        // mencari gembok e
        int e = 1;
        for (int i = 2; i < n; i++) {
            int a = i;
            int b = totem;
            int r = (int) (a - b * Math.floor( a/b )); 
            
            while(r != 0) {
                a = b;
                b = r;
                r = (int) (a - b * Math.floor( a/b )); 
            }
            
            if(b == 1) {
                e = i;
                break;
            }
        }
        System.out.println("Gembok : " + e);
        
        int d = 1;
        for (int i = 1; i < n; i++) {
            int modulo = (e*i) % totem;
            if(1 == modulo) {
                d = i;
                break;
            }
        }
        System.out.println("Kunci : " + d);
        
        int c = (int) Math.pow(m, e) % n;
        System.out.println("Pesan yang telah terenkripsi : " + c);
        
        int z = (int) Math.pow(c, d) % n;
        System.out.println("Pesan yang telah terdekripsi : " + z);
    }
    
}
