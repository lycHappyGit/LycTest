package poi;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.*;
import org.junit.Test;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

public class PoiTest {

	public <T> void export(String[] title,List<T> dataList,String[] orderKey){


		File file = new File("d:/poi_test.xls");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		HSSFWorkbook workbook = null;
		try {
			workbook = new HSSFWorkbook(new FileInputStream(file));
			HSSFSheet sheet = workbook.getSheetAt(0);
			HSSFRow row_title = sheet.getRow(0);
			//标题头
			for(int i=0;i<title.length;i++){
				HSSFCell cell = row_title.getCell(i,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				cell.setCellValue(title[i]);
			}
			JSONArray parseArra = JSONObject.parseArray(JSONObject.toJSONString(dataList));
			Iterator<Object> iterator = parseArra.iterator();
			for(int i=0;i<orderKey.length;i++){

			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Test
	public void read() throws Exception {
		FileInputStream fis = new FileInputStream("D:/mlamp/gxml_list_template.xlsx");
		XSSFWorkbook sheets = new XSSFWorkbook(fis);
		XSSFSheet sheetAt = sheets.getSheetAt(0);
		for(Row row : sheetAt){
			int i = 0;
			for(Cell cell : row){
				String cellValue = getCellValue(cell, row.getRowNum() + 1, i + 1);
//				String cellValue = cell.getStringCellValue();
				i++;
				System.out.print("---------\t" + cellValue);
			}
			System.out.println();
		}
		fis.close();
		sheets.close();
	}

	@Test
	public void write() throws Exception{
		XSSFWorkbook sheets = new XSSFWorkbook();
		XSSFSheet sheet = sheets.createSheet();
		XSSFDrawing drawingPatriarch = sheet.createDrawingPatriarch();
		XSSFRow row = sheet.createRow(0);
		int i = 0;
		//添加 共享类目 管理域
		XSSFCell cell1 = row.createCell(i);
		cell1.setCellValue("共享类目");
		XSSFComment comment = drawingPatriarch.createCellComment(new XSSFClientAnchor(0, 0, 0,0, (short) 1, 1, (short) 10, 10));
		comment.setString(new XSSFRichTextString("类型:1\n共享类目批注"));
		cell1.setCellComment(comment);
		i++;
		XSSFCell cell2 = row.createCell(i);
		cell2.setCellValue("管理域");
		XSSFComment comment2 = drawingPatriarch.createCellComment(new XSSFClientAnchor(0, 0, 0,0, (short) 3, 1, (short) 3, 1));
		comment2.setString(new XSSFRichTextString("管理域批注"));
		cell2.setCellComment(comment2);

		System.out.println("------------------------lastCellNum: "+row.getLastCellNum());

		FileOutputStream fos = new FileOutputStream("D:/aa/1.xlsx");
		sheets.write(fos);
		sheets.close();
		fos.close();
	}

	/**
	 * 读取单元格的值
	 * @param cell
	 * @param rowNum
	 * @param colNum
	 * @return
	 */
	private String getCellValue(Cell cell, int rowNum, int colNum) {
		String cellValue = null;
		if (cell == null) {
			return cellValue;
		}
		//判断数据的类型
		switch (cell.getCellTypeEnum()) {
			case NUMERIC:
				double numericCellValue = cell.getNumericCellValue();
				String format = new DecimalFormat("#").format(numericCellValue);
				if(Long.parseLong(format) == numericCellValue){
					cellValue = format;
				}else{
					cellValue = String.valueOf(numericCellValue);
				}
				break;
			case STRING:
				cellValue = String.valueOf(cell.getStringCellValue());
				break;
			case BOOLEAN:
				cellValue = String.valueOf(cell.getBooleanCellValue());
				break;
			case FORMULA:
				cellValue = String.valueOf(cell.getCellFormula());
				break;
			case BLANK:
				cellValue = "";
				break;
			case ERROR:
			default:
				throw new RuntimeException("共享目录批量导入异常: 错误的值 第" + rowNum + "行,第" + colNum + "列");
		}
		return cellValue;
	}

	@Test
	public void test() throws Exception {

		Workbook sheets = new HSSFWorkbook();
		Sheet sheet = sheets.createSheet("lycSheet");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("lycTest");
		Cell cell2 = row.createCell(1);
		cell2.setCellValue("lycTest2");
		FileOutputStream fos = new FileOutputStream("D:/aa/1.xls");
		sheets.write(fos);
		fos.close();
		sheets.close();
	}

	@Test
	public void test2() throws Exception {

		FileInputStream fis = new FileInputStream("D:/aa/gxml_list_template.xlsx");
		Workbook sheets = new XSSFWorkbook(fis);
		Sheet sheet = sheets.getSheetAt(0);
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		for(Row row : sheet){
			int rowNum = row.getRowNum();
			System.out.println("lastCellNum is : " + lastCellNum + "rowNum is : " + rowNum);
			for(Cell cell : row){
				System.out.print(getCellValue(row.getCell(lastCellNum-1), 1, 1));
			}
		}
	}
}
