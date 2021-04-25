package model;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Class for level randomizer methods
 *
 *
 */
public class LevelRandomizer {
    private Stack<String> layouts;

    /**
     * Constructor Method
     *
     * this method takes a list of layouts, shuffles them
     * and puts them into the stack.
     *
     */
    public LevelRandomizer() {
        //Color Options
        layouts = new Stack<>();
        String[] backgroundColors = new String[] {
            "#A0D3B2",
            "#FFC752",
            "#C75E44",
            "#00A8B0",
            "#7FAB50",
            "#334458",
            "#CECDCD",
            "#52AA83",
            "#7e7ee0",
            "#cbc0d3",
            "#fcd5ce",
            "#9fc7ff",
            "#1d81cb",
            "#c29a59",
            "#798aa7",
            "#f4c450"

        };
        //Adding background objects to stack
        for (String color: backgroundColors) {
            layouts.add(color);
        }

        //Randomize the level layouts list
        Collections.shuffle(layouts);

    }

    /**
     * This method fetches level layouts from
     * the stack
     *
     * @return layout
     */
    public String getLayout() {
        if (layouts.size() == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        return layouts.pop();
    }


}
