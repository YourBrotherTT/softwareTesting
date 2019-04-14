package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class InputExcel {
	public List<People> importXLS(){

	    ArrayList<People> list = new ArrayList<>();
	    try {
	    	//1、获取文件
	    	File excelFile = new File("/Users/a1/Downloads/软件测试名单.xlsx");
	    	InputStream is = new FileInputStream(excelFile);
	    	//2、获取Excel工作簿对象
	    	XSSFWorkbook wb = new XSSFWorkbook(is);
	        //3、得到Excel工作表对象
	    	XSSFSheet sheet = wb.getSheetAt(0);
	        //4、循环读取表格数据
	    	
	    	
	    	for(int j=2;j<=sheet.getLastRowNum();j++) { 
				XSSFRow xssfRow = sheet.getRow(j);
				if(xssfRow != null) {
					People peo = new People();
					//XSSFCell id = xssfRow.getCell(0);
					XSSFCell id = xssfRow.getCell(1);
					id.setCellType(CellType.STRING);
					XSSFCell name = xssfRow.getCell(2);
					XSSFCell url = xssfRow.getCell(3);
					//inf.id = getValue(id);
					peo.id = String.valueOf(id.getStringCellValue());
					peo.name = String.valueOf(name.getStringCellValue());
					peo.url = String.valueOf(url.getStringCellValue());
					list.add(peo);
				}
			}
	        //5、关闭流 
	        wb.close();
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }finally{    
        }
	    return list;
	    
	}
}
