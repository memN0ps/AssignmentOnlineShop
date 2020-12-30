/**
 * This class extends product and is an Television.
 *
 *
 */
public class Television extends Product
{
	private int size;
	private String resolution;
	
	/**
	 * This constructor creates a product of type Television.
	 * @param name is the name of the product.
	 * @param productCode is the product code.
	 * @param price price of the product.
	 * @param size is the size of the product in inches.
	 * @param resolution is the resolution in pixels.
	 */
	public Television(String name, Integer productCode, double price, int size, String resolution)
	{
		super(name, productCode, price);
		this.resolution = resolution;
		this.size = size;
	}
	/**
	 * This toString method returns the String representation of the product.
	 */
	public String toString()
	{
		return this.name+", "+this.size+"\" "+this.resolution+" ("+this.productCode+") "+"- $"+String.format("%1.2f",this.price); 	
	}
}
