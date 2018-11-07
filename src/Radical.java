/**
 * Represents a number of the form a + b * sqrt(c)
 */
public class Radical {
	private Complex translator;  // a
	private Complex scalar;  // b
	private double radicand;  // c

	public Radical(Complex translator, Complex scalar, double radicand, boolean simplify) {
		this.translator = translator;
		this.scalar = scalar;
		this.radicand = radicand;

		// If the scalar or radicand are zero, then the entire second term of a+b*sqrt(c) is zero, no use simplifying
		if (scalar.equals(Complex.ZERO) || radicand == 0) {
			simplify = false;
			this.scalar = Complex.ZERO;
			this.radicand = 0;
		}

		if (simplify) {
			Radical simplified = this.simplify();
			this.translator = simplified.getTranslator();
			this.scalar = simplified.getScalar();
			this.radicand = simplified.getRadicand();
		}
	}

	public Complex getTranslator() {
		return translator;
	}

	public void setTranslator(Complex translator) {
		this.translator = translator;
	}

	public Complex getScalar() {
		return scalar;
	}

	public void setScalar(Complex scalar) {
		this.scalar = scalar;
	}

	public double getRadicand() {
		return radicand;
	}

	public void setRadicand(double radicand) {
		this.radicand = radicand;
	}

	@Override
	public String toString() {
		return "Radical{" +
				"translator=" + translator +
				", scalar=" + scalar +
				", radicand=" + radicand +
				'}';
	}

	public Radical simplify() {
		Complex scalarNew = scalar;
		double radicandNew = radicand;

		if (radicand % 1 == 0) {  // if there is no decimal part
			int largestSquaredFactor = largestSquaredFactor((int) radicand);  // casting has no effect
			scalarNew = scalarNew.multiply(Complex.fromDouble(Math.sqrt(largestSquaredFactor)));
			radicandNew /= largestSquaredFactor;
		}

		if (radicand < 0) {  // Factor out -1 from radicand, bring i to scalar
			scalarNew = scalarNew.multiply(Complex.I);
			radicandNew = -radicandNew;
		}

		return new Radical(translator, scalarNew, radicandNew, false);  // true would cause an infinite loop
	}

	/**
	 * Get the largest perfect square integer which will factor evenly into some other integer.
	 * @param n The integer to be factored
	 * @return The largest perfect square integer which will factor evenly into <code>n</code>
	 */
	private int largestSquaredFactor(int n) {
		int largestFactorWhenSquared = 1;

		for (int i = 0; i <= Math.sqrt(n); ++i) {
			if (n % Math.pow(i, 2) == 0) {
				largestFactorWhenSquared = i;
			}
		}

		return (int) Math.pow(largestFactorWhenSquared, 2);
	}
}
