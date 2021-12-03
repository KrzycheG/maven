
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Maven {


    public static void excelReader(String FileLocation) throws IOException{

        FileInputStream file = new FileInputStream(FileLocation);

        Workbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);

        int numberOfString = 0;
        double numericNumSUm = 0;
        int booleanSum = 0;

        for (Row row : sheet) {
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                if (cell.getCellType() == CellType.STRING) {

                    numberOfString++;
                }

                if (cell.getCellType() == CellType.NUMERIC) {

                    numericNumSUm += cell.getNumericCellValue();
                }

                if (cell.getCellType() == CellType.BOOLEAN) {

                    booleanSum++;

                }

            }
        }

        System.out.println("Number of Strings: " + numberOfString);
        System.out.println("Numeric numbers sum: "+(long) numericNumSUm);
        if(booleanSum == 0 ){

            System.out.println("No Booleans in a given file");

        }
        else{

            System.out.println("Number of Booleans: " + booleanSum);
        }
        file.close();

    }

    public static void main(String[] args) throws IOException{


        excelReader("Financial Sample.xlsx");






    }


}
