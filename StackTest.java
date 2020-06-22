package proj4;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * 
 * Write a description of class StackTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 *
 */
public class StackTest {

	@Rule
    public Timeout timeout = Timeout.millis(100);
	
    private Stack<String> stack;

    private Stack<Token> stack2;
    
    @Before
    public void setUp() throws Exception {
        stack = new Stack<String>();
        stack2 = new Stack<Token>();
    }

    @After
    public void tearDown() throws Exception {
        stack = null;
        stack2 = null;
    }

    @Test
    public void testStackConstructor_toString () {
        assertEquals ("An empty stack. (> indicates the top of the stack)", "{>}", stack.toString());
    }
    
    @Test
    public void testStackPushOneOntoEmptyStack () {
        stack.push("A");
        assertEquals ("Pushing A onto an empty stack.", "{>A}", stack.toString().replaceAll("[ ]+", ""));
        assertEquals(1, stack.size());
    }
    
    @Test
    public void testStackPushTwoOntoEmptyStack () {
        stack.push("A");
        stack.push("B");
        assertEquals ("Pushing first A and then B onto an empty stack.", "{>B,A}", stack.toString().replaceAll("[ ]+", ""));
    }
    
    @Test
    public void testStackPushThreeOntoEmptyStack () {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals ("Pushing first A, then B, then C onto an empty stack.", "{>C,B,A}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPop(){
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals("C", stack.pop());
        assertEquals("{>B, A}", stack.toString());
        assertEquals(2, stack.size());
    }

    @Test
    public void testStackpeek(){
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals("C", stack.peek());
        assertEquals("{>C, B, A}", stack.toString());
        assertEquals(3, stack.size());
    }

    @Test
    public void testisEmpty(){
        assertEquals(true, stack.isEmpty());
        stack.push("A");
        assertEquals(false, stack.isEmpty());
    }

    @Test
    public void testPop(){
        stack.push("A");
        assertEquals("A", stack.pop());
        assertEquals("{>}", stack.toString());
    }

    @Test
    public void testPopToken(){
        stack2.push(new Divide());
        assertEquals("{>/}", stack2.toString());
        Token t = stack2.pop();
        assertEquals("/", t.toString());
        assertEquals("{>}", stack2.toString());

    }

}