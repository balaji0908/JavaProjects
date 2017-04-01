package com.practice;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfEncryptor;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfPasswordUnlock {
	public static void main (String[] args) throws java.io.IOException, DocumentException {
		/*Mention the path of the folder which has all the files that are to be unlocked in the format D:\\abc */
		File[] files = new File("D:\\abc").listFiles();

		for (File file : files) {
		    if (file.isFile()) {
		        	int index = file.getPath().lastIndexOf("\\");
		        	//Here mention the path of folder where you can find the unlocked files
		        	String outputFile = "D:\\Unlocked\\" + file.getPath().substring(index + 1);
		        	PdfReader reader = new PdfReader(file.getPath(), "xyz".getBytes());//xyz is the password of the file
		        	PdfReader.unethicalreading = true;
		        	
		        	System.out.println("Unlocking...");
		        	
		        	PdfEncryptor.encrypt(reader, new FileOutputStream(outputFile), null, null,
		        			PdfWriter.ALLOW_ASSEMBLY | PdfWriter.ALLOW_COPY | PdfWriter.ALLOW_DEGRADED_PRINTING
		        			| PdfWriter.ALLOW_FILL_IN | PdfWriter.ALLOW_MODIFY_ANNOTATIONS
		        			| PdfWriter.ALLOW_MODIFY_CONTENTS | PdfWriter.ALLOW_PRINTING
		        			| PdfWriter.ALLOW_SCREENREADERS,
		        			false);
		        	
		        	System.out.println("PDF Unlocked!");
		    }
		}
		
	}
}
	

