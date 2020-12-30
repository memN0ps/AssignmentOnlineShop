/**
 * This class is an exception to be thrown if a product is not found in the database.
 *
 *
 */
public class ProductNotFoundException extends Exception
{ 
	/**
	 * If the code does not exist in the hash map
	 * @param code the product look up.
	 */
	public ProductNotFoundException(int code)
	{
		super("The product ("+code+") does not exist");
	}
}
