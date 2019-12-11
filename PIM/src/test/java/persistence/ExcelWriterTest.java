package persistence;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelWriterTest {

    //@Test
    public void createWorkBookTest() throws ClassNotFoundException, SQLException, IOException {
        ExcelWriter excelWriter = new ExcelWriter();
        Workbook workbook = excelWriter.createWorkBook();
    }

}
