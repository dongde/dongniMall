package com.dongni.dongnimall.common;

import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

/**
 * @author cengshuai on 2019-09-10.
 * @version 1.0
 */
public class VerifyCode {
    public static BufferedImage getImage(HttpServletRequest request) {
        // 创建图片对象
        BufferedImage bufferedImage = new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB);

        // 创建画板
        Graphics2D graphics = bufferedImage.createGraphics();

        // 设置画板当前使用的颜色
        graphics.setColor(Color.GRAY);

        // 设置画板填充区域
        graphics.fillRect(0, 0, 100, 50);

        // 设置所有颜色
        Color[] colors = {Color.RED, Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GREEN,
                Color.LIGHT_GRAY, Color.ORANGE, Color.PINK, Color.WHITE, Color.YELLOW};

        // 设置字体
        graphics.setFont(new Font("宋体", Font.ITALIC | Font.BOLD, 20));
        String codes = "";
        // 设置将要绘制的文本内容
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            graphics.setColor(colors[random.nextInt(colors.length)]);
            String code = random.nextInt(10) + "";
            codes += code;
            graphics.drawString(code, i * 25, 35 + random.nextInt(11) - 5);
        }
        request.getSession().setAttribute("code", codes);
        // 在画板上画上线条
        for (int i = 0; i < 4; i++) {
            graphics.setColor(colors[random.nextInt(colors.length)]);
            graphics.drawLine(5, random.nextInt(50), 95, random.nextInt(50));
        }
//        BufferedImage img = removeBackgroud(file);//去除重影

        //bufferedimage 转换成 inputstream
//        ByteArrayOutputStream bs = new ByteArrayOutputStream();
//        ImageOutputStream imOut = null;
//        try {
//            imOut = ImageIO.createImageOutputStream(bs);
//            ImageIO.write(bufferedImage, "jpg", imOut);
//            InputStream inputStream = new ByteArrayInputStream(bs.toByteArray());
//            File file = new File(filePath);
//            if (file.getParentFile().isDirectory() || file.getParentFile() != null) {
//                file.getParentFile().mkdirs();
//            }
//            OutputStream outStream = new FileOutputStream(filePath);
//            IOUtils.copy(inputStream, outStream);
//            inputStream.close();
//            outStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return bufferedImage;
    }
}
