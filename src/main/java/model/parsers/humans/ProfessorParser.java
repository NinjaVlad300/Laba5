package model.parsers.humans;

import model.parsers.Parser;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;

public class ProfessorParser{

    private static ArrayList<String> firstNames;
    private static ArrayList<String> lastNames;
    private static final int columnsNumber = 2;

    public static ArrayList<String> getFirstNames() {
        return firstNames;
    }

    public static void setFirstNames(ArrayList<String> firstNamesNew) {
        firstNames = firstNamesNew;
    }

    public static ArrayList<String> getLastNames() {
        return lastNames;
    }

    public static void setLastNames(ArrayList<String> lastNamesNew) {
        lastNames = lastNamesNew;
    }

    public static void parseSheet(XSSFSheet sheet){
        for(int j=0; j<columnsNumber; j++){
            int rowsNumber = Parser.getRowsNumberAtColumn(sheet, j);
            ArrayList<String> list = new ArrayList<>();
            for(int i=0; i<rowsNumber; i++){
                String value = sheet.getRow(i+1).getCell(j).getStringCellValue();
                list.add(value);
            }
            if(j==0) setFirstNames(list);
            else setLastNames(list);
        }
    }

}
