package com.collection.util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class SharePictureBiz {

	private static final Integer width = 1080;
    private static final Integer height = 2009;

    public byte[] retrievePicture(String filePath, String qrcodeHttpUrl) throws IOException {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);//创建图片

        //BufferedImage open = ImageIO.read(new URL(Constants.PROJECT_PATH + headimage));
        BufferedImage product = ImageIO.read(new URL(Constants.PROJECT_PATH+"/upload/qrcodes/invitecode.png"));//读取互联网图片

        Graphics2D g = img.createGraphics();
        
        g.drawImage(product.getScaledInstance(width, height, Image.SCALE_DEFAULT), 0, 0, null);
        //g.drawImage(scaleImage(ImageIO.read(new File( "D:/qrcode.png"))).getScaledInstance(520,530, Image.SCALE_DEFAULT),290, 660, null);
        
        FileInputStream fin = new FileInputStream(new File(qrcodeHttpUrl));
        byte[] qrCode  = new byte[fin.available()];
        //将文件内容写入字节数组，提供测试的case
        fin.read(qrCode);
        fin.close();
        if (qrCode.length > 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(qrCode);
            //变成圆的
            //BufferedImage qrcode = scaleImage(ImageIO.read(byteArrayInputStream));
            BufferedImage qrcode = ImageIO.read(byteArrayInputStream);
            if (qrcode != null)
                g.drawImage(qrcode.getScaledInstance(380,380, Image.SCALE_DEFAULT),350, 1480, null);
            else
                System.out.println("qrcode is null");
        } else {
        	System.out.println("获取qrcode字节组失败 Failed");
        }
        //g.drawImage(open.getScaledInstance(120, 120, Image.SCALE_DEFAULT), 490, 1600, null);

        g.dispose();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        if (filePath == null) {
            ImageIO.write(img, "jpg", outputStream);
        } else {
            ImageIO.write(img, "jpg", new File(filePath));
        }
        System.out.println("generate picture over");
        return outputStream.toByteArray();
    }
    
    static BufferedImage scaleImage(BufferedImage bi1) throws IOException {        
        // 根据需要是否使用 BufferedImage.TYPE_INT_ARGB
    	BufferedImage image = new BufferedImage(bi1.getWidth(), bi1.getHeight(),
                BufferedImage.TYPE_INT_ARGB);
  
        Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, bi1.getWidth(), bi1
                .getHeight());
        Graphics2D g2 = image.createGraphics();
        image = g2.getDeviceConfiguration().createCompatibleImage(bi1.getWidth(), bi1.getHeight(), Transparency.TRANSLUCENT);
        g2 = image.createGraphics();
        g2.setComposite(AlphaComposite.Clear);
        g2.fill(new Rectangle(image.getWidth(), image.getHeight()));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC, 1.0f));
        g2.setClip(shape);
        // 使用 setRenderingHint 设置抗锯齿
        g2.drawImage(bi1, 0, 0, null);
        g2.dispose();
        return image;
    }
    
    public static void main(String[] args) throws IOException {
		//SharePictureBiz share=new SharePictureBiz();
		//String urlstr="D:/upload/"+UUID.randomUUID().toString().replace("-", "")+".jpg";
		//share.retrievePicture(urlstr,  "D:/upload/qrcodes/1594826424_2e2b12423a9a4bd3ac37de7423d015b4.jpg");
    }
}
