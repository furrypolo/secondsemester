import java.util.Scanner;

public class question2_recursive {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("a = ");
        int a = input.nextInt();
        System.out.println(" ");
        System.out.print("b = ");
        int b = input.nextInt();
        System.out.println(" ");

        genap(a,b);
    }

    public static void genap(int a, int b){
        if(a<b)
        {
            int x=a%2;
            if(x == 0)
            {
                int n=a+1;
                System.out.print(a + " ");
                genap(n,b);
            }
            else
            {
                int n=a+1;
                genap(n,b);
            }
        }
        else if(a==b)
        {
            int x=a%2;
            if(x == 0)
            {
                System.out.print(a);
            }
    }
}
}
