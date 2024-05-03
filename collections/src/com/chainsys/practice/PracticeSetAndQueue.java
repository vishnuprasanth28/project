package com.chainsys.practice;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class PracticeSetAndQueue {
	public static void main(String[] args) {
		 Set<String> data = new LinkedHashSet<String>();   
		 Set<String> data1 = new LinkedHashSet<String>();   
	        data.add("let");   
	        data.add("it");   
	        data.add("go");   
	        data.add("go");   //duplicates are not allowed
	    
	        System.out.println(data);  
	        data1.add("make");
	        data1.add("your");
	        data1.add("way");
	        data.addAll(data1);
	        System.out.println(data);
	        System.out.println(data.containsAll(data1));
	        
	        Queue<String> fruits = new LinkedList<>();
	        fruits.add("apple");
	        fruits.add("orange");
	        fruits.add("mango");
	        System.out.println(fruits.poll());
	        fruits.peek();
	        System.out.println(fruits);
	        
	        System.out.println(fruits);
	       Iterator value =fruits.iterator();
	       while(value.hasNext()){
	    	  System.out.println(value.next()); 
	       }
	       Queue<String> animals =new PriorityQueue<>();
	       animals.add("Lion");
	       animals.add("tiger");
	       animals.add("elephant");
	       System.out.println(animals);
	       System.out.println(animals.size());
	       animals.poll();
	       System.out.println(animals);
	       animals.clear();
	       System.out.println("is animals queues empty : "+animals.isEmpty());
	}
	


}
