package com.shopping.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

/**
 * @author chenZhangLin(陈章林小组组长)
 * 
 */
public class ImageUtil {
	
	private String base64;
	
	private String contentType;
	
	private String suffix;
	
	public ImageUtil(String base64) {
		this.base64 = base64;
		getImageInfo();
	}
	
	public static String getImageBase64(String imagePath) throws IOException {
		FileInputStream in = new FileInputStream(imagePath);
		byte[] b = new byte[in.available()];
		in.read(b);
		Encoder encoder = Base64.getEncoder();
		in.close();
	    return encoder.encodeToString(b);
	}
	
	public byte[] getImage() {
		Decoder decoder = Base64.getDecoder();
		String newBase64 = base64;
		if(base64.indexOf(",") != -1) {
			newBase64 = base64.substring(base64.indexOf(",")+1);
		}
		byte[] b = decoder.decode(newBase64);
		return b;
	}
	
	public void writeImage(byte[] source, String targetPath) {
		try {
			FileOutputStream out = new FileOutputStream(targetPath);
			out.write(source);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeImage(String targetPath) {
		byte[] source = getImage();
		writeImage(source, targetPath);
	}
	
	private void getImageInfo() {
		String imageInfo = null;
		int index = -1;
		if((index = base64.indexOf(",")) != -1) {
			imageInfo = base64.substring(0, index);
		}
		if(imageInfo != null) {
			String[] strArray = imageInfo.split(";");
			contentType = strArray[0];
			suffix = strArray[0].substring(strArray[0].indexOf("/") + 1);
		}
	}

	public String getBase64() {
		return base64;
	}

	public String getContentType() {
		return contentType;
	}

	public String getSuffix() {
		return suffix;
	}
	
	
}
