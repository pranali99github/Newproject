package hellodemo;

import java.util.ArrayList;
import java.util.HashSet;

public class arraylsitdemo {

	public static void main(String[] args) {
		
		ArrayList al=new ArrayList();
		
         al.add(1);
         al.add(2);
         al.add(4);
         al.add(2);
         HashSet  h=new HashSet(al);
         System.out.println(h);
         
	}

}
