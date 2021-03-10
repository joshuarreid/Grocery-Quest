package controller;
import javafx.scene.image.ImageView;

import java.util.*;

/**
 * Class for level randomizer methods
 *
 *
 */
public class levelRandomizer {
    private Stack<ImageView> layouts;

    /**
     * Constructor Method
     *
     * this method takes a list of layouts, shuffles them
     * and puts them into the stack.
     *
     * @param layouts
     */
    public levelRandomizer(List<ImageView> layouts) {
        //Randomize the level layouts list
        Collections.shuffle(layouts);

        //Add the level layouts to the stack
        for (ImageView item: layouts) {
            this.layouts.add(item);
        }
    }

    /**
     * This method fetches level layouts from
     * the stack
     *
     * @return
     */
    public ImageView getLayout() {
        if (layouts.size() == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        return layouts.pop();
    }


}
