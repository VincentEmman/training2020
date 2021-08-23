package org.ssglobal.training.codes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MixTransaction {

	private static Logger logger = LogManager.getLogger("matrixLogger");
	
	public boolean fileExist(String s) {
		logger.info("Execute fileExist");
		if (s == null) {
			logger.info("Exit fileExist with error");
			return false;
	    } else {
			File file = new File("./src/file/"+s);
			logger.info("Exit fileExist without error");
			return file.exists();
			}
	}
	
	public boolean isInt(String s) {
		logger.info("Execute isInt");
		if(s == null) {
			logger.info("Exit isInt without error");
			return false;
		} 
		try {
			Integer.parseInt(s);
		} catch(NumberFormatException e) {
			logger.info("Exit isInt without error");
			return false;
		}
		logger.info("Exit isInt without error");
		return true;
	}
	
	public boolean isDouble(String s) {
		logger.info("Execute isDouble");
		if(s == null) {
			logger.info("Exit isDouble without error");
			return false;
		} 
		try {
			if(s.contains(".")) {
				Double.parseDouble(s);
			} else {
				logger.info("Exit isDouble without error");
				return false;
			}
			
		} catch(NumberFormatException e) {
			logger.info("Exit isDouble without error");
			return false;
		}
		logger.info("Exit isDouble without error");
		return true;
	}
	
	public void convertMatrix(String filename) 
			throws WrongMatrixDimensionException, WrongMatrixValuesException,
			FileNotFoundException, IOException, Exception{
		if(fileExist(filename)) {
			File file1 = new File("./src/file/"+filename);
			try(FileReader fr = new FileReader(file1);
					Scanner scan = new Scanner(fr);) {
				while(scan.hasNext()) {
					String s = scan.nextLine();
					String[] valStr = s.split(" ");
					if(valStr.length!=3) {
						logger.error(new WrongMatrixDimensionException().getMessage());	
						throw new WrongMatrixDimensionException();
								
					}
					for(String str : valStr) {
						boolean result = isInt(str);
						if(result==false) {
							logger.error(new WrongMatrixValuesException().getMessage());
							throw new WrongMatrixValuesException();
						}
					}
				}	
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("File does not exits");
		}
	
	}
}
