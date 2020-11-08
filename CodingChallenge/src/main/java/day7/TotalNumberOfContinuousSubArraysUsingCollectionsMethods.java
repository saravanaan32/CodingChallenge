/*******************************************************************************************************************************
		int[] nums= {1,1,1};
		int k=2;
		sum of any two number in an array is equal to the k value - Using Collections List
*******************************************************************************************************************************/

package day7;

import java.util.ArrayList;
import java.util.List;

public class TotalNumberOfContinuousSubArraysUsingCollectionsMethods 
{
	public static List<Integer> convertToList(int nums[]) 
	{
		List<Integer> numsList = new ArrayList<Integer>();
		
		for (int i = 0; i < nums.length; i++) 
		{
			numsList.add(nums[i]);
		}
		return numsList;
	}
	public static void singleElementMatch(List<Integer> numsList, int k) 
	{
		for (int i = 0; i < numsList.size(); i++) 
		{
			if (numsList.get(i)==k) 
			{
				System.out.println("The indices are Matched with the Target Nuber "+k+":- [ " +i+" ] !!!");
			}
		}
	}
	public static void compareTheArrayElements(List<Integer> numsList, int k) 
	{
		for (int i = 0; i < numsList.size(); i++) 
		{
			for (int j = i+1; j < numsList.size(); j++) 
			{
				if (numsList.get(i)+numsList.get(j)==k) 
				{
					System.out.println("The indices are Matched with the Target Nuber "+k+":- [" +i+", "+j+"] !!!");
				}
			}
		}
	}
	public static void main(String[] args) 
	{
		int[] nums= {-1,2,3};
		int k=2;
		convertToList(nums);
		singleElementMatch(convertToList(nums), k);
		compareTheArrayElements(convertToList(nums), k);
		
	}

}