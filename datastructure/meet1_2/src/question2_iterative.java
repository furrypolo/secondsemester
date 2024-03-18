import java.util.Scanner;

public class question2_iterative {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.print("a = ");
        int a=input.nextInt();
        System.out.println(" ");
        System.out.print("b = ");
        int b=input.nextInt();
        System.out.println(" ");
        genap(a,b);
    }

    public static void genap(int a, int b){
        while(a<=b)
        {
            if(a%2 == 0)
            {   
                System.out.printf("%d ", a);
            }
            a++;
        }
    }
}