package com.ldf.architect.base.io;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class NioLearn extends AbstractIoLearn{


    @Override
    protected void createFileAndWrite(String content, String filePath) throws IOException {
        try(FileOutputStream outputStream = new FileOutputStream(filePath);
            //获取管道FileChannel
            FileChannel fileChannel = outputStream.getChannel();
        ){
            //数据写入缓冲区ByteBuffer
            ByteBuffer byteBuffer = ByteBuffer.wrap(content.getBytes(StandardCharsets.UTF_8));
            //缓冲区数据写入管道
            fileChannel.write(byteBuffer);
        }
    }

    @Override
    protected void copy(String srcPath, String desPath) throws IOException {
        try(FileInputStream inputStream = new FileInputStream(srcPath);
            FileOutputStream outputStream = new FileOutputStream(desPath);
            //分别获取输入输出对应的管道
            FileChannel inChannel = inputStream.getChannel();
            FileChannel outChanel = outputStream.getChannel();
        ){
            System.out.println("输入数据字节长度："+inputStream.available());
            //分配一个缓冲区存用来储输入的数据
            ByteBuffer byteBuffer = ByteBuffer.allocate(5);
            int i=0;
            //把输入流管道的数据填充到输出流管道
            while (inChannel.read(byteBuffer)>0){
                i++;
                System.out.println("第"+i+"次遍历开始---------------------------");
                System.out.println("read后-------------");
                print(byteBuffer);
                //准备缓冲器数据以便写入管道
                byteBuffer.flip();
                System.out.println("flip后-------------");
                print(byteBuffer);
                //缓冲
                outChanel.write(byteBuffer);
                System.out.println("write后------------");
                print(byteBuffer);
                //为下一次read()准备
                byteBuffer.clear();
                System.out.println("clear后------------");
                print(byteBuffer);
                System.out.println("第"+i+"次遍历结束---------------------------");
            }
            //实际上，NIO提供了管道之间直接相连的方式，上序循环可以直接以下边一行代码代替
//            inChannel.transferFrom(outChanel,0, inChannel.size());

        }
    }



    private void print(ByteBuffer buffer){
        System.out.println("capacity:" + buffer.capacity()
                + ", position:" + buffer.position()
                + ", limit:" + buffer.limit());
    }

}
