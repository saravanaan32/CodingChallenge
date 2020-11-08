/*******************************************************************************
	Cold Coffee Bottles:-
	================
	|	|	|		|
	|	|	|	=	|	=	|
	|	|	|		|
	
	Total Drinks Consumed = 9 + 3 + 1 = 13
	
	9/3 = 3
	3/3=1
	9+3+1
	
	Int input=9; 
	While i==1
	Rem=input/3=3
	Temp=temp+rem;
	Input=rem;
	
	|	|	|	|	|1
	|	|	|	|	|1
	|	|	|	|	|1
	|	|	|	|	|1
	|	|	|	|	|1		 1
	
********************************************************************************/
package day1;

public class coldCoffeeBottleGame 
{
	public static int 
	input =25, exchangeBottles =5, remainingEmptyBottlesWithoutExhange=0, 
	emptyBottles=0, totalColdCoffeeConsumed=0;
	public static void main(String[] args) 
	{
		totalColdCoffeeConsumed=input;
		while (input>=exchangeBottles) 
		{
			emptyBottles=input/exchangeBottles;
			remainingEmptyBottlesWithoutExhange=input%exchangeBottles;
			totalColdCoffeeConsumed=totalColdCoffeeConsumed+emptyBottles;
			input=emptyBottles+remainingEmptyBottlesWithoutExhange;
		}
		System.out.println("Total Cold Coffee Consumed:- " +totalColdCoffeeConsumed);
	}
}