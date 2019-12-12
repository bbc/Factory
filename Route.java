package me.acdean.factory;

// basically a bezier curve

public class Route {

    private static final int CONTROL_OFFSET = 200;
    private static final int DECAL_DEPTH = -10;
    
    public static final int NORMAL = 0;
    public static final int LOOP_BACK = 1;
    public static final int LOOP_FORWARD = 2;

    Factory factory;
    String name;
    int type = NORMAL;
    String start, end;  // components
    float x0, y0;
    float x1, y1;
    float x2, y2;
    float x3, y3;

    Route(Factory factory, String start, String end) {
        this.factory = factory;
        this.start = start;
        this.end = end;
        name = routeName(start, end);
        coords();
    }

    final void coords() {
        Component startC = factory.components.get(start);
        Component endC = factory.components.get(end);
        this.x0 = startC.x;
        this.y0 = startC.y;
        switch(type) {
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

    float x(float count) {
        return factory.p.bezierPoint(x0, x1, x2, x3, count);
    }

    float y(float count) {
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

    void draw() {
        factory.p.noFill();
        factory.p.stroke(0, 255, 0);
        factory.p.strokeWeight(2);
        factory.p.bezier(x0, y0, DECAL_DEPTH, x1, y1, DECAL_DEPTH, x2, y2, DECAL_DEPTH, x3, y3, DECAL_DEPTH);
    }

    @Override
    public String toString() {
        return String.format("From [%s] To [%s] Type [%d]", start, end, type);
    }
}
