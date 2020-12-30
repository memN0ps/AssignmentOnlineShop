/**
 * This class extends product and is an Cup.
 *
 *
 */
public class Cup extends Product
{
	private String colour;
	private int height;
	
	/**
	 * This constructor creates a product of type Cup.
	 * @param name is the name of the product.
	 * @param productCode is the product code.
	 * @param price price of the product.
	 * @param colour colour of the Cup.
	 * @param height of the cup in cm.
	 */
	public Cup(String name, Integer productCode, double price, String colour, int height)
	{
		super(name, productCode, price);
		this.colour = colour;
		this.height = height;
	}
	
	/**
	 * This toString method returns the String representation of the product.
	 */
	public String toString()
	{
		return this.name+", "+this.colour+" "+this.height+"cm tall"+" ("+this.productCode+") "+"- $"+String.format("%1.2f",this.price);
	}
}
