public class ComplexTester {
	public static void main(String[] args) {
		Complex[] cs = {
				Complex.fromRect(1, 2),
				Complex.fromPolar(1, 45),
				Complex.fromDouble(2)
		};

		for (Complex c : cs) {
			System.out.println(c);
		}
	}
}
