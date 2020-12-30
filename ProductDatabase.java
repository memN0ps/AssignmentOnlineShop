import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * This class stores the products database in a hashmap using the products code
 * as each respective key.
 *
 *
 */
public class ProductDatabase
{
	HashMap<Integer,Product> productHash;
	
	/**
	 * Constructor  to initialize the Hashmap
	 */
	public ProductDatabase()
	{
		productHash = new HashMap<Integer,Product>();
	}
	
	/**
	 * Will try to add a product to the hash. If it exists the value at the current key will 
	 * be overridden.
	 * @param product The product to add
	 */
	public void addProduct(Product product)
	{
		productHash.put(product.getProductCode(), product);
	}
	
	/**
	 * Will attempt to return the product associated to the code in the parameter.
	 * If no product exists, an exception will be thrown.
	 * @param code
	 * @return Returns the Product associated with the code.
	 * @throws ProductNotFoundException 
	 */
	public Product getProduct(int code) throws ProductNotFoundException
	{
		if (productHash.containsKey(code))
		{
			return productHash.get(code);
		} 
		else
		{
			throw new ProductNotFoundException(code);
		}	
	}
	
	/**
	 * Creates new array list and stores the products in the hash.
	 * @return ArrayList storing products in the database
	 */
	public ArrayList<Product> getProductsArray()
	{
		ArrayList<Product> list = new ArrayList<Product>();
		list.addAll(productHash.values());
		return list;
	}
	
	/**
	 * returns a multi-line String representation of the products database.
	 * this is unsorted.
	 * @return data string representation of the product database.
	 */
	public String toString()
	{
		String data = "";
		
		Set<Integer> keySet = productHash.keySet();
		
		Integer[] keysArray = new Integer[keySet.size()];
		keySet.toArray(keysArray);
		
		int count = 0;
		
		for(int x = 0; x < keySet.size(); x++)
		{
			if (count > 0)
			{
				data += "\n";
			}
			data += productHash.get(keysArray[x]).toString();
			count++;	
		}
		return data;
	}
}
