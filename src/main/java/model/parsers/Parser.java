package model.parsers;

import model.parsers.books.EnglishLiteratureParser;
import model.parsers.books.FictionParser;
import model.parsers.books.RussianLiteratureParser;
import model.parsers.humans.ProfessorParser;
import model.parsers.humans.StudentParser;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.Iterator;

public class Parser{

    private final String pathToFile;

    public String getPathToFile() {
        return pathToFile;
    }

    public Parser(String pathToFile){
        this.pathToFile = pathToFile;
    }

    //

    public void parse(){
        try{
            parseStudent();
            parseProfessor();
            parseFiction();
            parseRussianLiterature();
            parseEnglishLiterature();
        } catch(IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void parseStudent() throws IOException{
        StudentParser.parseSheet(getSheetByName(getWorkbook(), "student"));
    }

    public void parseProfessor() throws IOException{
        ProfessorParser.parseSheet(getSheetByName(getWorkbook(), "professor"));
    }

    public void parseFiction() throws IOException{
        FictionParser.parseSheet(getSheetByName(getWorkbook(), "fiction"));
    }

    public void parseRussianLiterature() throws IOException{
        RussianLiteratureParser.parseSheet(getSheetByName(getWorkbook(), "russianLiterature"));
    }

    public void parseEnglishLiterature() throws IOException{
        EnglishLiteratureParser.parseSheet(getSheetByName(getWorkbook(), "englishLiterature"));
    }

    //

    public XSSFWorkbook getWorkbook()  throws IOException{
        XSSFWorkbook workbook = new XSSFWorkbook(getPathToFile());
        workbook.close();
        return workbook;
    }

    public XSSFSheet getSheetByName(XSSFWorkbook workbook, String sheetName){
        return workbook.getSheet(sheetName);
    }

    public static int getRowsNumberAtColumn(XSSFSheet sheet, int columnId){
        int rowsAtColumnNumber = 0;
        Iterator<?> rows = sheet.rowIterator();
        rows.next(); // first row is for header
        while(rows.hasNext()){
            XSSFRow row = (XSSFRow) rows.next();
            if(row.getCell(columnId) == null) break;
            rowsAtColumnNumber++;
        }
        return rowsAtColumnNumber;
    }

    public static int getColumnsNumber(XSSFSheet sheet) {
        int columnsNumber = 0;
        Iterator<?> rows = sheet.rowIterator();
        XSSFRow row = (XSSFRow) rows.next();
        Iterator<?> cells = row.cellIterator();
        while (cells.hasNext()) {
            columnsNumber++;
            cells.next();
        }
        return columnsNumber;
    }

}
