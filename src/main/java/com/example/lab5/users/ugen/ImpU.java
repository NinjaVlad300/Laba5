package com.example.lab5.users.ugen;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ImpU {

    private String[] arrNames;
    private String[] arrMiddlenames;
    private String[] arrSurnames;
    private String[] arrProfSurnames;
    private String[] arrWNames;

    public String[] getArrProfSurnames() {
        return arrProfSurnames;
    }

    public String[] getArrNames() {
        return arrNames;
    }

    public String[] getArrWNames() {
        return arrWNames;
    }

    public String[] getArrSurnames() {
        return arrSurnames;
    }

    public String[] getArrMiddlenames() {
        return arrMiddlenames;
    }

    public void setAll(File file) throws IOException, InvalidFormatException {
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        arrNames = read(workbook, 0);
        arrWNames = read(workbook, 1);
        arrSurnames = read(workbook, 2);
        arrProfSurnames = read(workbook, 3);
        arrMiddlenames = setMiddlenames();
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

    public String[] setMiddlenames() {
        String[] arrMiddlenames = new String[arrNames.length];
        int i = 0;
        for (String name : arrNames) {
            if (name.endsWith("ья")) {
                arrMiddlenames[i] = name.substring(0, name.length() - 1) + "ич";
            }else if (name.endsWith("ж") || name.endsWith("ш") || name.endsWith("ч") || name.endsWith("щ") || name.endsWith("ц") || name.endsWith("и") || name.endsWith("э") || name.endsWith("я") || name.endsWith("ю") || name.endsWith("е") || name.endsWith("ё")) {
                arrMiddlenames[i] = name + "евич";
            } else if (name.endsWith("н") || name.endsWith("р")|| name.endsWith("м")|| name.endsWith("л")|| name.endsWith("с")|| name.endsWith("б")) {
                arrMiddlenames[i] = name + "ович";
            }else if (name.endsWith("а") || name.endsWith("у") || name.endsWith("ы")) {
                arrMiddlenames[i] = name.substring(0, name.length() - 1) + "ович";
            } else if (name.endsWith("о")) {
                arrMiddlenames[i] = name.substring(0, name.length() - 1) + "вич";
            } else if (name.endsWith("ь")) {
                arrMiddlenames[i] = name.substring(0, name.length() - 1) + "евич";
            } else if (name.endsWith("й")) {
                arrMiddlenames[i] = name.substring(0, name.length() - 1) + "евич";
            } else {
                arrMiddlenames[i] = name + "евич";
            }
            i++;
        }
        return arrMiddlenames;
    }

}
