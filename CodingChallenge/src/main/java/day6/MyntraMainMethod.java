package day6;

public class MyntraMainMethod extends MyntraSunglassfunctions
{

	public static void main(String[] args) throws InterruptedException 
	{
		MyntraSunglassfunctions obj=new MyntraSunglassfunctions();
		obj.browserApplication();
		obj.searchByProduct();
		obj.filterByBrand();
		obj.totalProduct();
		obj.filterByGenderAndType();
		obj.simillarProducts();
		obj.broserClose();	
		
	}

}
