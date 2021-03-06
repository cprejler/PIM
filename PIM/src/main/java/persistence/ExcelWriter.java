package persistence;

import businesslogic.Product;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

    /**
     * 
     * @return Returns a workbook generated from all the products in the database
     * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using:
     * @throws SQLException An exception that provides information on a database access error or other errors.
     * @throws FileNotFoundException Signals that an attempt to open the file denoted by a specified pathname has failed.
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
     */
    public Workbook createWorkBook() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

        ProductMapper pMapper = new ProductMapper();

        ArrayList<String> productTypes = pMapper.getTableNames();

        ArrayList<ArrayList<Product>> products = new ArrayList();

        for (String productType : productTypes) {
            products.add(pMapper.showProducts(productType));

        }

        Workbook workbook = new XSSFWorkbook();

        //For each product type create a sheet with that data
        for (ArrayList<Product> productType : products) {
            createSheet(workbook, productType);
        }

        return workbook;

    }

    //Generates a sheet and fills it with data for the specific product type
    private Sheet createSheet(Workbook workbook, ArrayList<Product> products) {
        ArrayList<String> headers = new ArrayList();

        for (String field : products.get(0).getFields()) {
            headers.add(field);
        }

        Sheet sheet = workbook.createSheet(products.get(0).getType());

        Font headerFont = workbook.createFont();

        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create header row
        Row headerRow = sheet.createRow(0);

        //Create the cells for the header row and populate them
        for (int i = 0; i < headers.size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers.get(i));
            cell.setCellStyle(headerCellStyle);
        }

        //Populate rest of the the rows with product data
        int rowNum = 1;

        for (Product product : products) {
            Row row = sheet.createRow(rowNum++);

            int cellCounter = 0;
            for (int i = 0; i < product.getFieldsValues().size(); i++) {
                row.createCell(cellCounter).setCellValue(String.valueOf(product.getFieldsValues().get(i)));
                cellCounter++;

            }

        }
        for (int i = 0; i < headers.size(); i++) {
            sheet.autoSizeColumn(i);
        }

        return sheet;

    }

}
