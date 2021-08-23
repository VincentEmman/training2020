package org.ssglobal.training.codes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCandy {

	private QueueCandies candy;
	
	@BeforeEach
	public void setup() {
		candy = new QueueCandies();
	}
	
	@Test
	public void testGetCandy() {
		Queue dispenser = new Queue();
		List<String> candies = Arrays.asList("Blue RaspBerry", "Chocolate", 
				"Cola", "Grape", "Green Apple", "Lemon", "Orange", "Peppermint",
				"Raspberry", "Watermelon");
		Iterator<String> iterate = candies.iterator();
		while(iterate.hasNext()) {
			dispenser.addCandy(iterate.next());
		}
		candy.getCandy(dispenser, 3);

	}
	
	
	@AfterEach
	public void teardown() {
		candy=null;
	}
	
}
