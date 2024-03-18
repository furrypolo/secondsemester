public class Selection {
    public static void main(String[] args) throws Exception{
        boolean status = true;
        int bil1 = 5, bil2 = 10;

        if(status)
        {
            System.out.println("status ok...");
            if(bil1 != bil2)
                System.out.println(bil1 + "\u2260" + bil2);
        }

        if(bil1 + bil2 > 0)
            System.out.println(bil1 + " + " + bil2 + " = " + (bil1+bil2));
        else
            System.out.println("Tidak valid...");
        
        if(bil1<bil2)
            System.out.println(bil1 + " < " + bil2);
        else if(bil1>bil2)
            System.out.println(bil1 + " > " + bil2);
        else
            System.out.println(bil1 + " = " + bil2);
    }
}
