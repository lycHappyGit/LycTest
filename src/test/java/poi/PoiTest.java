package poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

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
}
