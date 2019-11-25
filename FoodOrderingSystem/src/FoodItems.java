import java.util.ArrayList;

public class FoodItems 
{	
	
	public static ArrayList<FoodItems> menu = new ArrayList<FoodItems>();
	
	public String foodItem;
	public String foodCode;
	public int foodQuantity;
	public int foodPrice;
	public static int counter = 0;
	public static StringBuilder stringBuilder = new StringBuilder();
	
	//Objects of the FoodItems class which are then stored Array List menu
	public static FoodItems itemPizza = new FoodItems();
	public static FoodItems itemBurger = new FoodItems();
	public static FoodItems itemSandwich = new FoodItems();
	public static FoodItems itemWater = new FoodItems();
	public static FoodItems itemSoftDrink = new FoodItems();
	public static FoodItems itemTea = new FoodItems();
	public static FoodItems itemCoffee = new FoodItems();
	public static FoodItems itemIceCream = new FoodItems();
	public static FoodItems itemChocolate = new FoodItems();
	
	
	//in main the FoodItems objects variables are given values
	public static void main(String[] args) 
	{
		
		itemPizza.foodCode = "01";
		itemPizza.foodItem = "Pizza";
		itemPizza.foodPrice = 10;
		itemPizza.foodQuantity = 50;
		
		//then added to the array list
		menu.add(itemPizza);
		
		itemBurger.foodCode = "02";
		itemBurger.foodItem = "Burger";
		itemBurger.foodPrice = 7;
		itemBurger.foodQuantity = 50;
		
		menu.add(itemBurger);
		
		
		itemSandwich.foodCode = "03";
		itemSandwich.foodItem = "Sandwich";
		itemSandwich.foodPrice = 5;
		itemSandwich.foodQuantity = 50;
		
		menu.add(itemSandwich);
		
		
		itemWater.foodCode = "04";
		itemWater.foodItem = "Water";
		itemWater.foodPrice = 1;
		itemWater.foodQuantity = 30;
		
		menu.add(itemWater);
		
		
		itemSoftDrink.foodCode = "05";
		itemSoftDrink.foodItem = "Soft drink";
		itemSoftDrink.foodPrice = 2;
		itemSoftDrink.foodQuantity = 30;
		
		menu.add(itemSoftDrink);
		
		
		itemTea.foodCode = "06";
		itemTea.foodItem = "Tea";
		itemTea.foodPrice = 2;
		itemTea.foodQuantity = 20;
		
		menu.add(itemTea);
		
		
		itemCoffee.foodCode = "07";
		itemCoffee.foodItem = "Coffee";
		itemCoffee.foodPrice = 2;
		itemCoffee.foodQuantity = 20;
		
		menu.add(itemCoffee);
		
		itemIceCream.foodCode = "08";
		itemIceCream.foodItem = "Ice cream";
		itemIceCream.foodPrice = 2;
		itemIceCream.foodQuantity = 20;
		
		menu.add(itemIceCream);
		
		
		itemChocolate.foodCode = "09";
		itemChocolate.foodItem = "Chocolate";
		itemChocolate.foodPrice = 2;
		itemChocolate.foodQuantity = 20;
		
		menu.add(itemChocolate);
		
	}
	
	//Function to print the menu to console
	public static void printMenu()
	{
		System.out.println("---------- MENU ----------");
		//Loops through all elements of the menu
		for(int i = 0; i < menu.size(); i ++)
		{
			//prints the values of the variables for each object
			System.out.print(menu.get(i).foodCode + " \t" + menu.get(i).foodItem + spaceSetter(menu.get(i).foodItem) + "\t £" + menu.get(i).foodPrice + "\t" + menu.get(i).foodQuantity);
			System.out.println();
		}
		System.out.println();
	}
	
	
	//Function to select items from the menu and put into the basket 
	public static void selectItem(int choice, int quantity, ArrayList<FoodItems> list)
	{
		//A for loop which checks every element in the menu array
		for(int i = 0; i < menu.size(); i++)
		{
			//a local variable to hold the converted food code, from string to integer
			int menuCode = Integer.parseInt(menu.get(i).foodCode);
			
			//Then we compare the local variable of the converted string to the users menu choice E.G.   01, 02, 03
			if(menuCode == choice)
			{
				//Once the loop finds the element with the matching food code 
				
				menu.get(i).foodQuantity--;									//the quantity of that food is decreased
				list.add(menu.get(i));										//that object is added to the basket array list
				list.get(counter).foodQuantity = quantity;					//set the quantity of that object to what the customer requested
				counter++;													//increase the index variable for the basket  
				System.out.println("Counter: " + counter);
				System.out.println("List size: " + list.size());
				System.out.println(menu.get(i).foodItem + " has been added to basket");
				return;
			}
		}		
	}
	
	
	
	public static StringBuilder spaceSetter(String input)
	{
		stringBuilder.delete(0, stringBuilder.length());
		String space = "          "; 
		
		for(int i = input.length(); i < space.length(); i++)
		{
			stringBuilder.append(" ");
		}
		
		return stringBuilder;
	}
}


