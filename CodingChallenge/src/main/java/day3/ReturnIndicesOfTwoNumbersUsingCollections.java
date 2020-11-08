/*******************************************************************************************************************************
		int[] nums= {2,7,11,15};
		int target=17;
		sum of any two number in an array is equal to the target value - Using Collections List
*******************************************************************************************************************************/

package day3;

import java.util.ArrayList;
import java.util.List;

public class ReturnIndicesOfTwoNumbersUsingCollections
{
	public static void main(String[] args) 
	{
		int[] nums= {2,7,11,15};
		int target=26;
		List<Integer> numsList = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) 
		{
			numsList.add(nums[i]);
		}
		
		for (int i = 0; i < numsList.size(); i++) 
		{
			for (int j = i+1; j < numsList.size(); j++) 
			{
				if (numsList.get(i)+numsList.get(j)==target) 
				{
					System.out.println("The indices are Matched with the Target Nuber "+target+":- [" +i+", "+j+"] !!!");
				}
			}
		}

	}

}