package page_factory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PageFac {
	
	public void exportData() {
		String jdbcURL = "jdbc:mysql://localhost:3306/webdb?useSSL=false";
        String username = "root";
        String password = "";
 
        String excelFilePath = "C:\\Users\\DELL\\eclipse-workspace\\Do_An_KTPM\\excelData\\DataDriven.xlsx";
 
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "SELECT * FROM tbltaikhoan";
 
            Statement statement = connection.createStatement();
 
            ResultSet result = statement.executeQuery(sql);
 
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Data");
 
            Row headerRow = sheet.createRow(0);
            
            Cell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("Email");
     
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("Password");
            
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("Roll");
 
            int rowCount = 1;
            
            while (result.next()) {
                String email = result.getString("email");
                String pass = result.getString("matkhau");
                String roll = result.getString("capbac");
     
                Row row = sheet.createRow(rowCount++);
     
                int columnCount = 0;
                Cell cell = row.createCell(columnCount++);
                cell.setCellValue(email);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(pass);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(roll);
            };
 
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
 
            statement.close();
 
        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        };
	};

}
