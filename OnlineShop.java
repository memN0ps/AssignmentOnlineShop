import java.util.ArrayList;
import java.util.Collections;

/**
 * This class implements the payment system interface and runs the funtions of an online shop
 *
 *
 */
public class OnlineShop implements PaymentSystemInterface
{
	private ProductDatabase database;
	private ProductRecommender productRecommender;
	private ArrayList<Product> cart;
	
	/**
	 * This constructor creates an online shop with an empty shopping cart and a full product database.
	 * @param pb
	 * @param productRecommender
	 */
	public OnlineShop(ProductDatabase pb, ProductRecommender productRecommender)
	{
		this.database = pb;
		this.productRecommender = productRecommender;
		this.cart = new ArrayList<Product>();
	}
	
	/**
	 * This method runs the praAlgorithm with a frequency of two.
	 * @return Arraylist of recommended products.
	 */
	public ArrayList<Product> getRecommended()
	{
		return productRecommender.praAlgorithm(cart, 2);
	}

	/**
	 * Adds the product to the cart.
	 * @param product
	 */
	public void addProductToCart(Product product)
	{
		cart.add(product);
	}
	
	/**
	 * This method calculates the amount owing.
	 * @return amount owing
	 */
	public Double amountOwing()
	{
		double amount = 0;
		
		for (int y = 0; y < cart.size(); y++)
		{
			amount += cart.get(y).getPrice();
		}
		return amount;
	}

	/**
	 * This method empty's the cart.
	 */
	public void completeTransaction()
	{
		cart.clear();
	}
	
	/**
	 * This toString method returns a sorted list of products in the cart.
	 * @return data contains the products in the cart line by line.
	 */
	public String toString()
	{
		Collections.sort(cart);
		String data = "";
		
		for (int y = 0; y < cart.size(); y++)
		{
			data += cart.get(y).toString();
			
			if (y != (cart.size() - 1))
			{
				data += "\n";
			}
		}
		return data;
	}
}
