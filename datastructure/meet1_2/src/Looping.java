public class Looping {
    public static void main(String[] args) throws Exception{
        //for loop
        System.out.println("For loop = ");
        for(int i=0; i<3; i++)
            System.out.print(i + " ");
        //while loop
        System.out.println("While loop = ");
        int j = 0;
        while (j<3)
        {
            System.out.print(j+" ");
            j++;
        }
        System.out.println();
        //do-while loop
        System.out.println("Do-while loop = ");
        int k=0;
        do{
            System.out.print(k + " ");
            k++;
        }while (k<3);
        System.out.println();



    }
}
