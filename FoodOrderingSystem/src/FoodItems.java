import java.util.ArrayList;

public class FoodItems 
{	
	
	public static ArrayList<FoodItems> menu = new ArrayList<FoodItems>();
	
	public String foodItem;
	public String foodCode;
	public int foodQuantity;
	public int foodPrice;
	
	public static int counter = 0;
	public static int basketNumberSetter = 1; 
	
	public static FoodItems itemPizza = new FoodItems();

	public static FoodItems itemBurger = new FoodItems();
	public static FoodItems itemSandwich = new FoodItems();
	public static FoodItems itemWater = new FoodItems();
	public static FoodItems itemSoftDrink = new FoodItems();
	public static FoodItems itemTea = new FoodItems();
	public static FoodItems itemIceCream = new FoodItems();
	public static FoodItems itemChocolate = new FoodItems();
	
	//CANT GET BASKET CODE TO BE IN ORDER
	
	public static void main(String[] args) 
	{
		
		itemPizza.foodCode = "01";
		itemPizza.foodItem = "Pizza     ";
		itemPizza.foodPrice = 10;
		itemPizza.foodQuantity = 50;
		
		menu.add(itemPizza);
		
		itemBurger.foodCode = "02";
		itemBurger.foodItem = "Burger    ";
		itemBurger.foodPrice = 7;
		itemBurger.foodQuantity = 50;
		
		menu.add(itemBurger);
		
		
		itemSandwich.foodCode = "03";
		itemSandwich.foodItem = "Sandwich  ";
		itemSandwich.foodPrice = 5;
		itemSandwich.foodQuantity = 50;
		
		menu.add(itemSandwich);
		
		
		itemWater.foodCode = "04";
		itemWater.foodItem = "Water     ";
		itemWater.foodPrice = 1;
		itemWater.foodQuantity = 30;
		
		menu.add(itemWater);
		
		
		itemSoftDrink.foodCode = "05";
		itemSoftDrink.foodItem = "Soft drink";
		itemSoftDrink.foodPrice = 2;
		itemSoftDrink.foodQuantity = 30;
		
		menu.add(itemSoftDrink);
		
		
		itemTea.foodCode = "06";
		itemTea.foodItem = "Tea       ";
		itemTea.foodPrice = 2;
		itemTea.foodQuantity = 20;
		
		menu.add(itemTea);
		
		
		itemIceCream.foodCode = "07";
		itemIceCream.foodItem = "Ice cream ";
		itemIceCream.foodPrice = 2;
		itemIceCream.foodQuantity = 20;
		
		menu.add(itemIceCream);
		
		
		itemChocolate.foodCode = "08";
		itemChocolate.foodItem = "Chocolate ";
		itemChocolate.foodPrice = 2;
		itemChocolate.foodQuantity = 20;
		
		menu.add(itemChocolate);
		
	}
	
	public static void printMenu()
	{
		System.out.println("---------- MENU ----------");
		for(int i = 0; i < menu.size(); i ++)
		{
			
			System.out.print(menu.get(i).foodCode + "\t" + menu.get(i).foodItem + "\t" + " £" + menu.get(i).foodPrice + "\t" + menu.get(i).foodQuantity);
			System.out.println();
		}
		System.out.println();
	}
	
	
	public static void selectItem(int choice, ArrayList<FoodItems> list)
	{
		
		for(int i = 0; i < menu.size(); i++)
		{
			int menuCode = Integer.parseInt(menu.get(i).foodCode);
			
			if(menuCode == choice)
			{
				menu.get(i).foodQuantity--;
				list.add(menu.get(i));
				basketNumberSetter++;
				counter++;
				System.out.println(menu.get(i).foodItem + " has been added to basket");
				return;
			}
		}
	}

	
	
}
