import java.util.ArrayList;
import java.util.Scanner;


public class MenuInterface 
{
	public static Scanner input = new Scanner(System.in);
	public static ArrayList<FoodItems> basket = new ArrayList<FoodItems>();
	public static int userItemChoice;
	public static int userMenuChoice;
	public static int itemToDelete;
	public static String deleteItem;
	public static String checkOut;
	public static int customerCash;
	
	public static void main(String[] args) 
	{
		
		
		FoodItems foodItems = new FoodItems();
		
		
		foodItems.main(args);
		
		
		while(true)
		{
			System.out.println("Select an option: \n"
					+ "1: Look at the menu \n"
					+ "2: View basket \n"
					+ "3: Check out \n"
					+ "4: Quit");
			
			userMenuChoice = input.nextInt();
			
			switch(userMenuChoice)
			{
			case 1:
				
				FoodItems.printMenu();
				
				System.out.println("Please enter the code of the item you wish to buy: ");
				userItemChoice = input.nextInt();
			
				foodItems.selectItem(userItemChoice, basket);
				
				break;
			case 2:
				printBasket();
				System.out.println("Would you like to delete an item?  Y/N");
				deleteItem = input.next().toUpperCase();
				if(deleteItem.contentEquals("Y"))
				{
					System.out.println();
					System.out.println("Enter number of item you wish to delete: " );
					itemToDelete = input.nextInt();
					deleteItemInBasket(itemToDelete);
					printBasket();
				}
				break;
			case 3:
				System.out.println("Do you wish to check out? Y/N");
				checkOut = input.next().toUpperCase();
				if(checkOut.contentEquals("Y"))
				{
					checkOut();
				}
				break;
			case 4:
				System.exit(0);
				break;
			}
			
			
		}
		
	}
	
	public static void deleteItemInBasket(int itemToDelete)
	{
		for(int i = 0; i < basket.size(); i ++)
		{
			if(i == itemToDelete - 1)
			{
				basket.remove(i);
			}
		}
		System.out.println();
	}
	
	public static void printBasket()
	{
		int total =0;
		System.out.println("---------- BASKET ----------");
		for(int i =0; i < basket.size(); i++)
		{
			total += basket.get(i).foodPrice;
			System.out.println(i + 1 + " - " + basket.get(i).foodItem + " £" + basket.get(i).foodPrice);
		}
		System.out.println("---------- Total £ " + total + " ----------");
		System.out.println();
	}
	
	public static void checkOut()
	{
		System.out.println();
		printBasket();
		int total = 0;
		for(int i = 0; i < basket.size(); i++)
		{
			total += basket.get(i).foodPrice;
		}
		
		System.out.println("Your final bill is £" + total + "\n");
		System.out.println("Enter cash amount to pay: ");
		customerCash = input.nextInt();
		
		if(customerCash > total)
		{
			int change = customerCash - total; 
			System.out.println("You have: £" + change + " change");
			System.out.println("Transaction complete thank you!");
			emptyBasket();
			System.out.println();
			
		}
	}
	
	public static void emptyBasket()
	{
		for(int i = 0; i < basket.size(); i++)
		{
			basket.remove(i);
		}
	}
	

}
