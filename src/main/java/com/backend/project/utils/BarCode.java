package com.backend.project.utils;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

public class BarCode {
	
	public static BufferedImage generateCode128BarCodeImage(final String barcodeText) throws Exception {
        final Barcode barcode = BarcodeFactory.createCode128(barcodeText);
        barcode.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        BufferedImage image = BarcodeImageHandler.getImage(barcode);
     
        return BarcodeImageHandler.getImage(barcode);
    }

}
