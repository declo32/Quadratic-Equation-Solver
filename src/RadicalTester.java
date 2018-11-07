public class RadicalTester {
	public static void main(String[] args) {
		Radical[] radicals = {
				new Radical(Complex.ZERO, Complex.fromDouble(1), 8, true),
				new Radical(Complex.ZERO, Complex.fromDouble(1), 8, false),
				new Radical(Complex.ZERO, Complex.fromDouble(1), -1, true),
				new Radical(Complex.ZERO, Complex.fromDouble(1), 4, true)
		};

		for (Radical radical : radicals) {
			System.out.println(radical);
		}
	}
}
