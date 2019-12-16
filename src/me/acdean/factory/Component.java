package me.acdean.factory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PShape;

public class Component {

    private static final Logger logger = LoggerFactory.getLogger(Component.class);

    // component types
    public static final int EC2             = 0;
    public static final int LAMBDA          = 1;
    public static final int LOAD_BALANCER   = 2;
    public static final int BUCKET          = 3;
    public static final int CDN             = 4;
    public static final int INPUT           = 5;
    public static final int MYSQL_DB        = 6;
    public static final int DYNAMO_DB       = 7;
    public static final int BLACK_BOX       = 8;
    public static final int CONNECTOR       = 9;

    // size of component (size of images)
    public static final int WIDTH = 200;
    public static final int HEIGHT = 200;
    public static final int HWIDTH = WIDTH / 2;
    public static final int HHEIGHT = HEIGHT / 2;
    public static final int Z = 0;  // z depth of the images

    public Factory factory;
    public PApplet p;
    public List<String> inputs = new ArrayList<>();
    public List<String> outputs = new ArrayList<>();
    public Queue<Message> incoming = new ArrayDeque<>();    // waiting messages
    public Queue<Action> actions = new ArrayDeque<>();      // actions to do for current message
    public int type = EC2;
    public String name;
    public String description;
    public int x, y;  // position
    int colour;
    public Message currentMessage;
    // pshapes for arrows
    static PShape fatArrowIn, fatArrowOut, thinArrowIn, thinArrowOut;
    static PShape cogShape, pipsShape, mirShape, bucketShape;

    public Component(Factory factory, int x, int y, String name) {
        this.factory = factory;
        this.p = factory.p;
        this.x = x;
        this.y = y;
        this.name = name;

        // init first time around
        if (fatArrowIn == null) {
            logger.info("Create Arrows");
            fatArrowIn = createArrow(p, -BUCKET_DISTANCE, -BUCKET_DISTANCE, 0, 0, 50, 0xff00ff00);
            fatArrowOut = createArrow(p, 0, 0, BUCKET_DISTANCE, -BUCKET_DISTANCE, 50, 0xffff0000);
            thinArrowIn = createArrow(p, -BUCKET_DISTANCE, -BUCKET_DISTANCE, 0, 0, 10, 0xff00ff00);
            thinArrowOut = createArrow(p, 0, 0, BUCKET_DISTANCE, -BUCKET_DISTANCE, 10, 0xffff0000);
            logger.info("Create Quads");
            cogShape = createQuad(factory.cogsImg, BUCKET_SIZE);
            pipsShape = createQuad(factory.mysqlImg, BUCKET_SIZE);
            mirShape = createQuad(factory.dynamoImg, BUCKET_SIZE);
            bucketShape = createQuad(factory.bucketImg, BUCKET_SIZE);
        }
    }

    public final void addInput(String inputName) {
        inputs.add(inputName);
    }

    public final void setDescription(String desc) {
        description = desc;
    }

    // move to factory?
    public PShape draw(PShape unused) {
        // input is a special case
        if (type == INPUT) {
            PShape shape = p.createShape(PConstants.ELLIPSE, x, y, HHEIGHT, HHEIGHT);
            shape.setStrokeWeight(5);
            shape.setStroke(0xffff0000);
            shape.setFill(0xff000000);
            return shape;
        }
        if (type == CONNECTOR) {
            // nothing;
            return null;
        }
        // images
        PShape shape = p.createShape();
        shape.beginShape(PConstants.QUAD);
        shape.noStroke();
        shape.textureMode(PConstants.NORMAL);
        switch (type) {
            case LAMBDA:
                shape.texture(factory.lambdaImg);
                break;

            case DYNAMO_DB:
                shape.texture(factory.dynamoImg);
                break;

            case MYSQL_DB:
                shape.texture(factory.mysqlImg);
                break;

            case BLACK_BOX:
                shape.texture(factory.blackBoxImg);
//                // image is bigger to bodge this
//                textY += 50;
                break;

            default:    // box
                shape.texture(factory.ec2Img);
                break;
        }
        shape.vertex(x - HWIDTH, y - HHEIGHT, Z, 0, 0);
        shape.vertex(x + HWIDTH, y - HHEIGHT, Z, 1, 0);
        shape.vertex(x + HWIDTH, y + HHEIGHT, Z, 1, 1);
        shape.vertex(x - HWIDTH, y + HHEIGHT, Z, 0, 1);
        shape.endShape();

        return shape;
    }

