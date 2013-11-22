package basesAndUtilites;

/**
 * Converts as double to a string with no trailing decimals
 * @author markofzero
 *
 */
public class RSDoubleToLongToString
 
	{
		public static String convert(double d)
			{
				long l = (long) d;
				
				String s = Long.toString(l);
			//	D.b("s = " + s);
				
				return s;
			}
	}
