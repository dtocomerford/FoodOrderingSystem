import java.util.ArrayList;
import java.util.Scanner;


public class MenuInterface 
{
	public static Scanner input = new Scanner(System.in);
	public static ArrayList<FoodItems> basket = new ArrayList<FoodItems>();
	public static int userItemChoice;
	public static int userMenuChoice;
	
	public static void main(String[] args) 
	{
		
		
		FoodItems foodItems = new FoodItems();
		foodItems.main(args);
		foodItems.printMenu();
		
		
		while(true)
		{
			System.out.println("Select an option: \n"
					+ "1: Look at the menu \n"
					+ "2: View basket \n"
					+ "3: Quit");
			
			userMenuChoice = input.nextInt();
			
			switch(userMenuChoice)
			{
			case 1:
				break;
			}
			
			System.out.println("Please enter the code of the item you wish to buy: ");
			userItemChoice = input.nextInt();
			
			foodItems.selectItem(userItemChoice, basket);
			
			System.out.println("You have selected ");
			
			basket.forEach((n) -> System.out.println(n.foodItem));
			
		}
		
	}

}
