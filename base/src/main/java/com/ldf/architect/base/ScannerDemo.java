package com.ldf.architect.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author ldf
 * @date 2019/11/5 17:28
 **/
public class ScannerDemo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("E:\\资料-文档\\di.txt"));
        scanner.useDelimiter("([\n\t])");
        while (scanner.hasNext()){{
            String next = scanner.next();
            System.out.println(next);
            System.out.println("--------");
        }}
    }

}
