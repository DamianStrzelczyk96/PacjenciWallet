import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ApachePOIExcelRead {

    private static final String FILE_NAME = "src/main/resources/Excel.xlsx";

    public List<Patient> getPatientList() {
        List<Patient> patientList = new ArrayList<>();

        try {
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            XSSFSheet datatypeSheet = workbook.getSheetAt(workbook.getNumberOfSheets()-1);
            for (int i = 1 ; i < datatypeSheet.getPhysicalNumberOfRows(); i++) {
                Row currentRow = datatypeSheet.getRow(i);
                patientList.add(new Patient(currentRow.getCell(0).toString(), currentRow.getCell(1).toString(), new BigInteger(currentRow.getCell(2).toString()), Double.valueOf(currentRow.getCell(3).toString())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return patientList;
    }
}