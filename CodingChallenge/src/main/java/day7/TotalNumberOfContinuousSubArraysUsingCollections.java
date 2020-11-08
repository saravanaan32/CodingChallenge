/*******************************************************************************************************************************
		int[] nums= {1,1,1};
		int k=2;
		sum of any two number in an array is equal to the k value - Using Collections List
*******************************************************************************************************************************/

package day7;

import java.util.ArrayList;
import java.util.List;

public class TotalNumberOfContinuousSubArraysUsingCollections 
{
	public static void main(String[] args) 
	{
		int[] nums= { 1,1,1,2,2,2,1 };
		int k=2;
		List<Integer> numsList = new ArrayList<Integer>();
		
		for (int i = 0; i < nums.length; i++) 
		{
			numsList.add(nums[i]);
			if (numsList.get(i)==k) 
			{
				System.out.println("The indices are Matched with the Target Nuber "+k+":- [ " +i+" ] !!!");
			}
		}
		for (int i = 0; i < numsList.size(); i++) 
		{
			for (int j = i+1; j < numsList.size(); j++) 
			{
				if (numsList.get(i)+numsList.get(j)==k) 
				{
					System.out.println("The indices are Matched with the Target Nuber "+k+":- [" +i+", "+j+"] !!!");
					break;
				}
				
			}
		}

	}

}