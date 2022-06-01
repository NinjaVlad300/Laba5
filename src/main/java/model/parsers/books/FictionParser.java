package model.parsers.books;

import model.parsers.Parser;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;

public class FictionParser{

    private static ArrayList<String> authors;
    private static ArrayList<String> titles;
    private static final int columnsNumber = 2;

    public static ArrayList<String> getAuthors() {
        return authors;
    }

    public static void setAuthors(ArrayList<String> authorsNew) {
        authors = authorsNew;
    }

    public static ArrayList<String> getTitles() {
        return titles;
    }

    public static void setTitles(ArrayList<String> titlesNew) {
        titles = titlesNew;
    }

    public static void parseSheet(XSSFSheet sheet){
        for(int j=0; j<columnsNumber; j++){
            int rowsNumber = Parser.getRowsNumberAtColumn(sheet, j);
            ArrayList<String> list = new ArrayList<>();
            for(int i=0; i<rowsNumber; i++){
                String value = sheet.getRow(i+1).getCell(j).getStringCellValue();
                list.add(value);
            }
            if(j==0) setAuthors(list);
            else setTitles(list);
        }
    }

}
