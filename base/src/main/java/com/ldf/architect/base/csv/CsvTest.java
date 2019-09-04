package com.ldf.architect.base.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author lidefu
 * @date 2019/8/29 10:57
 */
public class CsvTest {

    public static void main(String[] args) throws IOException {
        String text = "UNBOUNDED, UNION, UNIQUE, UNQUOTED, UPDATE, UPPER, USER, USERS, USING, VALUES, VARCHAR, VARCHAR_T, VARCHAR2, VARYING, VI, VIEW, WHEN, WHERE, WITH, WITHIN, XPACKAGE, YEAR";
        generateCsv(text);
    }

    private static void generateCsv(String text) throws IOException {
        File file = new File("D:\\test\\c1.csv");
        String[] split = text.split(",");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write("keyword"); writer.newLine();
        for (String s : split){
            writer.write(s.trim().toUpperCase());
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }

}
