public class ComplexTester {
	public static void main(String[] args) {
		Complex[] cs = {
				Complex.fromRect(1, 2),
				Complex.fromPolar(1, Math.PI/2),
				Complex.fromDouble(2),
		};

		for (Complex c : cs) {
			System.out.println(c);
		}

		System.out.println(Complex.fromDouble(1).multiply(Complex.I));
	}
}
