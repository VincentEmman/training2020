package org.ssglobal.training.codes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTrapArray {


	private TrapArray array;
	
	@BeforeEach
	public void setup() {
		array = new TrapArray();
	}
	
	@Test
	public void testArrayTransact() {
		array.arrayTransact();
	}
	
	
	@AfterEach
	public void teardown() {
		array=null;
	}
}
