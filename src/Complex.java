import java.util.Objects;

/**
 * Represents a number of the form a+bi
 */
public class Complex {
	private double realPart;
	private double imaginaryPart;
	private double magnitude;
	private double angle;

	/**
	 * The imaginary unit, very common
	 */
	public static final Complex I = new Complex(0, 1, 1, Math.PI/2);

	/**
	 * An imaginary number with magnitude of zero
	 */
	public static final Complex ZERO = new Complex(0, 0, 0, 0);

	/**
	 * Represents a complex number. This constructor is never used because conflicts with the parameters could occur.
	 * Instead, static helper functions are used to create new <code>Complex</code> objects.
	 * @param realPart The real part of the complex number
	 * @param imaginaryPart The imaginary part of the complex number
	 * @param magnitude The magnitude of the complex number's vector on the complex plane
	 * @param angle The angle that the complex number's vector makes with the positive real axis on the complex plane
	 *              in radians.
	 */
	private Complex(double realPart, double imaginaryPart, double magnitude, double angle) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
		this.magnitude = magnitude;
		this.angle = angle;
	}

	/**
	 * Creates a new <code>Complex</code> object from rectangular coordinates on the complex plane.
	 * @param realPart The real part of the complex number
	 * @param imaginaryPart The imaginary part of the complex number
	 * @return A new <code>Complex</code> object representing a complex number with the specified components
	 */
	public static Complex fromRect(double realPart, double imaginaryPart) {
		return new Complex(
				realPart,
				imaginaryPart,
				Math.sqrt(Math.pow(realPart, 2) + Math.pow(imaginaryPart, 2)),
				Math.atan(imaginaryPart / realPart)
		);
	}

	/**
	 * Creates a new <code>Complex</code> object from polar coordinates on the complex plane.
	 * @param magnitude The magnitude of the complex number's vector on the complex plane
	 * @param angle The angle that the complex number's vector makes with the positive real axis on the complex plane
	 *              in radians
	 * @return A new <code>Complex</code> object representing a complex number with the specified components
	 */
	public static Complex fromPolar(double magnitude, double angle) {
		return new Complex(
				Math.cos(angle),
				Math.sin(angle),
				magnitude,
				angle
		);
	}

	/**
	 * Creates a new <code>Complex</code> object with no imaginary part.
	 * @param realPart The real part of the complex number
	 * @return A new <code>Complex</code> object representing a complex number with the specified component
	 */
	public static Complex fromDouble(double realPart) {
		return new Complex(realPart, 0, realPart, 0);
	}

	/**
	 * Get the real part of the complex number represented by this <code>Complex</code> object.
	 * @return The real part of the complex number represented by this <code>Complex</code> object
	 */
	public double getRealPart() {
		return realPart;
	}

	/**
	 * Get the imaginary part of the complex number represented by this <code>Complex</code> object.
	 * @return The real part of the complex number represented by this <code>Complex</code> object
	 */
	public double getImaginaryPart() {
		return imaginaryPart;
	}

	/**
	 * Get the real part of the complex number represented by this <code>Complex</code> object.
	 * @return The magnitude of the vector of the complex number represented by this <code>Complex</code> object
	 * on the complex plane
	 */
	public double getMagnitude() {
		return magnitude;
	}

	/**
	 * Get the real part of the complex number represented by this <code>Complex</code> object.
	 * @return The angle with the positive real axis made by the vector of the complex number represented by this
	 * <code>Complex</code> object on the complex plane
	 */
	public double getAngle() {
		return angle;
	}

	/**
	 * Get the conjugate of the complex number represented by this <code>Complex</code> object. If the number is
	 * a+bi, this returns a-bi.
	 * @return The conjugate of the complex number represented by this <code>Complex</code> object
	 */
	public Complex getConjugate() {
		return Complex.fromRect(realPart, -imaginaryPart);
	}

	/**
	 * Returns a string representation of the <code>Complex</code> object.
	 * @return a string representation of the <code>Complex</code> object
	 */
	@Override
	public String toString() {
		return "Complex{" +
				"realPart=" + realPart +
				", imaginaryPart=" + imaginaryPart +
				", magnitude=" + magnitude +
				", angle=" + angle +
				'}';
	}

	/**
	 * Compares this <code>Complex</code> object to another. Returns true if the objects' components match.
	 * @param o The other object to compare this <code>Complex</code> object to
	 * @return Whether or not the two objects' components match
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Complex complex = (Complex) o;
		return Double.compare(complex.getRealPart(), getRealPart()) == 0 &&
				Double.compare(complex.getImaginaryPart(), getImaginaryPart()) == 0 &&
				Double.compare(complex.getMagnitude(), getMagnitude()) == 0 &&
				Double.compare(complex.getAngle(), getAngle()) == 0;
	}

	public Complex add(Complex c) {
		return Complex.fromRect(
				this.realPart + c.realPart,
				this.imaginaryPart + c.imaginaryPart
		);
	}

	public Complex subtract(Complex c) {
		return this.add(c.multiply(Complex.fromDouble(-1)));
	}

	public Complex multiply(Complex c) {
		return Complex.fromRect(
				(this.realPart * c.realPart) - (this.imaginaryPart * c.imaginaryPart),
				(this.realPart * c.imaginaryPart) + (c.realPart * c.imaginaryPart)
		);
	}

	public Complex divide(Complex c) {
		Complex numerator = this.multiply(c.getConjugate());
		Complex denominator = c.multiply(c.getConjugate());  // will always have no imaginary part

		return Complex.fromRect(
				numerator.realPart / denominator.realPart,
				numerator.imaginaryPart / denominator.realPart
		);
	}
}
