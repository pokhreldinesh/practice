package test.java.foodstampfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class FoodStampGetData {
	public static void main(String[] args) throws DocumentException {
		boolean foodstampEligible = false;
		String eligible = "not eligible";

		try {
			File excel = new File("C://temp/Foodstamp ids.xlsx");
			FileInputStream fis = new FileInputStream(excel);
			XSSFWorkbook book = new XSSFWorkbook(fis);
			XSSFSheet sheet = book.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();
			
			// Iterating over Excel file in Java
			Row row = itr.next();
			while (itr.hasNext()) {
				row = itr.next();
				// Iterating over each column of Excel file
				Iterator<Cell> cellIterator = row.cellIterator();

				Cell cell = cellIterator.next();
				String id = String.valueOf((int) cell.getNumericCellValue());
				cell = cellIterator.next();
				String firstName = cell.getStringCellValue();
				cell = cellIterator.next();
				String lastName = cell.getStringCellValue();
				cell = cellIterator.next();
				double headCount = cell.getNumericCellValue();
				int headCountInt = (int) headCount;
				cell = cellIterator.next();
				double income = cell.getNumericCellValue();
				cell = cellIterator.next();
				String houseNumber = String.valueOf((int) cell.getNumericCellValue());
				cell = cellIterator.next();
				String street = cell.getStringCellValue();
				cell = cellIterator.next();
				String city = cell.getStringCellValue();
				cell = cellIterator.next();
				String county = cell.getStringCellValue();
				if (income <= 30000.00 && headCountInt == 1)
					foodstampEligible = true;
				else if (income <= 45000.00 && headCountInt >= 2)
					foodstampEligible = true;
				else if (income <= 60000.00 && headCountInt >= 3)
					foodstampEligible = true;
				else if (income <= 80000.00 && headCountInt >= 4)
					foodstampEligible = true;
				else if (income <= 120000.00 && headCountInt >= 5)
					foodstampEligible = true;
				else
					foodstampEligible = false;
				
				if (foodstampEligible == true) {
					eligible = "Eligible";
					
				}
				else {
					eligible = "Not eligible";
				}

				DecimalFormat df = new DecimalFormat("#.00");

				Document document = new Document();
				String fileName = id + firstName +".pdf";
				PdfWriter.getInstance(document, new FileOutputStream(fileName)); 
				document.open();
				Font font = FontFactory.getFont(FontFactory.COURIER, 20, Font.BOLD, BaseColor.BLUE);
				Font font1 = FontFactory.getFont(FontFactory.COURIER, 18, BaseColor.BLACK);
				
				String header = "              Food Stamp Program";
				String stringToWrite1 = firstName + " " + lastName;
				String stringToWrite2 =	"Income: $" + df.format(income);
				String stringToWrite3 = "Household head count: " + headCountInt;
				String stringToWrite4 = "Address: " + houseNumber + " " + street;
				String stringToWrite5 = "City: " + city + ", County: " + county;
				String stringToWrite6 = "Status for Food Stamp: " + eligible;
				
				document.add(new Paragraph(header,font));
				document.add(new Paragraph(stringToWrite1,font1));
				document.add(new Paragraph(stringToWrite2));
				document.add(new Paragraph(stringToWrite3));
				document.add(new Paragraph(stringToWrite4));
				document.add(new Paragraph(stringToWrite5));
				document.add(new Paragraph(stringToWrite6));
				document.close();
				
				System.out.println(header);
				System.out.println("{" + id + ", First Name: " + firstName + ", Last Name:  " + lastName + ", Income:  "
						+ df.format(income) + ", Head Count: " + headCountInt + "\nAddress: " + houseNumber + " " + street + ", " 
						+ city + ", " + county + ", Eligible for Foodstamp: " + foodstampEligible + "}\n");
			}

			book.close();
			fis.close();
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

}
