/**
 * Represents a number of the form a+bi
 */
public class Complex {
	private double realPart;
	private double imaginaryPart;
	private double magnitude;
	private double angle;

	/**
	 * Represents a complex number. This constructor is never used because conflicts with the parameters could occur.
	 * Instead, static helper functions are used to create new <code>Complex</code> objects.
	 * @param realPart The real part of the complex number
	 * @param imaginaryPart The imaginary part of the complex number
	 * @param magnitude The magnitude of the complex number's vector on the complex plane
	 * @param angle The angle that the complex number's vector makes with the positive real axis on the complex plane
	 *              in degrees.
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
	 *              in degrees
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

	public Complex add(Complex c) {
		return Complex.fromRect(
				this.realPart + c.realPart,
				this.imaginaryPart + c.imaginaryPart
		);
	}

	public Complex multiply(Complex c) {
		return Complex.fromRect(
				(this.realPart * c.realPart) - (this.imaginaryPart * c.imaginaryPart),
				(this.realPart * c.imaginaryPart) + (c.realPart - c.imaginaryPart)
		);
	}

	public Complex subtract(Complex c) {
		return this.add(c.multiply(Complex.fromDouble(-1)));
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
