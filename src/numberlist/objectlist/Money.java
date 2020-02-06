package numberlist.objectlist;

/**
 * This class represents a single monetary value in U.S. dollars and cents.
 *
 * @author Dustin Sumarli
 * @version 1.0
 */
public final class Money {

    //fields
    private long dollars;
    private byte cents;

    /**
     * Default constructor. Creates a new Money object. Sets both dollars and
     * cents to zero.
     */
    public Money() {
        dollars = 0;
        cents = 0;
    }

    /**
     * Full constructor. Creates a new Money object. Dollars and cents are
     * normalized. If one is negative and the other is positive, the resulting
     * object will be the natural addition of the two values. (Example: 2
     * dollars and -5 cents is converted to 1 dollar and 95 cents.) If the
     * absolute value of cents is greater than 99, the resulting object will
     * carry the extra cents into the dollars. (Example: 1 dollar and 105 cents
     * is converted to 2 dollars and 5 cents.) A negative value is represented
     * with both the dollars and cents negative.
     *
     * @param dollars the number of dollars in the amount
     * @param cents the number of cents in the amount
     */
    public Money(long dollars, byte cents) {
        long value = dollars * 100;
        value += cents;
        this.dollars = value / 100;
        this.cents = (byte) (value % 100);
    }

    /**
     * Provides access to the dollars portion of the monetary value.
     *
     * @return the dollars portion of this Money object
     */
    public long getDollars() {
        return dollars;
    }

    /**
     * Provides access to the cents portion of the monetary value.
     *
     * @return the cents portion of this Money object
     */
    public byte getCents() {
        return cents;
    }

    /**
     * Adds the current and the given Money objects together, and stores the sum
     * in a new Money object. The current and given Money objects are not
     * altered in the process. The resulting Money object's dollars and cents
     * are normalized as defined in the full constructor comments.
     *
     * @param other the other Money object to add to this one
     * @return the Money object containing the results of this addition
     */
    public Money add(Money other) {
        long value = dollars * 100;
        value += cents;
        long oValue = other.dollars * 100;
        oValue += other.cents;
        long result = value + oValue;
        return new Money(result / 100, (byte) (result % 100));
    }

    /**
     * Subtracts the given Money object from this one, and stores the result in
     * a new Money object. The current and given Money objects are not altered
     * in the process. The resulting Money object's dollars and cents are
     * normalized as defined in the full constructor comments.
     *
     * @param other the other Money object to subtract from this one
     * @return the Money object containing the results of this subtraction
     */
    public Money subtract(Money other) {
        long value = dollars * 100;
        value += cents;
        long oValue = other.dollars * 100;
        oValue += other.cents;
        long result = value - oValue;
        return new Money(result / 100, (byte) (result % 100));
    }

    /**
     * Provides a string representation of the current Money object, in the form
     * $mm.mm. Negative values have a minus sign before the dollar sign. Zero
     * dollar amounts are represented with one zero between the dollar sign and
     * the decimal point. Cents that are multiples of 10 still show two decimal
     * places. (Examples: $12.34, -$6.50, $0.99, -$0.99, $0.00)
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        long total = (dollars * 100) + cents;
        if (total < 0) {
            return "-$" + (total / -100) + "." + -(total % 100);
        } else if (total == 0) {
            return "$0.00";
        } else {
            if ((total % 100) < 10) {
                return "$" + (total / 100) + ".0" + (total % 100);
            } else {
                return "$" + (total / 100) + "." + (total % 100);
            }
        }
    }
}
