package datstruct.system;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import java.io.IOException;

public class excel {
    String path;
    public excel(String path){
        this.path = path;
    }

    public String ReadExcel(String ShName, int rNum, int cNum){
        String data = " ";
        try{
            FileInputStream fis = new FileInputStream(path);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sh = wb.getSheet(ShName);
            Row r = sh.getRow(rNum);
            Cell c = r.getCell(cNum);
            data = c.getStringCellValue();
        }catch(Exception e){
            System.out.println("ReadExcel catch block");
            e.printStackTrace();
        }
        return data;
    }

    public void WriteExcel(String ShName, int rNum, int cNum, String Data){
        try{
            FileInputStream fis = new FileInputStream(path);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sh = wb.getSheet(ShName);
            Row r = sh.getRow(rNum);
            Cell c = r.getCell(cNum);
            c.setCellValue(Data);
            FileOutputStream fos = new FileOutputStream(path);
            wb.write(fos);
        }catch(Exception e){
            System.out.println("ReadExcel catch block");
            e.printStackTrace();
        }
    }
}
