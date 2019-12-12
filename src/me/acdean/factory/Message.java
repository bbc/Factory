package me.acdean.factory;

import java.util.HashMap;
import java.util.Map;
import static processing.core.PApplet.println;
import processing.core.PImage;

public class Message {

    public static final int INACTIVE = 999;
    private static final float STEPS = 100.0f;
    private static final float DECAL_DEPTH = 2.0f;

    // types
    public static final int GENERIC     = 0;
    public static final int CLIP        = 1;
    public static final int AUDIO       = 2;
    public static final int PROXY       = 3;
    public static final int SUBTITLE    = 4;
    public static final int VIDEO       = 5;

    Factory factory;
    int type;
    int state;
    int count;  // count can be negative - won't show
    Route route;
    PImage img;
    Map<String, String> properties = new HashMap<>();
    float x, y;

    public Message(Factory factory, String routeName) {
        println("Message Name", routeName);
        this.factory = factory;
        Route routeIn = factory.routes.get(routeName);
        println("Message Name", routeName, "RouteIn", routeIn);
        this.route = routeIn;
        this.type(GENERIC);
    }
    public Message(Factory factory, Route route) {
        this.factory = factory;
        this.route = route;
        this.type(GENERIC);
    }

    // add a delay to a message
    public Message type(int type) {
        this.type = type;
        switch(type) {
            case GENERIC:
                img = factory.messageImg;
                break;
            case CLIP:
                img = factory.clipImg;
                break;
            case AUDIO:
                img = factory.audioImg;
                break;
            case VIDEO:
                img = factory.videoImg;
                break;
            case PROXY:
                img = factory.proxyImg;
                break;
            case SUBTITLE:
                img = factory.subtitleImg;
                break;
        }
        return this;
    }

    // add a delay to a message
    public Message delay(int ticks) {
        count = -ticks;
        return this;
    }

    // set a property
    public Message property(String name, String value) {
        properties.put(name, value);
        return this;
    }

    public Message route(String routeName) {
        this.route = factory.routes.get(routeName);
        count = 0;
        return this;
    }

    public Message route(String from, String to) {
        return this.route(Route.routeName(from, to));
    }

    // use current end as new start
    public Message routeTo(String to) {
        return this.route(this.route.end, to);
    }

    // get a property
    public String property(String name) {
        return properties.get(name);
    }

    void draw() {
        if (count > 0 && count != INACTIVE) {
            x = route.x(count / STEPS);
            y = route.y(count / STEPS);
            factory.p.image(img, x, y);
        }
    }

    void tick() {
        if (count != INACTIVE) {
            if (count < STEPS) {
                count++;
            } else {
                // add the message to the destination component's queue
                println("Adding", this, "to", route.end);
                factory.components.get(route.end).incoming.add(this);
                // mark as inactive
                count = INACTIVE;
            }
        }
    }

    public class Property {
        // common properties
        public static final String SOURCE       = "Source";
        public static final String DESTINATION  = "Destination";
        public static final String ENCODER      = "Encoder";
    }

    @Override
    public String toString() {
        return String.format("Message: Route [%s] Count [%d]", this.route, this.count);
    }
}
