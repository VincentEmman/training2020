package org.ssglobal.training.codes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMixTransaction {

	private MixTransaction mix;
	
	@BeforeEach
	public void setup() {
		mix = new MixTransaction();
	}
	
	@Test
	public void testArrayTransact() {
		try {
			mix.convertMatrix("matrix.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (WrongMatrixDimensionException e) {
			e.printStackTrace();
		} catch (WrongMatrixValuesException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@AfterEach
	public void teardown() {
		mix=null;
	}
}
