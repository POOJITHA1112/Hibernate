package com.clientTest;

public class Array {
	
	public static void main(String[] args) {
		
		
		int [] j= {1,2,3,4,5,-1,-2,-3,-4,-5};
		int k = 0;
		
		
		for( int i=0;i<=j.length-1;i++) {
			if(j[i]>0) {
				j[i]=j[k];
//				System.out.println(j[i]);
				System.out.println(j[k]);
			}
		}
		
	}

}
