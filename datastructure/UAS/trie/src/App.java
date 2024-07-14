import system.excel;

public class App {
    public static void main(String[] args) throws Exception {
        excel patient = new excel();
        String name = patient.ReadExcel("Sheet1", 1, 1);
        System.out.println("Patient's name is : " + name);
    }
}
