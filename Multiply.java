package proj4;

/**
 * MULTIPLY CLASS
 * An operator that is handle a certain way to convert from infix to postfix notation
 * @author Jordan An
 * @version 05/28/2020
 */
public class Multiply implements Operator{
    private final int PRECEDENCE = 2;


    /** Processes the current token.  Since every token will handle
     *  itself in its own way, handling may involve pushing or
     *  popping from the given stack and/or appending more tokens
     *  to the output string.
     *
     *  @param s the Stack the token uses, if necessary, when processing itself.
     *  @return String to be appended to the output
     */
    public String handle(Stack<Token> s){
        Token topStack = s.peek();
        String ans = "";
        while (!s.isEmpty() && !(topStack instanceof LeftParen) && ((Operator) topStack).getPrecedence() >= this.getPrecedence() ){
            Token tempToken = s.pop();
            ans += tempToken.toString();

            topStack = s.peek();
        }
        s.push(this);

        return ans;
    }


    /** Returns the token as a printable String
     *
     *  @return the String version of the token.
     */
    public String toString(){
        return "*";
    }


    /**
     * Return the value of operator's precedence
     * @return the operator precedence
     */
    public int getPrecedence() {
        return PRECEDENCE;
    }
}
