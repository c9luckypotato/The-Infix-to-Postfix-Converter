package proj4;

/**
 *  STACK CLASS (5/28/2020)
 *  * Stack are ADT to store data. Items store in this structure follow the rule Last in First out. In this version, we will implement a linked list.
 *  * @author Quoc (Jordan) An
 *  * @version 1
 *  * I affirm that I have carried out the attached academic endeavors with full academic honesty, in
 *  * accordance with the Union College Honor Code and the course syllabus.
 */
public class Stack<T>
{
    private final int INIT_CAPACITY = 10;
    private LinkedList content;
    private int size;
    private int capacity;

    /**
     * Create an empty Stack
     */
    public Stack() {
        this.content = new LinkedList();
        capacity = INIT_CAPACITY;
        size = 0;
    }

    /**
     * Get the capacity of the stack
     * @return the capacity of the stack
     */
    public int getCapacity(){
        return capacity;
    }

    /**
     * Increase the sequence's capacity to be
     * at least minCapacity.  Does nothing
     * if current capacity is already >= minCapacity.
     *
     * @param minCapacity the minimum capacity that the stack
     * should now have.
     */
    public void ensureCapacity(int minCapacity)
    {
        if (this.capacity < minCapacity){
            capacity = minCapacity;
        }
    }


    /**
     * Check if the stack is empty
     * @return true if the stack is empty, false if not
     */
    public boolean isEmpty() {
        return content.isEmpty();
    }


    /**
     * Push an item to the stack
     * @param toPush the item
     */
    public void push(T toPush) {
        ensureCapacity(size+1);
        content.insertAtHead(toPush);
        size++;
    }

    /**
     * Remove the item at the top of the stack
     * @return The item at the top of the stack
     */
    public T pop() {
        if(!this.isEmpty()) {
            T ans = (T) content.removeHead();
            size--;
            return ans;
        }
        return null;
    }


    /**
     * See the item at the top of the stack
     * @return The item at the top of the stack
     */
    public T peek(){
        if(!this.isEmpty()) {
            // I don't like that it is passing around an object that people can mess with, but I dont know how to not do this. Do we make a copy? That doesnt seem possible.
            T ans = (T) content.search(0);
            return ans;
        }
        return null;
    }


    /**
     * Get the size of the stack
     * @return The size of the stack
     */
    public int size() {
    	return content.getLength();    //erase this line
    }


    /**
     * String representation of the stack
     * @returnString representation of the stack
     */
    public String toString() {
        return "{>" + content.toString() + "}";    //erase this line
    }
    
} 
   

