import java.util.ArrayList;
import java.util.Scanner;


public class MenuInterface 
{
	public static Scanner input = new Scanner(System.in);
	public static ArrayList<FoodItems> basket = new ArrayList<FoodItems>();
	
	//variables which store user menu choices
	public static int userItemChoice;
	public static int userMenuChoice;
	public static int itemToDelete;
	public static String deleteItem;
	public static String checkOut;
	public static int customerCash;
	public static int quantityRequested;
	public static int change;
	public static boolean billPaid = false;
	
	
	public static void main(String[] args) 
	{	
		//creating an instance of the Food Items class
		FoodItems foodItems = new FoodItems();	
		foodItems.main(args);
		
		//A while loop from where all functions are called from, using a menu 
		while(true)
		{
			System.out.println("Select an option: \n"
					+ "1: Select an item from the menu \n"
					+ "2: Remove item from basket \n"
					+ "3: Check out \n"
					+ "4: Quit");
			
			userMenuChoice = input.nextInt();
			
			switch(userMenuChoice)
			{
			case 1:
				
				FoodItems.printMenu();
				
				System.out.println("Please enter the code of the item you wish to buy: ");
				userItemChoice = input.nextInt();
				
				System.out.println("How many " + foodItems.menu.get(userItemChoice - 1).foodItem + " would you like?");
				quantityRequested = input.nextInt();
				
				//calling a function from the instance of the Food Items class, passing in a food code, the quantity needed and the basket array
				foodItems.selectItem(userItemChoice, quantityRequested, basket);
				
				break;
			case 2:
				printBasket();
				System.out.println("Would you like to delete an item?  Y/N");
				deleteItem = input.next().toUpperCase();
				if(deleteItem.contentEquals("Y"))
				{
					System.out.println();
					System.out.println("Enter food code of item you wish to delete: " );
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
					checkOut(false, (Integer)null);
				}
				break;
			case 4:
				System.exit(0);
				break;
			}
			
			
		}
		
	}
	
	//A function which takes in an integer which is then used to dictate which item is deleted from the basket array
	public static void deleteItemInBasket(int itemToDelete)
	{
		System.out.println("How many items do you want to delete?");
		int deleteQty = input.nextInt();
		
		
		for(int i = 0; i < basket.size(); i ++)
		{
			//a local variable to hold the converted food code, from string to integer
			int holder = Integer.parseInt(basket.get(i).foodCode);
			
			//Then we compare the local variable of the converted string to the users menu choice E.G.   01, 02, 03
			if(holder == itemToDelete)
			{
				//An if statement which checks if the amount the user wants to delete is greater than the amount in the basket, if so then all the items are removed
				if(basket.get(i).foodQuantity <= 1 || deleteQty > basket.get(i).foodQuantity)
				{
					basket.remove(i);
					System.out.println("All items of this type removed");
					FoodItems.counter--;
				}
				else 
				{
					//if the quantity is less than wahts in the basket then we just remove that amount
					System.out.println(deleteQty + " item removed");
					basket.get(i).foodQuantity -= deleteQty;
				}
			}
		}
		System.out.println();
	}
	
	public static void printBasket()
	{
		
		int total =0;
		System.out.println("---------- BASKET ----------");
		
		//A for loop which loops through each element of the basket and prints it to console 
		for(int i =0; i < basket.size(); i++)
		{
			//a local variable which tracks the total cost of all the items in the basket
			total += basket.get(i).foodPrice * basket.get(i).basketQuantity;
			System.out.println(basket.get(i).foodCode + "\t" + basket.get(i).foodItem + FoodItems.spaceSetter(basket.get(i).foodItem) + "\t£" + basket.get(i).foodPrice + "\t Qty: " + basket.get(i).basketQuantity);
		}
		System.out.println("---------- Total £ " + total + " ----------");
		System.out.println();
	}
	
	
	
	public static int checkOut(boolean testing, int inputMoney)
	{
		System.out.println();
		printBasket();

		int total = 0;
		
		
		//An if statement which divides the code for testing and general use
		if(testing == false)
		{
			//Calculating the total price of the basket
			for(int i = 0; i < basket.size(); i++)
			{
				total += basket.get(i).foodPrice * basket.get(i).foodQuantity;
			}
			
			System.out.println("Your final bill is £" + total + "\n");
			System.out.println("Enter cash amount to pay: ");

			customerCash = input.nextInt();
			
			//Checking to see if the customer has given the right amount of money
			if(customerCash >= total)
			{
				int change = customerCash - total; 
				System.out.println("You have: £" + change + " change");
				System.out.println("Transaction complete thank you!");
				
				//Call the empty basket function
				emptyBasket();
				System.out.println();
				billPaid = true;
			}
			else
			{
				System.out.println("Insufficient cash provided, please try again");
				System.out.println();
			}
		}
		else
		{
			//Calculating the total price of the basket
			for(int i = 0; i < basket.size(); i++)
			{
				total += basket.get(i).foodPrice * basket.get(i).foodQuantity;
			}
			
			
			//Checking to see if the customer has given the right amount of money
			if(inputMoney >= total)
			{
				change = inputMoney - total; 
				System.out.println("You have: £" + change + " change");
				System.out.println("Transaction complete thank you!");
				
				//Call the empty basket function
				emptyBasket();
				System.out.println();
				billPaid = true;
			}
			else
			{
				System.out.println("Insufficient cash provided, please try again");
				System.out.println();
			}
		}
		return inputMoney - change;
	}
	
	public static void emptyBasket()
	{
		for(int i = 0; i < basket.size(); i++)
		{
			basket.remove(i);
		}
	}
	

}
