package me.acdean.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public abstract class Factory {

    public static Logger logger = LoggerFactory.getLogger(Factory.class);

    public Main p;
    public Map<String, Component> components = new HashMap<>();
    public Map<String, Route> routes = new HashMap<>();
    public List<Message> messages = new ArrayList<>();
    PImage messageImg, audioImg, subtitleImg, clipImg, proxyImg, videoImg;
    PImage ec2Img, lambdaImg, bucketImg, cogsImg, blackBoxImg;
    PImage dynamoImg, mysqlImg;
    // copy of papplet fields
    public int width, height;
    Component mouseOverComponent = null;

    public Factory(Main papplet) {
        super();
        p = papplet;
        width = p.width;
        height = p.height;
    }

    public void setupFactory() {
        // load all the images
        messageImg = p.loadImage("message.png");
        audioImg = p.loadImage("audio_message.png");
        subtitleImg = p.loadImage("subtitle_message.png");
        clipImg = p.loadImage("clip_message.png");
        proxyImg = p.loadImage("proxy_message.png");
        videoImg = p.loadImage("video_message.png");
        lambdaImg = p.loadImage("lambda.png");
        ec2Img = p.loadImage("ec2.png");
        bucketImg = p.loadImage("bucket.png");
        cogsImg = p.loadImage("cogs.png");
        dynamoImg = p.loadImage("dynamo.png");
        mysqlImg = p.loadImage("mysql.png");
        blackBoxImg = p.loadImage("blackBox.png");

        logger.info("Factory Calculate Routes");
        // calculate routes and outputs from inputs
        logger.info("INPUTS");
        for (Component component : components.values()) {
            for (int i = 0 ; i < component.inputs.size() ; i++) {
                Component input = components.get(component.inputs.get(i));
                logger.info("{} <- {}", component.name, input.name);
                input.outputs.add(component.name);
                Route route = new Route(this, input.name, component.name);
                routes.put(route.name, route);
            }
        }
        logger.info("OUTPUTS");
        for (Component component : components.values()) {
            for (String output : component.outputs) {
                logger.info("{} -> {}", component.name, output);
            }
        }

        // make the loops loops
        fixupRoutes();
    }

    public void drawFactory() {
        // move everything
        for (Component c : components.values()) {
            c.tick();
        }
        for (Message m : messages) {
            m.tick();
        }

        // draw everything (TODO pshape for static bits)
        for (Route r : routes.values()) {
            r.draw();
        }
        mouseOverComponent = null;
        for (Component c : components.values()) {
            c.draw();
            if (c.mouseIsOver()) {
                mouseOverComponent = c;
            }
        }
        for (Message m : messages) {
            m.draw();
        }

        // visual flag for now, description text later. HUD?
        if (mouseOverComponent != null && mouseOverComponent.description != null) {
            p.cam.beginHUD();
            p.rectMode(PConstants.CORNER);
            p.textFont(p.font, 65);
            p.stroke(128);
            p.fill(128);
            p.textAlign(PConstants.LEFT, PConstants.TOP);
            p.text(mouseOverComponent.name + ": " + mouseOverComponent.description, 10, 10, width - 10, 500);
            p.rectMode(PConstants.CENTER);
            p.cam.endHUD();
        }
    }

    public final void addComponent(Component c) {
        components.put(c.name, c);
    }

    public final void addMessage(Message m) {
        messages.add(m);
    }

    // you can add a message using only component name if there's only one output for that component
    // useful for starting messages at start nodes
    public final Message addMessage(String name) {
        logger.info("AddMessage [{}]", name);
        Component c = components.get(name);
        Message m = new Message(this, Route.routeName(name, c.outputs.get(0)))
                .property(Message.Property.SOURCE, name);
        messages.add(m);
        return m;
    }

    abstract public void addMessage();

    public final void addRoute(String start, String end) {
        Route route = new Route(this, start, end);
        //System.out.println("Route: " + route.name);
        routes.put(route.name, route);
    }

    public void fixupRoutes() {
        // children can override this to fix up the route types for loops
    }

    // update the type of a route
    public void updateRoute(String start, String end, int type) {
        String routeName = Route.routeName(start, end);
        routes.get(routeName).type(type);
    }

    // needed for start pressing? same code is in component.mouseIsOver()
    public void mousePressed() {
        p.cursor(PApplet.ARROW);
        for (Component component : components.values()) {
            float left = p.screenX(component.x -100, component.y);
            if (p.mouseX > left) {
                float right = p.screenX(component.x + 100, component.y);
                if (p.mouseX < right) {
                    float top = p.screenY(component.x, component.y - 100);
                    if (p.mouseY > top) {
                        float bottom = p.screenY(component.x, component.y + 100);
                        if (p.mouseY < bottom) {
                            p.cursor(PApplet.HAND);
                            logger.info("MousePressed: Component [{}]", component);
                            component.click();
                            break;
                        }
                    }
                }
            }
        }
    }

    public float dist2(float x1, float y1, float x2, float y2) {
        return ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1));
    }
}
