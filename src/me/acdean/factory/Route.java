package me.acdean.factory;

// basically a bezier curve

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import processing.core.PApplet;
import processing.core.PShape;

public class Route {

    private static final Logger logger = LoggerFactory.getLogger(Route.class);

    private static final int CONTROL_OFFSET = 200;
    private static final int DECAL_DEPTH = -10;
    
    public static final int LINEAR = 0;
    public static final int BEZIER = 1;
    public static final int LOOP_BACK = 2;
    public static final int LOOP_FORWARD = 3;

    Factory factory;
    String name;
    int type = BEZIER;
    String start, end;  // components
    float x0, y0;
    float x1, y1;
    float x2, y2;
    float x3, y3;
    PApplet p;

    Route(Factory factory, String start, String end) {
        this.factory = factory;
        this.start = start;
        this.end = end;
        this.p = factory.p;
        name = routeName(start, end);
        coords();
    }

    final void coords() {
        Component startC = factory.components.get(start);
        Component endC = factory.components.get(end);
        this.x0 = startC.x;
        this.y0 = startC.y;
        if (startC.y == endC.y) {
            // this is just a straight line
            type = LINEAR;
        }
        switch(type) {
            case LINEAR:
                // just a straight line - no need for control points
                break;
            case LOOP_BACK: // out the front, in the front
                this.x1 = startC.x + CONTROL_OFFSET / 2;
                this.y1 = startC.y;
                this.x2 = endC.x + CONTROL_OFFSET / 2;
                this.y2 = endC.y;
                break;
            case LOOP_FORWARD:  // out the back, in the back
                this.x1 = startC.x - CONTROL_OFFSET / 2;
                this.y1 = startC.y;
                this.x2 = endC.x - CONTROL_OFFSET / 2;
                this.y2 = endC.y;
                break;
            default:
                this.x1 = startC.x + CONTROL_OFFSET;
                this.y1 = startC.y;
                this.x2 = endC.x - CONTROL_OFFSET;
                this.y2 = endC.y;
        }
        this.x3 = endC.x;
        this.y3 = endC.y;
    }

    // count is 0 - 1, position along the route
    float x(float count) {
        if (type == LINEAR) {
            // just lerp between x0 and x3
            return PApplet.lerp(x0, x3, count);
        }
        return factory.p.bezierPoint(x0, x1, x2, x3, count);
    }

    // count is 0 - 1, position along the route
    float y(float count) {
        if (type == LINEAR) {
            // single value regardless of position
            return this.y0;
        }
        return factory.p.bezierPoint(y0, y1, y2, y3, count);
    }

    public static String routeName(String start, String end) {
        return start + "_" + end;
    }

    public Route type(int type) {
        this.type = type;
        // recalculate coords based on new type
        coords();
        return this;
    }

    // create a shape for this route
    PShape draw(PShape shape) {
        if (type == LINEAR) {
            // this is just a line so just add two vertices to the passed-in LINES shape
            shape.vertex(x0, y0, DECAL_DEPTH);
            shape.vertex(x3, y3, DECAL_DEPTH);
            // and don't return a new shape
            return null;
        } else {
            // bezier, so create and return a new shape
            PShape s = p.createShape();
            s.beginShape();
            s.noFill();
            s.strokeWeight(2);
            s.stroke(0, 255, 0);
            s.vertex(x0, y0, DECAL_DEPTH);
            s.bezierVertex(x1, y1, DECAL_DEPTH, x2, y2, DECAL_DEPTH, x3, y3, DECAL_DEPTH);
            s.endShape();
            return s;
        }
    }

    @Override
    public String toString() {
        return String.format("From [%s] To [%s] Type [%d]", start, end, type);
    }
}
