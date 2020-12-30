import java.util.ArrayList;

/**
 * This class stores the purchase history of a customer in an Array list
 *
 *
 */
public class PurchaseHistory 
{
	private	ArrayList<Product> productsPurchased;
	
	/**
	 * Initialize the Array list with the passed parameter 
	 * @param purchases products in an Array List that have been purchased
	 */
	public PurchaseHistory(ArrayList<Product> purchases)
	{
		this.productsPurchased = purchases;
	}
	
	/**
	 * This method gets the purchased array.
	 * @return productsPurchased.
	 */
	public ArrayList<Product> getPurchasesArray()
	{
		return this.productsPurchased;
	}
}
