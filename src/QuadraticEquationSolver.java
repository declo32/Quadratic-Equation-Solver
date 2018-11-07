public class QuadraticEquationSolver {
	// ax^2 + bx + c = 0
	private double a, b, c;

	public QuadraticEquationSolver(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public Complex[] getZeros(boolean preserveRadical) {
		double discriminant = Math.pow(b, 2) - (4*a*c);

		if (discriminant == 0) {
			Complex[] zeros = new Complex[1];
			zeros[0] = Complex.fromDouble((-b) / (2*a));

			return zeros;
		} else {
			Complex[] zeros = new Complex[2];

			if (discriminant > 0) {
				zeros[0] = Complex.fromDouble((-b + Math.sqrt(discriminant)) / (2*a));
				zeros[1] = Complex.fromDouble((-b + Math.sqrt(discriminant)) / (2*a));
			} else {
				zeros[0] = Complex.fromRect(-b / (2*a), Math.sqrt(discriminant) / (2*a));
				zeros[1] = Complex.fromRect(-b / (2*a), -Math.sqrt(discriminant) / (2*a));
			}

			return zeros;
		}
	}
}
