import java.util.Scanner;

public class question5_recursive {
    
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.print("n= ");
        int n = input.nextInt();
        int[] a = new int[n+1];
        int i;
        System.out.println(" ");

        for(i=0; i<=n; i++)
        {
            System.out.printf("%s%d%s", "a ke-", i, "= ");
            a[i] = input.nextInt();
        }

        int t=0;
        
        int result=fungsi(a, n, t);
        System.out.print(result);
    }

    public static int fungsi(int[] a, int n, int t)
    {
        if(t<=n)
        {
            int x=a[t] + fungsi(a, n, t+1);
            return x;
        }
        else
        {
            return 0;
        }
    } 
}
