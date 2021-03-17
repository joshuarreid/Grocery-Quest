package controller;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.*;

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
                "#52AA83"
        };
        //Adding background objects to stack
        for (String color: backgroundColors) {
            System.out.println(Paint.valueOf(color));
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
