import java.util.Scanner;

public class Rekursif {
    private static int faktorialIteratif(int n){
        int result = 1;
        for(int x=n; x>0; x--)
        {
            result = result * x;
        }
        return result;
    }

    private static int faktorialRekursif(int n){
        if(n<=1)
            return 1;
        else
            return(n*faktorialRekursif(n-1));
    }
    public static void main(String[] args){
        //ask input user
        Scanner reader = new Scanner(System.in);
        System.out.print("Masukkan n = ");
        int n = reader.nextInt();

        System.out.println("Hasil Iteratif = " + faktorialIteratif(n));
        System.out.println("Hasil Rekursif= " + faktorialRekursif(n));

    }
}
