package org.ssglobal.training.codes;

import java.util.Deque;
import java.util.LinkedList;

public class Queue {
	
	private Deque<String> dispenser = new LinkedList<>();
	
	public Deque<String> getDispenser(){
		return dispenser;
	}
	
	public void addCandy(String candy) {
		dispenser.add(candy);
	}

}
