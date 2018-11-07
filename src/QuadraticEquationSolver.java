public class QuadraticEquationSolver {
	// ax^2 + bx + constant = d
	private double coefficient1, coefficient2, constant;

	public QuadraticEquationSolver(double a, double b, double c, double d) {
		this.coefficient1 = a;
		this.coefficient2 = b;
		this.constant = c - d;
	}

	public double getCoefficient1() {
		return coefficient1;
	}

	public void setCoefficient1(double coefficient1) {
		this.coefficient1 = coefficient1;
	}

	public double getCoefficient2() {
		return coefficient2;
	}

	public void setCoefficient2(double coefficient2) {
		this.coefficient2 = coefficient2;
	}

	public double getConstant() {
		return constant;
	}

	public void setConstant(double constant) {
		this.constant = constant;
	}

	@Override
	public String toString() {
		return "QuadraticEquationSolver{" +
				"coefficient1=" + coefficient1 +
				", coefficient2=" + coefficient2 +
				", constant=" + constant +
				'}';
	}

	public Radical[] getZeros() {
		double discriminant = Math.pow(coefficient2, 2) - (4* coefficient1 * constant);

		if (discriminant == 0) {
			Radical[] zeros = {
					new Radical(
							Complex.fromDouble(-coefficient2/(2*coefficient1)),
							Complex.ZERO,
							discriminant, false
					)
			};

			return zeros;
		} else {
			Radical[] zeros = {
					new Radical(
							Complex.fromDouble(-coefficient2/(2*coefficient1)),
							Complex.fromDouble(1/(2*coefficient1)),
							discriminant, true
					),
					new Radical(  // the same thing, but the scalar is negative
							Complex.fromDouble(-coefficient2/(2*coefficient1)),
							Complex.fromDouble(-1/(2*coefficient1)),
							discriminant, true
					)
			};

			return zeros;
		}
	}
}
