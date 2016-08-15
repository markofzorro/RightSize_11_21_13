/**
 * 
 */
package basesAndUtilites;

import java.text.DecimalFormat;

/**
 * @author Mark White
 *
 */
public class FormatOutputString
{
	
	/**
	 * @param d is a double representing the output of calculation
	 * Converts double to string formatted so the values line up on results panel
	 * @return string
	 */
	public static String format(double d)
		{
			
			DecimalFormat formatter = new DecimalFormat("#####.000");
			String s = formatter.format(d);
			
			return(s);
		}

	
	/*public static String format(double d)
	{
		// TODO Auto-generated method stub
		return null;
	}
	*/
			
}
