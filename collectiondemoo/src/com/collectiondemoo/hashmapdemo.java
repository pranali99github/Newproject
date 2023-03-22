package com.collectiondemoo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class hashmapdemo {

	public static void main(String[] args) {
		
		HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
		
         hash.put(1, 111);
         hash.put(2, 222);
        Set<Integer> s =hash.keySet();
        Iterator<Integer> itr=s.iterator();
        while(itr.hasNext()) {
        	int v=itr.next();
        	System.out.println("key>"+v);
        	System.out.println("values>"+hash.get(v));
        }
	
		
	}

}
