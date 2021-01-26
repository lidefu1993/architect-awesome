package com.ldf.architect.helper.image;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;

/**
 * @author lidefu
 * @date 2021年01月25日11:36
 **/
public class ImageWatermark {

    static String CURRENT_PATH = System.getProperty(("user.dir"));

    static String FONT_PATH = CURRENT_PATH + "\\0-attach-file\\simhei.ttf";

    public static void main(String[] args) {
        System.out.println("李德富\r\n37106\r\n保密材料，不得外传");
        System.out.println(CURRENT_PATH);
        // 原图片地址
        String imageUrl = CURRENT_PATH + "\\0-attach-file\\test.png";
        // 输出到文件
        String outputFile = CURRENT_PATH + "\\0-attach-file\\test_watermark.png";
        // 不透明度
        float opacity = 0.25f;

        try {
            // 获取原图文件
            File file = new File(imageUrl);
            // ImageIO读取图片
            BufferedImage image = ImageIO.read(file);

//            BufferedImage waterMark = textWaterMark("lidefu");
            BufferedImage waterMark = textWaterMark("李德富\r\n37106\r\n保密材料，不得外传", image.getWidth(), image.getHeight(), 150, 0.45);
            Thumbnails.of(image)
                    // 设置图片大小
                    .size(image.getWidth(), image.getHeight())
                    // 加水印 参数：1.水印位置 2.水印图片 3.不透明度0.0-1.0
                    .watermark(Positions.TOP_LEFT, waterMark, 0.2f)
                    // 输出到文件
                    .toFile(outputFile);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage textWaterMark(String text){
        BufferedImage image = new BufferedImage(800, 320, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        image = g.getDeviceConfiguration().createCompatibleImage(800, 320, Transparency.TRANSLUCENT);
        int x = 30;
        int y = 30;
        g = image.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.BLACK);
        //水印旋转
        g.rotate(0.45);
        g.drawString(text, x, y);
        g.dispose();
        return image;
    }

    private static BufferedImage textWaterMark(String text, int weight, int height, int offset, double rotate){


        try {
            BufferedImage image = new BufferedImage(weight, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            image = g.getDeviceConfiguration().createCompatibleImage(weight, height, Transparency.TRANSLUCENT);
            g = image.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(Color.BLACK);
            //水印旋转
            g.rotate(-0.45);
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(FONT_PATH));
            font = font.deriveFont(12.0f);
            System.out.println("字体大小：" + font.getSize());
            g.setFont(font);
//            g.drawString("李德富", 30, 80);
//            g.drawString("37106", 30, 93);
//            g.drawString("保密材料，不得外传", 30, 106);
//
//            g.drawString("李德富", 180, 140);
//            g.drawString("37106", 180, 153);
//            g.drawString("保密材料，不得外传", 180, 166);
            int x = 30, y=80;
            while (x<weight && y<height){
                g.drawString("李德富", x, y);
                g.drawString("37106", x, y+13);
                g.drawString("保密材料，不得外传", x, y+23);
                x+=150; y+=60;
            }
            g.drawString("李德富", 30, 180);
            g.drawString("37106", 30, 194);
            g.drawString("保密材料，不得外传", 30, 208);
            x+=150; y+=60;
            g.dispose();
            return image;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
