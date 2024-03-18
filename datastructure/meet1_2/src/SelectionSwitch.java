public class SelectionSwitch {
    public static void main(String[] args) throws Exception{
        byte pil = 1;
        switch (pil) {
            case 1:
                System.out.println("Pilihan ke-1");
                break;
            case 2:
                System.out.println("Pilihan ke-2");
                break;
            default:
                System.out.println("keluar");
                break;
        }
    }
}