    public void drawLabel() {
        if (type != CONNECTOR) {
            float textY = y + HEIGHT / 2 + 40;
            // INPUTs are smaller
            if (type == INPUT) {
                textY -= 20;
            }
            p.text(name, x, textY);
        }
    }

    private static final int BUCKET_DISTANCE = 150;
    private static final int BUCKET_SIZE = 150;
    public void tick() {
        if (actions.size() == 0) {
            // currently inactive so read next message
            if (incoming.size() != 0) {
                currentMessage = incoming.poll();
                // add actions for this message
                processMessage();
            }
        }
        // do next action
        if (actions.size() != 0) {
            Action action = actions.remove();
            switch (action.type) {
                case Action.PAUSE:
                    logger.debug("PAUSE");
                    break;
                case Action.READ_FROM_S3:
                    logger.debug("READ_FROM_S3");
                    p.pushMatrix();
                    p.translate(0, 0, 10);
                    drawQuad(bucketShape, x - BUCKET_DISTANCE, y - BUCKET_DISTANCE);
                    //p.image(factory.bucketImg, x - BUCKET_DISTANCE, y - BUCKET_DISTANCE, BUCKET_SIZE, BUCKET_SIZE);
                    p.translate(0, 0, 10);
                    drawArrow(fatArrowIn, x - BUCKET_DISTANCE, y - BUCKET_DISTANCE, x, y);
                    p.popMatrix();
                    break;
                case Action.WRITE_TO_S3:
                    logger.debug("WRITE_TO_S3");
                    p.pushMatrix();
                    p.translate(0, 0, 10);
                    drawQuad(bucketShape, x + BUCKET_DISTANCE, y - BUCKET_DISTANCE);
                    //p.image(factory.bucketImg, x + BUCKET_DISTANCE, y - BUCKET_DISTANCE, BUCKET_SIZE, BUCKET_SIZE);
                    p.translate(0, 0, 10);
                    drawArrow(fatArrowOut, x, y, x + BUCKET_DISTANCE, y - BUCKET_DISTANCE);
                    p.popMatrix();
                    break;
                case Action.READ_FROM_PIPS:
                    logger.debug("WRITE_FROM_PIPS");
                    p.pushMatrix();
                    p.translate(0, 0, 10);
                    drawQuad(pipsShape, x - BUCKET_DISTANCE, y - BUCKET_DISTANCE);
                    p.translate(0, 0, 10);
                    drawArrow(thinArrowIn, x - BUCKET_DISTANCE, y - BUCKET_DISTANCE, x, y);
                    p.popMatrix();
                    break;
                case Action.WRITE_TO_PIPS:
                    logger.debug("WRITE_TO_PIPS");
                    p.pushMatrix();
                    p.translate(0, 0, 10);
                    //drawQuad(pipsShape, x + BUCKET_DISTANCE, y - BUCKET_DISTANCE);
                    p.image(factory.mysqlImg, x + BUCKET_DISTANCE, y - BUCKET_DISTANCE, BUCKET_SIZE, BUCKET_SIZE);
                    p.translate(0, 0, 10);
                    drawArrow(thinArrowOut, x, y, x + BUCKET_DISTANCE, y - BUCKET_DISTANCE);
                    p.popMatrix();
                    break;
                case Action.WRITE_TO_MIR:
                    logger.debug("WRITE_TO_MIR");
                    p.pushMatrix();
                    p.translate(0, 0, 10);
                    //drawQuad(mirShape, x + BUCKET_DISTANCE, y - BUCKET_DISTANCE);
                    p.image(factory.dynamoImg, x + BUCKET_DISTANCE, y - BUCKET_DISTANCE, BUCKET_SIZE, BUCKET_SIZE);
                    p.translate(0, 0, 10);
                    drawArrow(thinArrowOut, x, y, x + BUCKET_DISTANCE, y - BUCKET_DISTANCE);
                    p.popMatrix();
                    break;
                case Action.WORK:
                    logger.debug("WORK");
                    p.pushMatrix();
                    p.translate(x, y, 10);
                    p.rotateZ(PApplet.radians(p.frameCount * 2));
                    //drawQuad(cogShape, 0, 0);
                    p.image(factory.cogsImg, 0, 0, 75, 75);
                    p.popMatrix();
                    break;
                case Action.EMIT:
                    logger.debug("EMIT");
                    emit();
                    break;
                case Action.SINK:
                    // eat the message
                    factory.messages.remove(currentMessage);
                    currentMessage = null;
                    logger.info("Eating message. New size {}", factory.messages.size());
                    break;
            }
        }
    }

