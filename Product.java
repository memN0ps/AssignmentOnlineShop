/**
 * This abstract class provides the foundations for other product classes
 * to be built on and implements the comparable interface
 * This is to allow 
 *
 *
 */
public abstract class Product implements Comparable<Product>
{
	protected String name;
	protected Integer productCode;
	protected double price;
	
	/**
	 * Instantiates a new product
	 * @param name product name
	 * @param productCode product code 
	 * @param price product price
	 */
	public Product(String name, int productCode, double price)
	{
		this.name = name;
		this.price = price;
		this.productCode = productCode;	
	}
	
	/**
	 * gets the product code.
	 * @return the product code.
	 */
	public int getProductCode()
	{  
		return this.productCode;
	}
	
	/**
	 * gets the name of the product.
	 * @return the name of the product.
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * gets the price of the product.
	 * @return the price of the product.
	 */
	public double getPrice()
	{
		return this.price;
	}
	
	/**
	 * Compares the price of two products
	 * 
	 * returns -1 if the parameter is more expensive
	 * returns 1 if the parameter is cheaper
	 * returns 0 if the prices are the same
	 */
	public int compareTo(Product product)
	{		
		if (price == product.getPrice())
		{
			return 0;
		}
		else if (price < product.getPrice())
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
}
