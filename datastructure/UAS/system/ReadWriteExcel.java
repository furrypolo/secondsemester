package system;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import java.io.IOException;

public class ReadWriteExcel {
    public static void main(String[] args){

    }

    public String ReadExcel(String ShName, int rNum, int cNum){
        String data = " ";
        try{
            FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\repos\\secondsemester\\datastructure\\UAS\\try2.xlsx");
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sh = wb.getSheet(ShName);

        }catch(Exception e){
            System.out.println("ReadExcel catch block");
            e.printStackTrace();
        }
        

        return data;
    }
}