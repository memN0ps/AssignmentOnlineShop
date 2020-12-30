import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *This class recommends products based on the users choice. 
 *
 *
 */
public class ProductRecommender
{
	private Set<PurchaseHistory> allPurchases;
	private ProductDatabase database; //Instead of having a list of all possible products, I only count products that are used in history.
	//A mapping of products to their tally's
	private HashMap<Product,Integer> purchasesTally = new HashMap<Product, Integer>(); 

	/**
	 * This constructor creates a products recommender based on history and database.
	 * @param allPurchases is all the purchases ever made.
	 * @param database is database of products.
	 */
	public ProductRecommender(Set<PurchaseHistory> allPurchases, ProductDatabase database)
	{
		this.allPurchases = allPurchases;
		this.database = database;
	}
	
	/**
	 * This method gives all the recommended products based on the history of 
	 * purchases and the users purchases.
	 * @param cart all of the users purchases.
	 * @param freq the smallest amount of times a product is purchased to be recommended.
	 * @return An Arraylist of recommended products.
	 */
	public ArrayList<Product> praAlgorithm(ArrayList<Product> cart, int freq)
	{	
		//this loops all the history
		for (PurchaseHistory history : allPurchases)
		{
			//Only look in histories that contain all of the users purchases
			if (history.getPurchasesArray().containsAll(cart))
			{
				//Loops through all the products in a single history
				for (Product p : history.getPurchasesArray())
				{
					//Don't count products in the cart
					if (!cart.contains(p))
					{
						updateTally(p);
					}
				}
			}
		}
		ArrayList<Product> recommendedProducts = new ArrayList<Product>();
		//Loops through a list of products that were counted in the tally's
		for (Product p : purchasesTally.keySet())
		{
			int frequency = purchasesTally.get(p);
			//if the frequency is greater than or equal to the tally's of the product.
			if (frequency >= freq)
			{
				recommendedProducts.add(p);
			}
		}
		return recommendedProducts;	
	}
	
	/**
	 * This method increases the tally's for a specific product
	 * @param p the product to increase the tally's for
	 */
	private void updateTally(Product p)
	{
		//Mapping products to tallys
		if (purchasesTally.containsKey(p))
		{
			purchasesTally.put(p, purchasesTally.get(p)+1);
		}
		else 
		{
			purchasesTally.put(p, 1);
		}
	}
}
