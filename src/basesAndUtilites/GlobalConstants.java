package basesAndUtilites;


// Global class to hold constants. Enums would seem simpler, but I can't get them to work. Odd, but there you are.

public class GlobalConstants 
{
	static public final double MIN = 0.01;
	static public final double MAX = 99.99;
	static public final double POPULATION_MIN = 100;
	static public final double POPULATION_MAX = 1e81; // Est. number of atoms in the universe
	static public final int POPULATION_MAX_DIGITS = 82; // leave room for x.e80 where x = first digit
	static public final int COLS = 15;
	static public final int TEXT_SIZE = 12;
	static public final int TITLE_SIZE = 24;
	public static final int MAX_DIGITS = 2;
	public static final double ROH_MAX = 1;
	public static final double ROH_MIN = 0;
	public static final int ROH_MAX_DIGITS = 3;
	public static final double DESIGN_EFFECT_MIN = 1;
	public static final double DESIGN_EFFECT_MAX = 30;
	public static final double CONFIDENCE_INTERVAL_MIN = 1;
	public static final double CONFIDENCE_INTERVAL_MAX = 20;
	public static final double CONFIDENCE_LEVEL_MIN = 90;
	public static final double CONFIDENCE_LEVEL_MAX = 99.99;
	public static final double CLUSTER_SIZE_MIN = 1;
	public static final double CLUSTER_SIZE_MAX = 100;
}
