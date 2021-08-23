package org.ssglobal.training.codes;

import java.util.Deque;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QueueCandies {

	private static Logger logger = LogManager.getLogger("collectionLogger");
	
	
	public void getCandy(Queue dispenser, int day) {
		logger.info("Execute getCandy method day={}",day);
		Deque<String> dis = dispenser.getDispenser();
		Iterator<String> iterate = dis.iterator();
		logger.info("Validation: day should be [0,7)");
		if(day>=0 && day <7) {
			logger.info("Enter While Loop: iterator has next element");
			while(iterate.hasNext()) {
				System.out.printf("Pipi eats %s \n",dis.element());
				dis.remove();
				if(dis.isEmpty()==true) {
					logger.info("Exit While Loop: while iterator has no next element");
					logger.info("Exit getCandy method without error");
					break;
				}
				logger.info("Enter For Loop: rearranging candies");
				for(int j = 0; j < day; j++) {
					String candy = dis.peekFirst();
					dis.removeFirst();	
					dis.addLast(candy);
				}
				logger.info("Exit For Loop: printing the arranged candies");
				System.out.println(dis);
			}
		} else {
			logger.info("Exit getCandy method with error");
			System.out.println("Invalid day");
		}
	}
}
