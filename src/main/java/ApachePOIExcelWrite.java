import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ApachePOIExcelWrite {

    private static final String FILE_NAME = "src/main/resources/Excel.xlsx";

    public void createExcel(List<Patient>  patientList) {
        System.out.println("Creating excel");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Pracownicy");
        creatingDataExcel(sheet, patientList);

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Finish");
    }

    private void creatingDataExcel(XSSFSheet sheet, List<Patient> patientList) {
        int rowNum = 0;
        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue("Imię");
        row.createCell(1).setCellValue("Nazwisko");
        row.createCell(2).setCellValue("Pesel");
        row.createCell(3).setCellValue("Kwota wizyty");
        for (Patient patient : patientList) {
            row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(patient.getName());
            row.createCell(1).setCellValue(patient.getSurname());
            row.createCell(2).setCellValue(patient.getPesel().toString());
            row.createCell(3).setCellValue(patient.getWallet());

        }
    }
}
