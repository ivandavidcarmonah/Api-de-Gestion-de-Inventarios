package com.backend.project.utils;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.imageio.ImageIO;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

public class BarCode {
	
	public static void generateCode128BarCodeImage(final String barcodeText) throws Exception {
        final Barcode barcode = BarcodeFactory.createCode128(barcodeText);
        barcode.setBarHeight(150);
        barcode.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        saveFileBarCode(barcodeText, BarcodeImageHandler.getImage(barcode));
    }
	
	public static void saveFileBarCode(String fileName, BufferedImage bufferedImage) throws Exception {
		String uploadDir = AppConstants.PRODUCT_IMAGE__BARCODE;
		File outputfile = new File(fileName);
	    ImageIO.write(bufferedImage, "png", outputfile);
	    Path uploadPath = Paths.get(uploadDir);
	    if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
	    InputStream targetStream = new FileInputStream(outputfile);
	    try (InputStream inputStream = targetStream) {
            Path filePath = uploadPath.resolve(fileName+".png");
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {        
            throw new IOException("Could not save image file: " + fileName, ioe);
        }    
    }

}
