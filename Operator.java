package proj4;

/**
 * OPERATOR IS AN EXTENSION OF TOKEN
 * Describes the methods that must be defined in order for a Token to be considered a Operator that.  Every operator must be able to show its precedence.
 *
 * @author Jordan An
 * @version 05/28/2020
 *
 */
public interface Operator extends Token{

    /**
     * Return the value of operator's precedence
     * @return the operator precedence
     */
    public int getPrecedence();
}
