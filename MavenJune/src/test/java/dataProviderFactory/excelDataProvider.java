package dataProviderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelDataProvider {
	
	//if u are using .xls file use hssf
	//.xlsx use xssf
	
	XSSFWorkbook wb;
	
	
	public excelDataProvider() throws FileNotFoundException, IOException
	{
		wb=new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/testdata/testdata.xlsx/")));
	}
	
	
	public String getCellData(String sheetName,int row,int col)
	{ 
		XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(col);// getting to sheet then row and then column that is passed in the method and following code checks what is inside

        String data=null;
        if(cell.getCellType()== CellType.STRING)
        {
        	data=cell.getStringCellValue();
        	
        }
        
        else if(cell.getCellType()==CellType.NUMERIC)
        {
        	data=String.valueOf((double)cell.getNumericCellValue());/// get the numeric value of the datasheet and then convert into string then store in data and then sendkeys send it to the field
        }
        
        else if(cell.getCellType()==CellType.BLANK)
        {
        	data="";
        	
        }
        return data; // returns the data 
	}
	
	public int getRows(String sheetName)
	{
		return wb.getSheet(sheetName).getPhysicalNumberOfRows(); //num of rows with data
	}

	public int getColumns(String sheetName)
	{
		return wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
		
	}
}
