package system;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import java.io.IOException;

public class excel {

    public String ReadExcel(String ShName, int rNum, int cNum){
        String data = " ";
        try{
            FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\repos\\secondsemester\\datastructure\\UAS\\trie\\doctortry.xlsx");
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
}
