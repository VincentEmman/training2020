package org.ssglobal.training.codes;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TrapArray {
	
	private static Logger logger = LogManager.getLogger("trapLogger");
	private Scanner scan = new Scanner(System.in);
	private int[] arr = new int[0];
	
	public void arrayTransact() {
		String size = "";
		logger.info("Execute array transact");
		while(true) {
			
			logger.info("Execute validateArraySize");
			while(true) {
				try {
					System.out.print("Enter array size: ");
					 size = scan.next();
					if(size.equalsIgnoreCase("E")) {
						logger.info("Exit validateArraySize without error");
						logger.info("Exit arrayTransact without error");
						break;
					} 
					arr = validateArraySize(size);
					if(arr!=null) {
						logger.info("Exit validateArraySize without error");
						break;
					};
				} catch (NegativeArraySizeException e) {
					logger.error(e.getMessage());
				} catch (InvalidSizeException e) {
					logger.error(e.getMessage());
				} catch (LetterSizeException e) {
					logger.error(e.getMessage());
				} 
			}
			
			if(size.equalsIgnoreCase("E"))  break;
			

			int counter = 0;
			int value = 0;
			String strInt = "";
			logger.info("Execute validateValue");
			while(true) {
				try {
					System.out.print("Enter the value: ");
					strInt = scan.next();
					if(strInt.equalsIgnoreCase("E"))  {
						logger.info("Exit validateValue without error");
						logger.info("Exit arrayTransact without error");
						break;
					} 
					value = validateValue(strInt);
					arr[counter] = value;
					if(counter==arr.length-1) {
						logger.info("Exit validateValue without error");
						break;
					};
					counter++;
				} catch (ElementCharException e) {
					logger.error(e.getMessage());
				} catch (ElementDecimalException e) {
					logger.error(e.getMessage());
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
			}
			
			if(strInt.equalsIgnoreCase("E")) {
				logger.info("Exit arrayTransact without error");
				break;
			} 
			
			String indexStr = "";
			int[] keyValPair = new int[2];
			logger.info("Execute getValue");
			while(true) {
				try {
					System.out.print("Enter the Index that you want to view: ");
					indexStr = scan.next();
					if(indexStr.equalsIgnoreCase("E"))  {
						logger.info("Exit getValue without error");
						logger.info("Exit arrayTransact without error");
						break;
					} 
					keyValPair = getValue(indexStr);
					System.out.printf("The value in index %d is %d\n", keyValPair[0],
							keyValPair[1]);
				} catch (ArrayIndexOutOfBoundsException e) {		
					logger.error(e.getMessage());
				} catch (BadIndexException e) {
					logger.error(e.getMessage());
				}
				
			}
			if(indexStr.equalsIgnoreCase("E")) break;
			 

		}
	}
	
	public int[] validateArraySize(String size) 
			throws NegativeArraySizeException, 
			InvalidSizeException, LetterSizeException{
		int[] arr = new int[0];
		int sizeInt = 0;
		try {			
			// problem with alphanumeric 
			if(size.matches("\\D+")) {
				if(size.matches("\\w")) {
					throw new LetterSizeException();
				} else {
					throw new InvalidSizeException();
				}
			} else {
				if(size.contains(".")) {
					throw new InvalidSizeException();
				} else {
					sizeInt = Integer.parseInt(size);
					arr = new int[sizeInt];
					return arr;
				}
			} 
		} catch (NegativeArraySizeException e) {
			throw new NegativeArraySizeException("Array size cannot be negative");
		}
	}
	
	public int validateValue(String strInt) 
			throws ElementCharException, ElementDecimalException, Exception{
		int valueInt = 0;
		// problem with alphanumeric 
		if(strInt.matches("\\D*")) {
			if(strInt.length()>1) {
				throw new ElementCharException("invalid element value:[String]");
			} else {
				throw new ElementCharException();
			} 
		} else {
			if(strInt.contains(".")) {
				throw new ElementDecimalException();
			} else {
				valueInt = Integer.parseInt(strInt);
				return valueInt;
			}
		} 
	}
	
	public int[] getValue(String indexStr) throws BadIndexException, ArrayIndexOutOfBoundsException{
		int[] keyValPair = new int[2];
		if(indexStr.matches("\\D*")) {
			throw new BadIndexException();
		}
		try {
			keyValPair[0] = Integer.parseInt(indexStr);
			keyValPair[1] = arr[keyValPair[0]];
			return keyValPair;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("bad index");
		}
	}
	
}
