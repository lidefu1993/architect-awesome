package com.ldf.architect.base.io;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

/**
 * IO抽象类
 */
public abstract class AbstractIoLearn {

    static String CURRENT_PATH = System.getProperty(("user.dir"))+"/0-attach-file/iotest/";

    static final String OLD_IO_SRC_PATH = CURRENT_PATH + "AIO_SRC.txt";
    static final String NID_IO_SRC_PATH = CURRENT_PATH + "NIO_SRC.txt";

    static final String OLD_IO_DES_PATH = CURRENT_PATH + "AIO_DES.txt";
    static final String NID_IO_DES_PATH = CURRENT_PATH + "NIO_DES.txt";

    public static void main(String[] args) throws IOException {

//        mmfRead(NID_IO_SRC_PATH);
        mmfWrite(NID_IO_DES_PATH, "123,456");

//        oldIOTest();
//        niOTest();
    }

    private static void oldIOTest() throws IOException {
        OldIoLearn ioLearn = new OldIoLearn();
        //创建新文件并写入
        ioLearn.createFileAndWrite("old io 测试!!", OLD_IO_SRC_PATH);
        //拷贝文件
        ioLearn.copy(OLD_IO_SRC_PATH, OLD_IO_DES_PATH);
    }

    private static void niOTest() throws IOException {
        NioLearn nioLearn = new NioLearn();
        //创建新文件并写入
        nioLearn.createFileAndWrite("nio 测试!!", NID_IO_SRC_PATH);
        //拷贝文件
        nioLearn.copy(NID_IO_SRC_PATH, NID_IO_DES_PATH);
    }

    /**
     * 内存映射文件读
     * @param path 文件路径
     */
    private static void mmfRead(String path) throws IOException {
        //每次读取长度为7个字节
        int size = 7;
        try(FileInputStream inputStream = new FileInputStream(path);
            FileChannel fileChannel = inputStream.getChannel();
            ) {
            //输入流字节长度：12
            int fileLength = inputStream.available();
            int position = 0;
            //每次读取7个字节，共12个字节，需要循环两次
            while (position<fileLength){
                System.out.println("--------开始-------");
                MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, position, Math.min(fileLength - position, size));
                CharBuffer charBuffer = StandardCharsets.UTF_8.decode(mappedByteBuffer);
                position+=size;
                System.out.println(charBuffer.toString());
                System.out.println("--------结束-------");

            }
        }
    }

    /**
     * 内存映射文件写
     * @param descPath 待写入文件路径
     * @param data 待写入的数据
     */
    private static void mmfWrite(String descPath, String data) throws IOException {
        try(//需要注意的是此处需要使用RandomAccessFile来构建一个可读可写的Channel
            RandomAccessFile randomAccessFile = new RandomAccessFile(descPath, "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
        ) {
            byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, bytes.length);
            mappedByteBuffer.put(bytes);
        }
    }


    protected abstract void createFileAndWrite(String content, String filePath) throws IOException;

    protected abstract void copy(String srcPath, String desPath) throws IOException;

}
