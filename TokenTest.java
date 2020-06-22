package proj4;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 *
 * Write a description of class TokenTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 *
 */
public class TokenTest {
    @Rule
    public Timeout timeout = Timeout.millis(100);

    private Stack<Operator> stack;

    private Stack<Token> stack2;

    @Before
    public void setUp() throws Exception {
        stack = new Stack<Operator>();
        stack2 = new Stack<Token>();
    }

    @After
    public void tearDown() throws Exception {
        stack = null;
        stack2 = null;
    }

    @Test
    public void testDivideOpContruct(){
        Divide d = new Divide();
        stack.push(d);
        stack2.push(d);
        LeftParen m = new LeftParen();
        stack2.push(m);
    }

    @Test
    public void testMultiplyOpContruct(){
        Multiply d = new Multiply();
        stack.push(d);
        stack2.push(d);
        LeftParen m = new LeftParen();
        stack2.push(m);
        assertEquals("{>*}", stack.toString());
        assertEquals("{>(, *}", stack2.toString());
    }

    @Test
    public void testLeftParenContruct(){
        LeftParen m = new LeftParen();
        stack2.push(m);
    }

    @Test
    public void testInstanceOf(){
        Token d = new Divide();
        LeftParen m = new LeftParen();
        assertEquals(true, m instanceof Token);
        assertEquals(false, m instanceof Operator);

        assertEquals(true, d instanceof Token);
        assertEquals(true, d instanceof Operator);

    }

    @Test
    public void testRightParenHandle(){
        stack2.push(new LeftParen());
        stack2.push(new Plus());
        stack2.push(new Multiply());
        stack2.push(new LeftParen());
        stack2.push(new Minus());
        assertEquals("{>-, (, *, +, (}", stack2.toString());
        RightParen rP = new RightParen();
        String s = rP.handle(stack2);
        assertEquals("-", s);
        assertEquals("{>*, +, (}", stack2.toString());
        s = rP.handle(stack2);
        assertEquals("*+", s);
        assertEquals("{>}", stack2.toString());
    }

    @Test
    public void testSemiColon(){
        Semicolon sC = new Semicolon();
        String s = sC.handle(stack2);
        assertEquals("{>}", stack2.toString());
        assertEquals("", s);
        stack2.push(new Divide());
        assertEquals("{>/}", stack2.toString());
        s = sC.handle(stack2);
        assertEquals("{>}", stack2.toString());
        assertEquals("/", s);
    }

    @Test
    public void testMulitply(){
        Multiply m = new Multiply();
        stack2.push(new LeftParen());
        stack2.push(new Plus());
        String s = m.handle(stack2);
        assertEquals("", s);
        assertEquals("{>*, +, (}", stack2.toString());
    }
}
