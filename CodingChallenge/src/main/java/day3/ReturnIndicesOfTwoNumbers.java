/*******************************************************************************************************************************
		int[] nums= {2,7,11,15};
		int target=17;
		sum of any two number in an array is equal to the target value
*******************************************************************************************************************************/
package day3;

public class ReturnIndicesOfTwoNumbers 
{
	public static void main(String[] args) 
	{
		int[] nums= {1, 5, 7, -1, 5};
		int target=6;
		boolean flag=false;
		for (int i = 0; i < nums.length; i++) 
		{
			for (int j = i+1; j < nums.length; j++) 
			{
				if (nums[i]+nums[j]==target) 
				{
					System.out.println("The indices are Matched with the Target Nuber "+target+":- [" +i+", "+j+"] !!!");
					flag=true;
				}
			}
		}
		if (flag==false) 
		{
			System.out.println("Not Matched");
		}

	}

}