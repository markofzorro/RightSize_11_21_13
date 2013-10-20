package rightSize;

import org.apache.commons.math3.distribution.NormalDistribution;

public class SRSCalculator
	{	
		private SRSDoc doc = null;
		protected double population = 100;
		protected double confidenceInterval = 5;
		protected double confidenceCoefficient = 95;
		protected double proportion = 50;
		protected double n0 = 0;
		protected double n = 0;
		protected double fpc = 0;
		
		
		static final double POP_MAX = 100000000000000000D;
		static final double POP_MIN = 10; // No sense in trying to do survey on less
		static final int POP_MAX_DIGITS = 18;
		
		static final double PROPORTION_MAX = 99;
		static final double PROPORTION_MIN = 1;
		static final int PROPORTION_MAX_DIGITS = 2;
		
		static final double CI_MAX = 50;
		static final double CI_MIN = 1;
		static final int CI_MAX_DIGITS = 2;
		
		static final double CC_MAX = 99;
		static final double CC_MIN = 90;
		static final int CC_MAX_DIGITS = 2;
		

		public SRSCalculator(SRSDoc doc, double pop, double proportion, double ConfidenceInterval, double  confidenceCoeffecient)
			{
				// load up class-level vars
				
				this.doc = doc;
				this.population = pop;
				this.proportion = proportion;
				this.confidenceInterval = confidenceInterval;
				this.confidenceCoefficient = confidenceCoeffecient;
				
				
				calculate();
				if(n>0 && n>0 && fpc != 0)
					doc.getCalculationResults(n0, fpc, n);				
				
			}
		

					
				
	
	}
	


/****** end of calculations */
/** Validation and value setting and getting methods follow */
	}
