package com.chainsys.practice;

import java.util.ArrayList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class practiceList {
	public static void main(String[] args) {
		ArrayList<String> arrayList =new ArrayList<>();
		ArrayList<String> newList = new ArrayList<>();
		arrayList.add("vishnu");
		arrayList.add( "kumar");
		arrayList.add( "vimal");
		System.out.println(arrayList);
		  newList =(ArrayList) arrayList.clone();
		 System.out.println(newList);
		 newList.remove("vimal");
		 System.out.println(newList);
		 System.out.println("class of newList : "+newList.getClass());
		 System.out.println();
		 Collections.sort(arrayList);
		 System.out.println(arrayList);
		 System.out.println("index of Element : "+arrayList.indexOf("kumar"));
		 
		 //linked list
		 
		 List<String> names = new LinkedList<>();
		 List<String> list = new LinkedList<>();
		names.addAll(arrayList);
		System.out.println(names);
		System.out.println(names.equals(arrayList));
		names.add("kumar");
		
		System.out.println(names.lastIndexOf("kumar"));
		
		 list = names.subList(0, 2);
		 System.out.println(list);
		
	}
	
}
