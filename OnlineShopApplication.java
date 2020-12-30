import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

   
/**
 * This class runs an online shop and prompts the user for input.
 * It sets up a database of products and reads the purchase history.
 *
 *
 */
public class OnlineShopApplication
{
	private static ProductDatabase database;
	private static ProductRecommender productRecommender;
	private static OnlineShop shop;
	private static HashSet<PurchaseHistory> historySet;
	
	/**
	 * This main method tries and catchs exceptions relating to reading the purchase history txt file.
	 * It also generates a sample database and starts to prompt the user.
	 * @param args 
	 */
	public static void main(String[] args)
	{
		genrateSampleDatabase();
		
		//Exceptions Thrown
		try 
		{
			System.out.println("Reading purchase transcript: purchase-history.txt");
			historySet = readPurchaseHistoryData(database, "purchase-history.txt");
			System.out.println("------------------------------------------------");
		} 
		catch (ProductNotFoundException e)
		{
			System.out.println("Error Reading History. "+e.getMessage());
			historySet = new HashSet<PurchaseHistory>();
		}
		catch (IOException e)
		{
			System.out.println("Error Reading History. "+e.getMessage());
			historySet = new HashSet<PurchaseHistory>();
		} 
		catch (NumberFormatException e)
		{
			System.out.println("Error Reading History. Data corruption!");
			historySet = new HashSet<PurchaseHistory>();
		}
		
		productRecommender = new ProductRecommender(historySet, database);
		shop = new OnlineShop(database, productRecommender);
		getUserInput();
	}
	
	/**
	 * This method tries to read a txt file containing purchase history.
	 * @param pb is the product database.
	 * @param filename name of the file to read.
	 * @return tempSet a set containing purchase histories.
	 * @throws ProductNotFoundException 
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	private static HashSet<PurchaseHistory> readPurchaseHistoryData(ProductDatabase pb, String filename) throws ProductNotFoundException,IOException,NumberFormatException
	{
		HashSet<PurchaseHistory> tempSet = new HashSet<PurchaseHistory>();
	
		Scanner input = new Scanner(new File(filename));
		
		while (input.hasNext())
		{
			String currentLine = input.next();
			
			if (currentLine.length() == 1)
			{
				ArrayList<Product> currentHistory = new ArrayList<>();
				
				for (int i = 0; i < new Integer(currentLine); i++)
				{
					String code = input.next();
					currentHistory.add(database.getProduct(new Integer(code)));
				}
				//Only reaches this line if no exceptions are thrown.
				tempSet.add(new PurchaseHistory(currentHistory));
			}
		}
		return tempSet;
	}
	
	/**
	 * This is a method for testing the online shop
	 */
	private static void genrateSampleDatabase()
	{
		database = new ProductDatabase();
		database.addProduct(new Television("Television", 123, 830.90d, 50, "1920 x 1080"));
		database.addProduct(new Table("Table", 187, 70.70d, 100, 50));
		database.addProduct(new Cup("Wine glass", 199, 9.50d, "Red", 15));
		database.addProduct(new Apple("Apple", 200, 0.70d, "Granny Smith", "Green"));
		database.addProduct(new Speaker("Speaker", 865, 59.99d, 15, "Black"));
	}
	
	/**
	 * This method shows the cart in order.
	 */
	private static void viewCart()
	{
		System.out.println("------------------------------------------------");				
		System.out.println("Contents of your cart (sorted by price)");
		System.out.println(shop.toString());
	}
	
	/**
	 * This method gets the user input and ultimately exits the program.
	 */
	public static void getUserInput()
	{
		Scanner keyboard = new Scanner(System.in);
		int input;
		
		//Main loop
		do
		{
			try
			{
				//If an exception is thrown the user comes back to here
				System.out.println("Online Shop functionality");
				System.out.println("1. Add product to cart");
				System.out.println("2. View your shopping cart");
				System.out.println("3. Finalize purchases");
				System.out.println("4. Quit");
				System.out.println("Please choose a menu item: (1-4)");
				input = keyboard.nextInt();
				
				//Add the product to the cart.
				if (input == 1)
				{
					System.out.println("------------------------------------------------");
					System.out.println("Please select a product from the menu");
					ArrayList<Product> tempProducts = database.getProductsArray(); 
					Collections.sort(tempProducts);
					
					for (int z = 0; z < tempProducts.size(); z++)
					{
						System.out.println(""+(z+1)+" "+tempProducts.get(z));
					}
					System.out.println("Please choose a menu item: (1-5)");
					input = keyboard.nextInt();
					System.out.println("Adding "+tempProducts.get(input - 1)+" to your cart");
					shop.addProductToCart(tempProducts.get(input - 1));
					System.out.println("------------------------------------------------");				
				}
				//Shows the cart
				else if (input == 2)
				{
					if (shop.amountOwing() == 0)
					{
						System.out.println("Your cart is currently empty");
						System.out.println("------------------------------------------------");	
					}
					else
					{
						viewCart();
						System.out.println("------------------------------------------------");	
					}
				}
				//Finalizing the payment
				else if (input == 3)
				{
					if (shop.amountOwing() == 0)
					{
						System.out.println("Your cart is currently empty");
						System.out.println("------------------------------------------------");	
					}
					else
					{
						viewCart();
						System.out.println("Total amount owing: $"+String.format("%1.2f",shop.amountOwing()));
						System.out.println("Pay full amount?");
						System.out.println("1. Yes");
						System.out.println("2. No, back to main menu");
						System.out.println("Please choose a menu item: (1-2)");
						input = keyboard.nextInt();
						
						if (input == 1)
						{
							System.out.println("Thank you for your purchase.");
							System.out.println("You may also be interested in purchasing these products:");
							System.out.print("[");
							ArrayList<Product> tempRecommended = shop.getRecommended();
							Collections.sort(tempRecommended);
							
							for(int x = 0; x < tempRecommended.size(); x++)
							{
								System.out.print(tempRecommended.get(x));
								if(x != tempRecommended.size()-1)
								{
									System.out.print(", ");
								}
							}
							System.out.println("]");
							shop.completeTransaction();
							System.out.println("------------------------------------------------");	
						}
						else if (input == 2)
						{
							System.out.println("------------------------------------------------");	
						}
					}
				}
				//Exits the program
				else if (input == 4)
				{
					break;
				}
				//Bad input
				else 
				{
					System.out.println("Invalid input try again");
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid input try again");
				input = 0;
				keyboard.nextLine();
			}
			catch (IndexOutOfBoundsException e)
			{
				System.out.println("Invalid input try again");
				input = 0;
				keyboard.nextLine();
			}
		}
		while (true);
		//end of loop
	}
}


