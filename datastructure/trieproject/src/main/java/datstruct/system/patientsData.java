package datstruct.system;

import java.util.Date;

public class patientsData {
    String name;
    String address;
    String gender;
    String phone;
    String ktp;
    String birth;
    String[][] history;

    public patientsData(String name, String address, String gender, String phone, String ktp, String birth, String[][] history){
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
        this.ktp = ktp;
        this.birth = birth;
        this.history = history;
    }

    public void displayData(){
        System.out.println("Nama= " + this.name + "\nAlamat = " + this.address + "\nJenis Kelamin = " + this.gender + "\nNomor telepon = " + phone + "\nNomor KTP = " + ktp + "\nTanggal lahir = " + birth);
    }

    public void displayHistory(){
        for(int x=0; x<history.length; x++){
            if(history[x][0] == null){
                break;
            }
            System.out.println((x+1) + ". Tanggal Kedatangan = " + history[x][2]);
            System.out.println("Penyakit = " + history[x][0]);
            System.out.println("Dokter = " + history[x][1]);
        }
        System.out.println(" ");
    }

    public void addHistory(String disease, String Doctor, String Date){
        for(int x=0; x<history.length; x++){
            if(history[x][0] == null){
                history[x][0] = disease;
                history[x][1] = Doctor;
                history[x][2] = Date;
                break;
            }
        }
    }
    
    @Override
    public String toString(){
        String result = "Alamat = " + this.address + "\nJenis Kelamin = " + this.gender + "\nNomor telepon = " + phone + "\nNomor KTP = " + ktp + "\nTanggal lahir = " + birth;
        return result;
    }

}