    // add action to actions queue based on emssage type
    public void processMessage() {
        logger.debug("ProcessMessage");
        // example
//        add(Action.PAUSE, 5);
//        add(Action.READ_FROM_S3, 10);
//        add(Action.PAUSE, 5);
//        add(Action.READ_FROM_S3, 10);
//        add(Action.PAUSE, 5);
        addAction(Action.EMIT);
        logger.debug("Actions [{}]", actions.size());
    }

    public void addAction(int type) {
        addAction(type, 1);
    }
    public void addAction(int type, int count) {
        for (int i = 0 ; i < count ; i++) {
            actions.add(new Action(type));
        }
    }

    public void emit() {
        // if there's only one output we know where it's going
        if (outputs != null && outputs.size() == 1) {
            String queueName = this.name + "_" + outputs.get(0);
            logger.debug("QueueName [{}]", queueName);
            // change current message route and reset timing
            currentMessage.route(Route.routeName(this.name, outputs.get(0)));
            currentMessage.delay(0);
        }
    }

    // goes from a -> b -> a -> c
    public void loop(String start, String middle, String end) {
        if (currentMessage.property(middle) == null) {
            logger.debug("{} -> {}", start, middle);
            currentMessage.property(middle, "done");
            currentMessage.routeTo(middle);
        } else {
            logger.debug("{} -> {}", start, end);
            currentMessage.routeTo(end);
        }
        logger.debug("{} Current Message [{}]", start, currentMessage);
    }

    // use the DESTINATION property to choose next route
    public void routeToDestination() {
        routeToProperty(Message.Property.DESTINATION);
    }
    // use the given property to choose next route
    public void routeToProperty(String propertyName) {
        routeToProperty(propertyName, null);
    }
    // ditto but with a default in case property isn't defined
    public void routeToProperty(String propertyName, String defaultRoute) {
        String destination = currentMessage.property(propertyName);
        if (destination == null && defaultRoute != null) {
            destination = defaultRoute;
        }
        currentMessage.route(Route.routeName(this.name, destination));
        currentMessage.delay(0);
    }

    public class Action {
        public static final int PAUSE               = 0;
        public static final int READ_FROM_S3        = 10;
        public static final int METADATA_FROM_S3    = 15;
        public static final int WRITE_TO_S3         = 20;
        public static final int WRITE_DOG_TO_S3     = 25;
        public static final int READ_FROM_PIPS      = 30;
        public static final int WRITE_TO_PIPS       = 40;
        public static final int WRITE_TO_MIR        = 45;
        public static final int WORK                = 50;
        public static final int EMIT                = 98;
        public static final int SINK                = 99;

