package basesAndUtilites;

import javax.swing.JDesktopPane;

// Global class to hold constants. Enums would seem simpler, but I can't get them to work. Odd, but there you are.

public class Globals 
{
	static public final double MIN = 1;
	static public final double MAX = 99;
	static public final double POPULATION_MIN = 100;
	static public final double POPULATION_MAX = 1e81; // Est. number of atoms in the universe
	static public final int POPULATION_MAX_DIGITS = 82; // leave room for x.e80 where x = first digit
	static public final int COLS = 13;
	static public final int TEXT_SIZE = 12;
	static public final int TITLE_SIZE = 24;
	public static final int MAX_DIGITS = 2;
	public static final double ROH_MAX = 10;
	public static final double ROH_MIN = 0.0001;
	public static int ROH_MAX_DIGITS = 5;
}
