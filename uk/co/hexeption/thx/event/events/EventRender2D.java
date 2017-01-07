package uk.co.hexeption.thx.event.events;

import uk.co.hexeption.thx.event.Event;

/**
 * Created by Hexeption on 07/01/2017.
 */
public class EventRender2D extends Event {

    public int width, height;

    public EventRender2D(int width, int height) {

        this.width = width;
        this.height = height;
    }

    public int getWidth() {

        return width;
    }

    public void setWidth(int width) {

        this.width = width;
    }

    public int getHeight() {

        return height;
    }

    public void setHeight(int height) {

        this.height = height;
    }
}