        int type;
        private int length;

        Action(int type) {
            this.type = type;
        }
    }

    // point / rectangle collision, failing fast.
    boolean mouseIsOver() {
        float left = p.screenX(x -100, y);
        if (p.mouseX > left) {
            float right = p.screenX(x + 100, y);
            if (p.mouseX < right) {
                float top = p.screenY(x, y - 100);
                if (p.mouseY > top) {
                    float bottom = p.screenY(x, y + 100);
                    if (p.mouseY < bottom) {
                        p.cursor(PApplet.HAND);
                        logger.debug("Component [{}]", this);
                        return true;
                    }
                }
            }
        }
        p.cursor(PApplet.ARROW);
        return false;
    }

    // what happens when we click this component
    public void click() {
    }

    // common "read from s3, work, write to3, emit" pattern
    public void readWorkWriteEmit() {
        addAction(Action.READ_FROM_S3, 60);
        addAction(Action.WORK, 60);
        addAction(Action.WRITE_TO_S3, 60);
        addAction(Action.EMIT, 1);
    }

    @Override
    public String toString() {
        return "" + name + ": " + type + " (Actions " + actions.size() + ")";
    }

    private static final float SPACING = 50;
    private static PShape createArrow(PApplet p, float srcX, float srcY, float dstX, float dstY, float shaftWidth, int colour) {
        float d = PApplet.dist(srcX, srcY, dstX, dstY);
        float sw2 = shaftWidth / 2;
        float prong = 15f;
        float prongX = SPACING + sw2 + prong;
        PShape s = p.createShape();
        s.beginShape();
        s.stroke(colour);
        s.fill(colour);
        s.strokeWeight(2);
        s.vertex(d - SPACING, 0);   // point
        s.vertex(d - prongX, sw2 + prong);
        s.vertex(d - prongX, sw2);
        s.vertex(SPACING, sw2);     // end
        s.vertex(SPACING, -sw2);    // end
        s.vertex(d - prongX, -sw2);
        s.vertex(d - prongX, -sw2 - prong);
        s.vertex(d - SPACING, 0);   // point again
        s.endShape();
        return s;
    }
    @Deprecated // unused hopefully
    void drawArrow(float srcX, float srcY, float dstX, float dstY, float shaftWidth, int colour) {
        PShape arrow = createArrow(p, srcX, srcY, dstX, dstY, shaftWidth, colour);
        float angle = PConstants.PI + PApplet.atan2(srcY - dstY, srcX - dstX);
        p.pushMatrix();
        p.translate(srcX, srcY);
        p.rotate(angle);
        p.shape(arrow);
        p.popMatrix();
    }
    // new, uses predefined arrow
    void drawArrow(PShape arrow, float srcX, float srcY, float dstX, float dstY) {
        float angle = PConstants.PI + PApplet.atan2(srcY - dstY, srcX - dstX);
        p.pushMatrix();
        p.translate(srcX, srcY);
        p.rotate(angle);
        p.shape(arrow);
        p.popMatrix();
    }
    // creates a simple shape, centred on origin, containing a quad of the correct image and requested size
    final PShape createQuad(PImage img, int size) {
        PShape shape = p.createShape();
        shape.beginShape();
        shape.noStroke();
        shape.fill(0, 0, 0, 0);
        shape.textureMode(PConstants.NORMAL);
        shape.texture(img);
        shape.vertex(-size / 2, -size / 2, 0, 0);
        shape.vertex(size / 2, -size / 2, 1, 0);
        shape.vertex(size / 2, size / 2, 1, 1);
        shape.vertex(-size / 2, size / 2, 0, 1);
        shape.vertex(-size / 2, -size / 2, 0, 0);
        shape.endShape();
        return shape;
    }
    private void drawQuad(PShape shape, float x, float y) {
        p.pushMatrix();
        p.translate(x, y);
        p.shape(shape);
        p.popMatrix();
    }
}
