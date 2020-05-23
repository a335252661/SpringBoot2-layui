package com.example.untils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

/**
 * @author ??????
 * @version 1.0
 * @Description TODO
 * @date 2020/4/15
 */
public class WriterExcelHelp {

    private static XSSFWorkbook wb = new XSSFWorkbook();
    private static XSSFSheet sheet=null;
    private static int rownum = 0;
    private static int cellnum = 0;

    public static void generateExcelFile(String fileLocation, String fileName, List<HashMap<String , String>> data,String sheetName) {
        String fullPath = fileLocation+"\\"+fileName;
        FileHelp.isExistAndCreate(fullPath);
        //??????sheet?
        try {
            //???sheet
            if(null==sheetName){
                sheetName = "sheet1";
            }
             sheet = wb.createSheet(sheetName);

            int line = 1;
            for(HashMap<String , String> map:data){
                if(line==1){    //????д???
                    Set<String> strings = map.keySet();
                    ArrayList<String> ls=new ArrayList(strings);
                    WriterExcelHelp.writeRow(ls);
                }else {
                    ArrayList<String> mapValues = WriterExcelHelp.getMapValues(map);
                    WriterExcelHelp.writeRow(mapValues);
                }
                line++;
            }




            wb.setForceFormulaRecalculation(true);
            FileOutputStream out = new FileOutputStream(new File(fullPath));
            wb.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public static void writeRow(ArrayList<String> lists) {
        XSSFRow row = sheet.createRow(rownum);
        for(String cellStr:lists){
            XSSFCell cell = row.createCell(cellnum);
            cell.setCellValue(cellStr);
            cellnum++;
        }
        cellnum=0;
        rownum++;
    }

    public static ArrayList<String> getMapValues(Map<String ,String> map) {
        ArrayList<String> list = new ArrayList<>();
        for(String key:map.keySet()){
            String s = map.get(key);
            list.add(s);
        }
        return list;
    }


    public static void main(String[] args) {
        //List<HashMap<String , String>> data
        List<HashMap<String , String>> list = new ArrayList<>();
        for(int i=0;i<100;i++){
            LinkedHashMap map = new LinkedHashMap();
            map.put("data1" , "1");
            map.put("data2" , "2");
            map.put("data3" , "3");
            map.put("data4" , "4");
            map.put("data5" , "5");
            map.put("data6" , "6");
            list.add(map);
        }

        WriterExcelHelp.generateExcelFile("D:\\tmp" , "111.xlsx",list,"到处数据测试");
    }

}
