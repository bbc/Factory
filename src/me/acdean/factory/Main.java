package me.acdean.factory;

import me.acdean.factory.example.ExampleFactory;
import peasy.PeasyCam;
import processing.core.PApplet;
import processing.core.PFont;

/*
** Main replaces the processing sketch file.
*/

public class Main extends PApplet {

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
        //fullScreen(P3D);
        size(1600, 800, P3D);
    }

    @Override
    public void setup() {
        println("setup");
        println("Sketch Path:", sketchPath());
        println("Data Path:", dataPath(""));
        font = createFont("Liberation Sans Bold", 100);
        //printArray(PFont.list());
        rectMode(CENTER);
        ellipseMode(CENTER);
        imageMode(CENTER);
        hint(ENABLE_DEPTH_SORT);

        // set up camera
        cam = new PeasyCam(this, 1000);
        // replace rotation with panning
        cam.setLeftDragHandler(cam.getPanDragHandler());
        cam.setMaximumDistance(3300);
        cam.setMinimumDistance(250);

        factory = new ExampleFactory(this);
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
            println("Following");
            float[] c = cam.getLookAt();
            println(c[0], c[1], c[2]);
            println(factory.messages.get(0).x, factory.messages.get(0).y);
            cam.lookAt(factory.messages.get(0).x, factory.messages.get(0).y, 0);
        }
        if (frameCount % 60 == 0) {
            println("Distance: " + cam.getDistance());
        }

        if (video) {
            saveFrame("frame_####.png");
            if (frameCount == 3000) {
                System.exit(0);
            }
        }
    }

    @Override
    public void keyPressed() {
        if (key == 'm') {
            factory.addMessage();
        }
        if (key == 'f') {
            follow = true;
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
