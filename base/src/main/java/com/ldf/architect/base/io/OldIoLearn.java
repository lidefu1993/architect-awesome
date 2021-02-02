package com.ldf.architect.base.io;


import java.io.*;
import java.nio.charset.StandardCharsets;

public class OldIoLearn extends AbstractIoLearn {


    @Override
    protected void createFileAndWrite(String content, String filePath) throws IOException {
        try(FileOutputStream outputStream = new FileOutputStream(filePath);) {
            //字节数据写入输出流
            outputStream.write(content.getBytes(StandardCharsets.UTF_8));
            //将缓冲区数据刷到文件
            outputStream.flush();
        }
    }

    @Override
    protected void copy(String srcPath, String desPath) throws IOException {
        try (
                FileInputStream inputStream = new FileInputStream(srcPath);
                FileOutputStream outputStream = new FileOutputStream(desPath);
        ){
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1){
                outputStream.write(bytes,0, len);
            }
            //将缓冲区数据刷到文件
            outputStream.flush();
        }
    }

}
