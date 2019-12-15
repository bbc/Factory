package me.acdean.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import peasy.PeasyCam;
import processing.core.PApplet;
import processing.core.PFont;
import uk.co.bbc.videofactorydemo.VideoFactory;

/*
** Main replaces the processing sketch file.
*/

public class Main extends PApplet {

    Logger logger = LoggerFactory.getLogger("Main");
    
    PFont font;
    Factory factory;
    public PeasyCam cam;
    boolean follow;
    boolean video = false; // save frames for later video

    public static void main(String[] args) {
        PApplet.main("me.acdean.factory.Main");
    }

    @Override
    public void settings() {
        fullScreen(P3D);
        //size(1600, 800, P3D);
    }

    @Override
    public void setup() {
        logger.debug("setup");
        logger.debug("Sketch Path [{}]", sketchPath());
        logger.debug("Data Path [{}]", dataPath(""));
        font = createFont("Liberation Sans Bold", 100);
        //printArray(PFont.list());
        frameRate(50);
        rectMode(CENTER);
        ellipseMode(CENTER);
        imageMode(CENTER);
        hint(ENABLE_DEPTH_SORT);

        // set up camera
        cam = new PeasyCam(this, 1000);
        // replace rotation with panning
        cam.setLeftDragHandler(cam.getPanDragHandler());
        cam.setMaximumDistance(3500);
        cam.setMinimumDistance(250);

        factory = new VideoFactory(this);
        factory.setupFactory();
        factory.addMessage();
    }

    @Override
    public void draw() {
        background(0);
        textFont(font, 35);
        factory.drawFactory();
        if (keyPressed) {
            if (keyCode == UP) cam.pan(0, -10);
            if (keyCode == DOWN) cam.pan(0, 10);
            if (keyCode == LEFT) cam.pan(-10, 0);
            if (keyCode == RIGHT) cam.pan(10, 0);
        }
        if (follow) {
            logger.debug("Following");
            float[] c = cam.getLookAt();
            logger.debug("{} {} {}", c[0], c[1], c[2]);
            logger.debug("xy: {}, {}", factory.messages.get(0).x, factory.messages.get(0).y);
            cam.lookAt(factory.messages.get(0).x, factory.messages.get(0).y, 0);
        }
        if (frameCount % 60 == 0) {
            logger.debug("Distance [{}]", cam.getDistance());
        }

        if (video) {
            saveFrame("frame_####.png");
            if (frameCount == 3000) {
                System.exit(0);
            }
        }
        logger.info("Messages [{}]", factory.messages.size());
    }

    @Override
    public void keyPressed() {
        if (key == 'm') {
            factory.addMessage();
        }
        if (key == 'f') {
            follow = true;
        }
        if (key == 's') {
            saveFrame("VideoFactory_#####.png");
        }
        if (key == 'd') {
            factory.debug();
        }
    }

    @Override
    public void mousePressed() {
        factory.mousePressed();
    }

    PeasyCam getCamera() {
        return cam;
    }
}
