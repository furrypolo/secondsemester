import java.util.Scanner;
public class Strings {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        //Declaration and initialization
        String teks1 = new String("Hello World");
        String teks2 = "Halo Dunia";
        
        //Copy string
        String teks3;
        teks3=teks2;

        //Comparing strings
        if(teks2==teks3)
            System.out.println("the same");
        else
            System.out.println("not the same");
        System.out.println(teks2.equals(teks3));
        System.out.println(teks1.compareTo(teks2));
        
        //input strings
        Scanner scan = new Scanner(System.in);
        System.out.print("Nim: ");
        String nim = scan.nextLine();
        System.out.print("Name:");
        String name = scan.nextLine();
        System.out.print("Age: ");
        int age = scan.nextInt();
        scan.close();

        String prodi = nim.substring(0,3);
        if(prodi.equals("535"))
            prodi = "Teknik Informatika";
        else if(prodi.equals("825"))
            prodi = "Sistem Informasi";
        else
            prodi = "Untar";
        System.out.println(name + " usia " + age + " tahun adalah mahasiswa " + prodi);
    }
}
