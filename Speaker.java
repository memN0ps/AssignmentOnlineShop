/**
 * This class extends product and is an Speaker.
 *
 *
 */
public class Speaker extends Product
{
	private int size;
	private String colour;
	
	/**
	 * This constructor creates a product of type Speaker.
	 * @param name is the name of the product.
	 * @param productCode is the product code.
	 * @param price price of the product.
	 * @param size of speaker in cm.
	 * @param colour of speaker.
	 */
	public Speaker(String name, Integer productCode, double price, int size, String colour)
	{
		super(name, productCode, price);
		this.size = size;
		this.colour = colour;
	}
	
	/**
	 * This toString method returns the String representation of the product.
	 */
	public String toString()
	{
		return this.name+", "+this.colour+" "+this.size+"cm"+" ("+this.productCode+") "+"- $"+String.format("%1.2f",this.price);  
	}
}
