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
    private Stack<Background> layouts;

    /**
     * Constructor Method
     *
     * this method takes a list of layouts, shuffles them
     * and puts them into the stack.
     *
     */
    public LevelRandomizer() {
        //Color Options
        String[] backgroundColors = new String[] {
                "Color1",
                "Color2",
                "Color3",
                "Color4",
                "Color5",
                "Color6",
                "Color7",
                "Color8"
        };
        //Adding background objects to stack
        for (String color: backgroundColors) {
            layouts.add(new Background(new BackgroundFill((Paint.valueOf(color)), CornerRadii.EMPTY, Insets.EMPTY)));
        }

        //Randomize the level layouts list
        Collections.shuffle(layouts);

        //Add the level layouts to the stack
        for (Background item: layouts) {
            this.layouts.add(item);
        }
    }

    /**
     * This method fetches level layouts from
     * the stack
     *
     * @return layout
     */
    public Background getLayout() {
        if (layouts.size() == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        return layouts.pop();
    }


}
