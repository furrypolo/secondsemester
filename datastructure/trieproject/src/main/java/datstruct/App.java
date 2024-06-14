package datstruct;
import datstruct.system.excel;
import datstruct.system.Trie;
import datstruct.system.patientsData;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Trie patients = new Trie();
        String[][] notrie = new String[305][6];
        excel patient = new excel("C:\\Users\\Lenovo\\repos\\secondsemester\\datastructure\\trieproject\\src\\main\\java\\datstruct\\datas.xlsx");
        int x;
        int num = 0;
        System.out.println("Importing data...");
        for(x=0; x<300; x++){
            System.out.println(x);
            String name = patient.ReadExcel("patients", x, 0);
            notrie[x][0] = name;
            String address = patient.ReadExcel("patients", x, 1);
            notrie[x][1] = address;
            String gender = patient.ReadExcel("patients", x, 2);
            notrie[x][2] = gender;
            String phone = patient.ReadExcel("patients", x, 3);
            notrie[x][3] = phone;
            String ktp = patient.ReadExcel("patients", x, 4);
            notrie[x][4] = ktp;
            String birth = patient.ReadExcel("patients", x, 5);
            notrie[x][5] = birth;
            String[][] history = new String[50][4];
            int count = 0;       
            boolean right = false;
            boolean passed = false;
            for(int y=num; y<502; y++){
                String histname = patient.ReadExcel("histories", y, 0);
                if(histname.equals(name)){
                    history[count][0] = patient.ReadExcel("histories", y, 1);
                    history[count][1] = patient.ReadExcel("histories", y, 2);
                    history[count][2] = patient.ReadExcel("histories", y, 3);
                    count++;
                    num++;
                    right = true;
                }
                else if(name.charAt(0) == histname.charAt(0) && !passed){
                    passed = true;
                }
                else if(name.charAt(0) != histname.charAt(0) && passed){
                    break;
                }
                if(!histname.equals(name) && right){
                    break;
                }
            }
            patientsData patientdata = new patientsData(name, address, gender, phone, ktp, birth, history);
            patients.insert(name, patientdata);
        }
        System.out.println("");


        String search = "Yoga Satria Perdana";
        long start = System.currentTimeMillis();
        patients.display(search);
        long end = System.currentTimeMillis();
        long total = end - start;
        System.out.println("Time used to search in trie = " + total + " miliseconds.");
        System.out.println("");
        start = System.currentTimeMillis();
        for(x=0; x<notrie.length; x++){
            String runname = notrie[x][0];
            if(runname.equals(search)){
                System.out.println("Nama = " + notrie[x][0]);
                System.out.println("Alamat = " + notrie[x][1]);
                System.out.println("Gender = " + notrie[x][2]);
                System.out.println("Nomor telepon = " + notrie[x][3]);
                System.out.println("Nomor KTP = " + notrie[x][4]);
                System.out.println("Tanggal lahir = " + notrie[x][5]);
                break;
            }
        }
        end = System.currentTimeMillis();
        total = end - start;
        System.out.println("Time used to search without trie = " + total + " miliseconds.");
        System.out.println("");
        Scanner input = new Scanner(System.in);
        String whatever = input.nextLine();


        boolean still = true;
        while(still){
            clearscreen();
            System.out.print("1. Pasien terdaftar \n2. Pasien baru \nMasukkan pilihan anda = (1,2)");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama pasien yang dicari = ");
                    String person = input.nextLine();
                    clearscreen();
                    if(patients.search(person)){
                        System.out.print("1. Tampilkan data pasien \n2. Tampilkan riwayat kesehatan pasien \n3. Tampilkan keduanya \n4. Tambahkan riwayat \n5. Ulang \n6. Keluar \nMasukkan pilihan anda = (1,2,3,4,5,6)");
                        int choice2 = input.nextInt();
                        input.nextLine();
                        clearscreen();
                        switch (choice2) {
                            case 1:
                                System.out.println("Data pasien");
                                patients.display(person);
                                System.out.print("Ingin lanjut? (Y/N)");
                                String conti = input.nextLine();
                                if(conti.equals("N") || conti.equals("n")){
                                    still = false;
                                }
                                break;
                            case 2:
                                System.out.println("Riwayat Kesehatan " + person);
                                patientsData result = patients.get(person);
                                result.displayHistory();
                                System.out.print("Ingin lanjut? (Y/N)");
                                conti = input.nextLine();
                                if(conti.equals("N") || conti.equals("n")){
                                    still = false;
                                }
                                break;
                            case 3:
                                System.out.println("Data dan Riwayat Kesehatan Pasien");
                                System.out.println("\n--Data Pasien--");
                                result = patients.get(person);
                                result.displayData();
                                System.out.println("");
                                System.out.println("--Riwayat Kesehatan Pasien--");
                                result.displayHistory();
                                System.out.print("Ingin lanjut? (Y/N)");
                                conti = input.nextLine();
                                if(conti.equals("N") || conti.equals("n")){
                                    still = false;
                                }
                                break;
                            case 4:
                                result = patients.get(person);
                                System.out.print("Masukkan Penyakit = ");
                                String disease = input.nextLine();
                                System.out.print("Nama Dokter yang melayani = "); 
                                String doctor = input.nextLine();
                                System.out.print("Tanggal kedatangan = "); 
                                String date = input.nextLine();
                                result.addHistory(disease, doctor, date);
                                System.out.print("Berhasil! Ingin lanjut? (Y/N)");
                                conti = input.nextLine();
                                if(conti.equals("N") || conti.equals("n")){
                                    still = false;
                                }
                            case 5:
                                break;
                            case 6:
                                still = false;
                                break;
                            default:
                                System.out.println("Kode yang anda masukkan salah, Ingin lanjut? (Y/N)");
                                conti = input.nextLine();
                                if(conti.equals("N") || conti.equals("n")){
                                    still = false;
                                }
                                break;                     
                            }
                    }    
                else{
                    System.out.print("Pasien tidak ditemukan! Ingin lanjut? (Y/N)");
                    String conti = input.nextLine();
                    if(conti.equals("N") || conti.equals("n")){
                        still = false;
                    }
                }
                break;
            case 2:
                System.out.print("Nama Pasien = "); 
                String name = input.nextLine();
                System.out.print("Alamat = "); 
                String address = input.nextLine();
                System.out.print("Jenis Kelamin = (P/L)"); 
                String gender = input.nextLine();
                System.out.print("Telepon = "); 
                String phone = input.nextLine();
                System.out.print("Nomor KTP = "); 
                String ktp = input.nextLine();
                System.out.print("Tanggal Lahir = (DD Month YYYY) "); 
                String birth = input.nextLine();
                String[][] history = new String[50][4];
                patientsData patientdata = new patientsData(name, address, gender, phone, ktp, birth, history);
                patients.insert(name, patientdata);
                patientsData result = patients.get(name);
                System.out.print("Pasien terdaftar! \nMasukkan Penyakit = ");
                String disease = input.nextLine();
                System.out.print("Nama Dokter yang melayani = "); 
                String doctor = input.nextLine();
                System.out.print("Tanggal kedatangan = "); 
                String date = input.nextLine();
                result.addHistory(disease, doctor, date);
                System.out.print("Ingin lanjut? (Y/N)");
                String conti = input.nextLine();
                if(conti.equals("N") || conti.equals("n")){
                    still = false;
                }
                break;
            default:
                System.out.println("Kode yang anda masukkan salah, Ingin lanjut? (Y/N)");
                conti = input.nextLine();
                if(conti.equals("N") || conti.equals("n")){
                    still = false;
                }
            break;                     
            }
        }
        input.close();
        clearscreen();
        System.out.println("Terima kasih telah menggunakan sistem kami!");
        
    }

    public static void clearscreen(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
