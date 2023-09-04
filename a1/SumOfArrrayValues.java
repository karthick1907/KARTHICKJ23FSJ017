package com.a1;

public class SumOfArrrayValues {
	int[] array = {10, 20, 30, 40, 50, 10};
	int sum = 0;
	//Advanced for loop
	for( int num : array) {
	sum = sum+num;
	}
	System.out.println("Sum of array elements is:"+sum);
	}
}
