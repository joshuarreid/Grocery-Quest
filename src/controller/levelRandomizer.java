package controller;
import java.util.*;

/**
 * Mock class for developing level randomizer methods
 *
 * @param <T> the object holding the level layout
 */
public class levelRandomizer<T> {
    private Stack<T> layouts;

    /**
     * Constructor Method
     *
     * this method takes a list of layouts, shuffles them
     * and puts them into the stack.
     *
     * @param layouts
     */
    public levelRandomizer(List<T> layouts) {
        //Randomize the level layouts list
        Collections.shuffle(layouts);

        //Add the level layouts to the stack
        for (T item: layouts) {
            this.layouts.add(item);
        }
    }

    /**
     * This method fetches level layouts from
     * the stack
     *
     * @return
     */
    public T getLayout() {
        if (layouts.size() == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        return layouts.pop();
    }


}
