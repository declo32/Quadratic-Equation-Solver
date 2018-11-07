/**
 * Represents a number of the form a + b * sqrt(c)
 */
public class Radical {
	private Complex translator;  // a
	private Complex scalar;  // b
	private double radicand;  // c

	public Radical(Complex translator, Complex scalar, double radicand) {
		this.translator = translator;
		this.scalar = scalar;
		this.radicand = radicand;
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
		if ((int)radicand == radicand) {  // if there is no decimal part
			Complex translatorNew;
			Complex scalarNew;
			double radicand;

			int largestSquaredFactor = 1;
			for (int i = 1; i <= Math.sqrt(this.radicand); ++i) {
				if (this.radicand % Math.pow(i, 2) == 0) {  // if the square of i fits in evenly
					largestSquaredFactor = i;
				}
			}
			return new Radical()
		}
	}
}
