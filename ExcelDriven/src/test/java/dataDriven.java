import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	//@SuppressWarnings("deprecation")
	
	public ArrayList<String> getData(String testcasename) throws IOException {

		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("//Users//ramki//Downloads//Rubriks testcase.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheet = workbook.getNumberOfSheets();
		System.out.println(sheet);
		for (int i = 0; i < sheet; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("sheet3")) {
				XSSFSheet sheet1 = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet1.iterator();
				Row firstrow = rows.next();
				Iterator<Cell> cel = firstrow.cellIterator();
				int k = 0;
				int column = 0;
				while (cel.hasNext()) {
					Cell value = cel.next();
					// System.out.println("hello");
					if (value.getStringCellValue().equalsIgnoreCase("Test Case Id")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) {
						System.out.println("hello");
						Iterator<Cell> c = r.cellIterator();
						while (c.hasNext()) {
							Cell f=c.next();
							
							a.add(c.next().getStringCellValue());
						}
					}

				}

			}

		}
		//return a;
		return a;

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	}

//	public ArrayList getData1(String testcasename) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
