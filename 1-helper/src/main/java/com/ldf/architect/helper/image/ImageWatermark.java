package com.ldf.architect.helper.image;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author lidefu
 * @date 2021年01月25日11:36
 **/
public class ImageWatermark {

    static String CURRENT_PATH = System.getProperty(("user.dir"));

    public static void main(String[] args) {
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
            BufferedImage waterMark = textWaterMark("lidefu");
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

        g.drawString(text, x, y);
        g.dispose();
        return image;
    }


}
