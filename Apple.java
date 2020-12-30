/**
 * This class extends product and is an Apple.
 *
 *
 */
public class Apple extends Product
{
	private String brand;
	private String colour;
	
	/**
	 * This constructor creates a product of type Apple.
	 * @param name is the name of the product.
	 * @param productCode is the product code.
	 * @param price price of the product.
	 * @param brand the brand of the product.
	 * @param colour the colour of the product.
	 */
	public Apple(String name, Integer productCode, double price, String brand, String colour)
	{
		super(name, productCode, price);
		this.brand = brand;
		this.colour = colour;
	}
	
	/**
	 * This toString method returns the String representation of the product.
	 */
	public String toString()
	{
		return this.name+", "+this.colour+" "+this.brand+" ("+this.productCode+") "+"- $"+String.format("%1.2f",this.price);
	}
}
