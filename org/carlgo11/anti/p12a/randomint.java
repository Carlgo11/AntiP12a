package org.carlgo11.anti.p12a;

import java.util.Random;

import org.bukkit.event.Listener;


public class randomint implements Listener{
	
	
	public static int number;
	public static void onInt(){
		Random n = new Random();
		int num;
		for(int count=1; count<=2;count++){
			num = 1+n.nextInt(20);
			number = num;
			System.out.println("num: " + num);
			System.out.println("number: " + number);
		}
	}
	
	
	
}
