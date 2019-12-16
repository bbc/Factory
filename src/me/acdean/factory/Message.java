package me.acdean.factory;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PShape;

public class Message {

    Logger logger = LoggerFactory.getLogger(Message.class);

    public static final int INACTIVE = 999;
    private static final float STEPS = 100.0f;
    private static final float DECAL_DEPTH = 50.0f;
    private static final float SIZE = 75.0f;

    // types
    public static final int GENERIC     = 0;
    public static final int CLIP        = 1;
    public static final int AUDIO       = 2;
    public static final int PROXY       = 3;
    public static final int SUBTITLE    = 4;
    public static final int VIDEO       = 5;
    public static final int TYPES       = 6;    // count of the above

    PApplet p;
    Factory factory;
    public int type;
    int state;
    int count;  // count can be negative - won't show
    Route route;
    PImage img;
    Map<String, String> properties = new HashMap<>();
    float x, y;
    float rx, ry, dx, dy;
    static PShape[] shapes = null;

    public Message(Factory factory, String routeName) {
        logger.debug("Message Name", routeName);
        this.factory = factory;
        p = factory.p;
        Route routeIn = factory.routes.get(routeName);
        logger.debug("Message Name", routeName, "RouteIn", routeIn);
        this.route = routeIn;
        this.type(GENERIC);
        init();
    }
    public Message(Factory factory, Route route) {
        this.factory = factory;
        p = factory.p;
        this.route = route;
        this.type(GENERIC);
        init();
    }
    final void init() {
        logger.info("Message init");
        rx = p.random(PConstants.TWO_PI);
        ry = p.random(PConstants.TWO_PI);
        dx = p.random(-.04f, .04f);
        dy = p.random(-.04f, .04f);
        if (shapes == null) {
            shapes = new PShape[TYPES];
            for (int i = 0 ; i < TYPES ; i++) {
                shapes[i] = p.createShape(PConstants.BOX, SIZE);
                shapes[i].setTextureMode(PConstants.IMAGE);
                switch(i) {
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
                shapes[i].setTexture(img);
            }
        }
        logger.info("Message init done");
    }

    // add a delay to a message
    public Message type(int type) {
        this.type = type;
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
            rx += dx;
            ry += dy;
            x = route.x(count / STEPS);
            y = route.y(count / STEPS);
            p.pushMatrix();
            p.translate(x, y, DECAL_DEPTH);
            p.rotateX(rx);
            p.rotateY(ry);
            p.shape(shapes[type]);
            p.popMatrix();
        }
    }

    void tick() {
        if (count != INACTIVE) {
            if (count < STEPS) {
                count++;
            } else {
                // add the message to the destination component's queue
                logger.debug("Adding [{}] to [{}]", this, route.end);
                factory.components.get(route.end).incoming.add(this);
                // mark as inactive
                count = INACTIVE;
            }
        }
    }

    public class Property {
        // common properties
        public static final String SOURCE           = "Source";
        public static final String DESTINATION      = "Destination";
        public static final String ENCODER          = "Encoder";
        public static final String SUBTITLE_HANDLER = "SubtitleHandler";
        public static final String GTI_BUNDLE       = "GtiBundle";
        public static final String WORKFLOW_SOURCE  = "WorkflowSource";
        public static final String BALHAM_CUSTOMER  = "BalhamCustomer";
    }

    @Override
    public String toString() {
        return String.format("Message: Route [%s] Count [%d]", this.route, this.count);
    }
}
