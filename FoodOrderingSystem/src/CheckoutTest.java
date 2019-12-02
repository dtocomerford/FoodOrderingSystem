import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckoutTest {

	MenuInterface menuInterface = new MenuInterface();
	FoodItems foodItems = new FoodItems();
	int total;
	
	
	//Test one
	@Test
	void testOne() 
	{
		foodItems.main(null);
		
		
		//First test, Ordering 2 Pizza, 1 sandwich and 3 coffee and making a successful payment with £40 
		menuInterface.basket.add(foodItems.itemPizza);
		menuInterface.basket.get(0).foodQuantity = 2;
		
		menuInterface.basket.add(foodItems.itemSandwich);
		menuInterface.basket.get(1).foodQuantity = 1;
		
		menuInterface.basket.add(foodItems.itemCoffee);
		menuInterface.basket.get(2).foodQuantity = 3;
		
		for(int i = 0; i < menuInterface.basket.size(); i++)
		{
			total += menuInterface.basket.get(i).foodPrice * menuInterface.basket.get(i).foodQuantity;
		}
		
		int result = menuInterface.checkOut(true, 40);
		
		assertEquals((total), result, "Error in transaction");
		
		
			
	}
	
	//Test two
	@Test
	void testTwo()
	{
		foodItems.main(null);
		
		//Second test, Ordering 2 Burger, 1 soft drink with an unsuccessful payment with £10 
		menuInterface.basket.add(foodItems.itemBurger);
		menuInterface.basket.get(0).foodQuantity = 2;	
		
		menuInterface.basket.add(foodItems.itemSoftDrink);
		menuInterface.basket.get(1).foodQuantity = 1;
	
		
		for(int i = 0; i < menuInterface.basket.size(); i++)
		{
			total += menuInterface.basket.get(i).foodPrice * menuInterface.basket.get(i).foodQuantity;
		}
				
		int result = menuInterface.checkOut(true, 10);
				
		assertEquals((total), result, "Error in transaction");
	}

}
