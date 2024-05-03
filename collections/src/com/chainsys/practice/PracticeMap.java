package com.chainsys.practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class PracticeMap {
	public static void main(String[]args) {
		LinkedHashMap<String,String> data= new LinkedHashMap<>();
		data.put( "vishnu","dfg");
		/*
		 * // data.put( "vishu",); // data.put("mohammed"); // data.put( "kaif"); //
		 * data.put( "jdjd");
		 */		
		System.out.println(data);
		
//		System.out.println(data.containsKey(1001));
//		System.out.println(data.entrySet());
//		System.out.println(data.keySet());
		
		//data.putIfAbsent(1006, "kishore");
		//System.out.println(data.keySet());
		
		 Stack<Integer> stack = new Stack<Integer>();
		 stack.add(10);
		 stack.add(20);
		 stack.add(30);
		 stack.add(4);
		 System.out.println(stack);
		 System.out.println(stack.peek());
		 System.out.println(stack.search(30));
		 
		 Deque<String> deque = new ArrayDeque<>();
		 deque.add("kamaraj");
		 deque.add("kannan");
		 deque.add("bingo");
		 System.out.println(deque);
		 deque.addFirst("vicky");
		 deque.addLast("kumar");
		 System.out.println(deque);
		 deque.push("mani");
		 System.out.println(deque);
		 System.out.println(deque.peekLast());
		 System.out.println(deque.poll());
		 
		 System.out.println("Tree Set ");
		 Set<Integer> tree = new TreeSet<>(); 
		 tree.add(90);
		 tree.add(9);
		 tree.add(97);
		 tree.add(76);
		 tree.add(86);
		 System.out.println(tree);
		 System.out.println();
		 
		 System.out.println("Tree map");
		 Map<Integer,String> worker = new TreeMap<>();
		 worker.put(100, "mani");
		 worker.put(102, "kishor");
		 worker.put(101, "ajith");
		 worker.put(103, "vimal");
		System.out.println(worker);
		worker.replace(100, "mani", "vijay");
		System.out.println(worker);
		
		
		}

}
