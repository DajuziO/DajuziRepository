package Utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ReadExcelUtil {
    protected static Log log = new Log(ReadExcelUtil.class);
    static String path;

    /**
     * Excel文件读取
     * @return
     * @throws IOException
     */
    @SuppressWarnings("deprecation")
    public static Iterator getStringData() throws IOException {
        Map<String, String> map = null;
        path = System.getProperty("user.dir") + "\\testdata\\testdata.xls";
        FileInputStream in = new FileInputStream(path);
        HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(in));
        Sheet sheet = wb.getSheetAt(0);
        // 行数
        int rowNums = sheet.getPhysicalNumberOfRows();
        //log.info("the rowNumber is:" + rowNums);
        Row header = sheet.getRow(0);
        // 列数
        int cellNums = header.getPhysicalNumberOfCells();
        //log.info("the cellNumber is:" + cellNums);
        List data = new ArrayList();
        String[] keys = new String[cellNums];
        for (int rowNum = 0; rowNum < rowNums; rowNum++) {
            map = new HashMap<String, String>();
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                continue;
            }
            String value = null;
            for (int cellNum = 0; cellNum < cellNums; cellNum++) {
                Cell cell = row.getCell(cellNum);
                if (cell == null) {
                    continue;
                } else {
                    value = "";
                }
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        value = cell.getRichStringCellValue().getString();
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            value = cell.getDateCellValue().toString();
                        } else {
                            value = Double.toString((int) cell.getNumericCellValue());
                        }
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        value = Boolean.toString(cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_FORMULA:
                        value = cell.getCellFormula().toLowerCase();
                        break;
                    default:
                        value = " ";
                }
                //log.info("the value is:" + value);
                if(rowNum == 0) {
                    keys[cellNum] = value;
                } else {
                    map.put(keys[cellNum], value);
                }
            }
            if(rowNum != 0) {
                data.add(map);
            }
        }
        in.close();
        wb.close();
        return data.iterator();
    }

}
