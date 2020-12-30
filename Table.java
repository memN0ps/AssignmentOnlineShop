/**
 * This class extends product and is an Table.
 * 
 *
 */
public class Table extends Product
{
	private int length;
	private int width;
	
	/**
	 * This constructor creates a product of type Table.
	 * @param name is the name of the product.
	 * @param productCode is the product code.
	 * @param price price of the product.
	 * @param length of table in cm.
	 * @param width of table in cm.
	 */
	public Table(String name, Integer productCode, double price, int length, int width)
	{
		super(name, productCode, price);
		this.length = length;
		this.width = width;
	}
	
	/**
	 * This toString method returns the String representation of the product.
	 */
	public String toString()
	{
		return this.name+", ("+this.width+"cm x"+this.length+"cm) ("+this.productCode+")"+" - $"+String.format("%1.2f",this.price);
	}
}
