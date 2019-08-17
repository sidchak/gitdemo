

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	public ArrayList<String> GetData(String testcaseName) throws IOException
	{
ArrayList<String> a =new ArrayList<String>();
		
		FileInputStream f = new FileInputStream("C:\\Users\\sid\\Desktop\\Selenium\\Master Template.xlsx");
		XSSFWorkbook w = new XSSFWorkbook(f);
		
		int sheets = w.getNumberOfSheets();
		
		
		for(int i=0;i<sheets;i++)
		{
			if(w.getSheetName(i).equalsIgnoreCase("Kimberly"))
			{
			   XSSFSheet sheet	=w.getSheetAt(i);
			   System.out.println("sheetno: "+i);
			   
			   Iterator<Row> rows = sheet.iterator();
			   Row first = rows.next();
			   Iterator<Cell> ce=first.cellIterator();
			   
			   int k = 0;
			   int coloumn=0;
			   while(ce.hasNext())
			   {
				   Cell value = ce.next();
				  if( value.getStringCellValue().equalsIgnoreCase("Sites"))
				  {
					  coloumn = k;
					  
				  }
			       k++;
			   }
			   System.out.println(coloumn);
			   //once coloumn is identified then scan the entire column to identify the desired row//
			   
			   while(rows.hasNext())
			   {
				   Row r =rows.next();
				 if( r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("cde"))
				 {
					 //after grabbing fdg row = pull  all the data of the row and feed to the testcase
					 
					Iterator<Cell> cv= r.cellIterator();
					while(cv.hasNext())
					{
					//	System.out.println(cv.next().getStringCellValue());
						a.add(cv.next().getStringCellValue());
					}
					
				 }
			       
			   
			   }
			   
			  
			}
		}
		return a; 	

	}

	public static void main(String[] args) throws IOException {
		
		
	}

}
