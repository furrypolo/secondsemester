import java.util.Scanner;

public class question5_iterative {

    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.print("n= ");
        int n = input.nextInt();
        int[] a = new int[n+1];
        int i, x;
        int result=0;
        System.out.println(" ");
        for(i=0; i<=n; i++)
        {
            System.out.printf("%s%d%s", "a ke-", i, "= ");
            x = input.nextInt();
            a[i] = x;
        }

        result = fungsi(a, n);
        System.out.print(result);
    }

    public static int fungsi(int[] a, int n){
        int i;
        int result=0;
        for(i=0; i<=n; i++)
        {
            result+=a[i];
        }
        return result;
    }
}
