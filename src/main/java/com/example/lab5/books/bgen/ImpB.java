package com.example.lab5.books.bgen;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ImpB {

    private String[] arrEnEdNames;
    private String[] arrEnEdAuthors;
    private String[] arrEnEdUniversities;

    private String[] arrEnFicNames;
    private String[] arrEnFicAuthors;

    private String[] arrRuEdNames;

    private String[] arrRuFicNames;
    private String[] arrRuFicAuthors;


    public String[] getArrRuEdNames() {
        return arrRuEdNames;
    }

    public String[] getArrEnEdNames() {
        return arrEnEdNames;
    }

    public String[] getArrEnEdUniversities() {
        return arrEnEdUniversities;
    }
    public String[] getArrEnEdAuthors() {
        return arrEnEdAuthors;
    }

    public String[] getArrRuFicNames() {
        return arrRuFicNames;
    }

    public String[] getArrRuFicAuthors() {
        return arrRuFicAuthors;
    }

    public String[] getArrEnFicNames() {
        return arrEnFicNames;
    }

    public String[] getArrEnFicAuthors() {
        return arrEnFicAuthors;
    }


    public void setAll(File file) throws IOException, InvalidFormatException {
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        arrEnEdNames = read(workbook, 0);
        arrEnEdAuthors = read(workbook, 1);
        arrEnEdUniversities = read(workbook, 2);
        arrEnFicNames = read(workbook, 3);
        arrEnFicAuthors = read(workbook, 4);
        arrRuEdNames = read(workbook, 5);
        arrRuFicNames = read(workbook, 6);
        arrRuFicAuthors = read(workbook, 7);
        workbook.close();
    }

    public String[] read(XSSFWorkbook workbook, int num) {
        XSSFSheet sheet = workbook.getSheetAt(num);
        String[] arr = new String[sheet.getLastRowNum() + 1];
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            if (sheet.getRow(i).getCell(0) != null) {
                arr[i] = sheet.getRow(i).getCell(0).getStringCellValue();
            }
        }
        return arr;
    }

}
