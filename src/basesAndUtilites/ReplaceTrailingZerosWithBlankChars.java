/**
 * 
 */
package basesAndUtilites;

/**
 * Set up text strings for labels so that there are
 * no trailing zeros, but align correctly because they are replaced with blanks.
 * 
 * Since Strings are immutable, must use StringBuilder
 * 
 * @author Mark White
 *
 */
public class ReplaceTrailingZerosWithBlankChars
{
	
		public static String format(String s)
		{
			
			StringBuilder sb = new StringBuilder(s);
			int len = sb.length();
			
			if(len > 0)
				{
					for(int i = len - 1; i > 0; i--) // Because strings use zero-based indexing.
						{
							//System.out.println("Before removing trailing zeros s[" + i + "] is "+ sb.charAt(i));
							System.out.println("Before removing trailing blanks, sb is " + sb);
// !!!GEt rid of trailing period!!
							
							if (sb.charAt(i) == '0' && sb.charAt(i-1) >= 0)  
													sb.setCharAt(i, '\32'); // must use ASCII for blank space.
											
						}
				}
			
			System.out.println("After removing trailing blanks, sb is " + sb);
			return sb.toString();
			
		}
}