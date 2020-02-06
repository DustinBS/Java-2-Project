package numberlist.objectlist;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * This class represents a single complex number of the form x + yi.
 *
 * @author Dustin Sumarli
 * @version 1.0
 */
public final class Complex {

    //fields
    private double real;
    private double imaginary;

    /**
     * Default constructor. Creates a new Complex object. Sets both real and
     * imaginary to zero.
     */
    public Complex() {
        real = 0;
        imaginary = 0;
    }

    /**
     * Full constructor. Creates a new Complex object.
     *
     * @param real the value of the real portion of the complex number
     * @param imaginary the value of the imaginary portion of the complex number
     */
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Provides access to the real portion of the complex number
     *
     * @return the value of the real portion of the complex number
     */
    public double getReal() {
        return real;
    }

    /**
     * Provides access to the imaginary portion of the complex number
     *
     * @return the value of the imaginary portion of the complex number
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * Adds the current and the given complex numbers together, and stores the
     * sum in a new Complex object. The current and given complex numbers are
     * not altered in the process.
     *
     * @param other the other complex number to add to this one
     * @return the new Complex object that holds the result of the addition
     */
    public Complex add(Complex other) {
        Complex result = new Complex();
        result.real = this.real + other.real;
        result.imaginary = this.imaginary + other.imaginary;
        return result; //replace this return statement
    }

    /**
     * Subtracts the other complex number from this one, and stores the result
     * in a new Complex object. The current and given complex numbers are not
     * altered in the process.
     *
     * @param other the other complex number to subtract from this one
     * @return the new Complex object that holds the result of the subtraction
     */
    public Complex subtract(Complex other) {
        Complex result = new Complex();
        result.real = this.real - other.real;
        result.imaginary = this.imaginary - other.imaginary;
        return result; //replace this return statement
    }

    /**
     * Provides a string representation of the current complex number, in the
     * form x + yi.
     *
     * @return the string representation of the current complex number
     */
    @Override
    public String toString() {
        BigDecimal bd = new BigDecimal(real);
        bd = bd.round(new MathContext(2));
        real = bd.doubleValue();
        bd = new BigDecimal(imaginary);
        bd = bd.round(new MathContext(2));
        imaginary = bd.doubleValue();
        if (imaginary == 0) {
            return real + "";
        }
        if (real == 0) {
            return imaginary + "i";
        }
        if (imaginary < 0) {
            return real + " - " + (-imaginary) + "i";
        }
        return real + " + " + imaginary + "i";
    }

}
