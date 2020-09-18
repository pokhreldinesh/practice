package test.java.foodstampfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
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
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class FoodStampGetData {
	
	public static boolean isEligible(double income, int headCountInt) {
		if (income <= 16248.00 && headCountInt >= 1)
			return true;
		else if (income <= 21984.00 && headCountInt >= 2)
			return true;
		else if (income <= 27732.00 && headCountInt >= 3)
			return true;
		else if (income <= 33480.00 && headCountInt >= 4)
			return true;
		else if (income <= 39228.00 && headCountInt >= 5)
			return true;
		else if (income <= 44976.00 && headCountInt >= 6)
			return true;
		else if (income <= 50724.00 && headCountInt >= 7)
			return true;
		else if (income <= 56460.00 && headCountInt >= 8)
			return true;		
		return false;
	}
	
	public static double benefitAmount(int headCountInt) {
		if (headCountInt == 1)
			return 194 ;
		else if (headCountInt == 2)
			return 355;
		else if (headCountInt == 3)
			return 509;
		else if (headCountInt == 4)
			return 646;
		else if (headCountInt == 5)
			return 768;
		else if (headCountInt == 6)
			return 921;
		else if (headCountInt == 7)
			return 1018;
		else if (headCountInt >= 8)
			return 1164;		
		return -1;
	}
	
	public static void generateEligibleLetter(int idInt, String firstName, String lastName, double benefits) throws DocumentException, MalformedURLException, IOException {
		Document document = new Document();
		String fileName = idInt + firstName +".pdf";
		PdfWriter.getInstance(document, new FileOutputStream(fileName)); 
		document.open();
//		Font font = FontFactory.getFont(FontFactory.COURIER, 16, Font.BOLD, BaseColor.BLUE);
		DecimalFormat dec = new DecimalFormat("#.00");
		
	    //Add Image
	    Image img = Image.getInstance("SNAP Logo.PNG");    
	    img.setAbsolutePosition(32f, 720f);	//Fixed Positioning
	    img.scaleAbsolute(200, 100);	 //Scale to new height and new width of image
	    document.add(img);	//Add to document
		
//		String header = "    Supplemental Nutrition Assistance Program ";
		String stringToWrite1 = "Dear " + firstName + " " + lastName + ",";
		String stringToWrite2 =	"What DTA decided: The Department has reopened your SNAP case. Your benefits start on 09/08/2020 at $" +
				dec.format(benefits) + " per month.";
		String stringToWrite3 = "How we decided your benefit amount: Go to the pages at the of this notice to see how we decided your benefit amount.";
		String stringToWrite4 = "You will get your SNAP benefits on the 8th of each month." ;
		String stringToWrite5 = "The first SNAP benefit may be different from your regular monthly amount because it is for the period of 09/08/2018 to 10/07/2020." ;
		String stringToWrite6 = "Your certification period for SNAP benefits is from 09/08/2020 to 09/07/2021.";
		String stringToWrite7 = "Sincerely,";
		String stringToWrite8 = "Department of Transitional Assistance";
		
		//document.add(new Paragraph(header,font));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(stringToWrite1));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(stringToWrite2));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(stringToWrite3));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(stringToWrite4));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(stringToWrite5));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(stringToWrite6));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(stringToWrite7));
		document.add(new Paragraph(stringToWrite8));
		document.close();
	}
	
	public static void generateNotEligibleLetter(int idInt, String firstName, String lastName, double income, int headCountInt)
			throws DocumentException, MalformedURLException, IOException {
		Document document = new Document();
		String fileName = idInt + firstName +".pdf";
		PdfWriter.getInstance(document, new FileOutputStream(fileName)); 
		document.open();
//		Font font = FontFactory.getFont(FontFactory.COURIER, 16, Font.BOLD, BaseColor.BLUE);
//		Font font1 = FontFactory.getFont(FontFactory.COURIER, 18, BaseColor.BLACK);
		
	    //Add Image
	    Image img = Image.getInstance("SNAP Logo.PNG");
	    //Fixed Positioning
	    img.setAbsolutePosition(32f, 720f);
	    //Scale to new height and new width of image
	    img.scaleAbsolute(200, 100);
	    //Add to document
	    document.add(img);
		
		DecimalFormat dec = new DecimalFormat("#.00");
//		String header = "    Supplemental Nutrition Assistance Program ";
		String stringToWrite1 = "Dear " + firstName + " " + lastName + ",";
		String stringToWrite2 =	"What DTA decided: The Department has reopened your SNAP case. We are sorry to let you know that you are not eligible for " 
		+ "SNAP benefits.";
		String stringToWrite3 = "How we decided your benefit amount: Go to the pages at the of this notice to see how we decided your benefit amount.";
		String stringToWrite4 = "Your income is exceeded the maximum amount for the number of members in your household" ;
		String stringToWrite5 = "Your anual income is $" + dec.format(income);
		String stringToWrite6 = "Your household head count is " + headCountInt;
		String stringToWrite7 = "Sincerely,";
		String stringToWrite8 = "Department of Transitional Assistance";
		
//		document.add(new Paragraph(header,font));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));

		document.add(new Paragraph(" "));
		document.add(new Paragraph(stringToWrite1));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(stringToWrite2));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(stringToWrite3));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(stringToWrite4));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(stringToWrite5));
		document.add(new Paragraph(stringToWrite6));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(stringToWrite7));
		document.add(new Paragraph(stringToWrite8));
		document.close();
	}
	
	public static void main(String[] args) throws DocumentException {
		boolean eligible = false;
		
		try {
			File excel = new File("C:\\Users\\XPS\\git\\practice\\foodstamp_profiles.xlsx");
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
				double id = cell.getNumericCellValue();
				int idInt = (int)id;
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

				eligible = isEligible(income,headCountInt);
				if (eligible) {
					double benefits = benefitAmount(headCountInt);
					System.out.println(benefits);
					generateEligibleLetter(idInt, firstName, lastName, benefits);	
				}else
					generateNotEligibleLetter(idInt, firstName, lastName, income, headCountInt);

				DecimalFormat df = new DecimalFormat("#.00");

				String header = "              Food Stamp Program";
				System.out.println(header);
				System.out.println("{" + id + ", First Name: " + firstName + ", Last Name:  " + lastName + ", Income:  "
						+ df.format(income) + ", Head Count: " + headCountInt + "\nAddress: " + houseNumber + " " + street + ", " 
						+ city + ", " + county + ", Eligible for Foodstamp: " + eligible + "}\n");
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
