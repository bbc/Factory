package me.acdean.factory;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;

/*
** Starkles (like sparkles but star shaped)
 */

public class Starkles extends ArrayList<Starkles.Starkle> {

    private static PShape star;
    private PApplet p; 

    public Starkles(PApplet p) {
        this.p = p;
        if (star == null) {
            star = p.createShape();
            star.beginShape();
            star.noStroke();
            //star.strokeWeight(2);
            // NB goes to 11 to close the loop
            for (int i = 0 ; i < 11 ; i++) {
                float a = PConstants.TWO_PI * i / 10;
                float r = 20;
                if (i % 2 == 0) {
                    r = r * .35f;
                }
                star.vertex(r * PApplet.cos(a), r * PApplet.sin(a));
            }
            star.endShape();
        }
    }

    public boolean add(Starkle starkle) {
        return super.add(starkle);
    }

    void add(float x, float y) {
        add(new Starkle(x, y));
    }

    void update() {
        for (int i = this.size() - 1; i >= 0; i--) {
            Starkle starkle = get(i);
            boolean status = starkle.move();
            if (status == false) {
                remove(i);
            } else {
                starkle.draw();
            }
        }
    }

    class Starkle {

        final int MAX_LIFE = 100;
        float x, y, dx, dy, rx, drx;
        int count;

        Starkle(float x, float y) {
            this.x = x;
            this.y = y;
            this.dx = p.random(-2, 2);
            this.dy = p.random(-2, 2);
            this.rx = p.random(PConstants.TWO_PI);
            this.drx = PApplet.radians(p.random(-2, 2));
            count = MAX_LIFE;
        }

        boolean move() {
            count--;
            if (count > 0) {
                x += dx;
                y += dy;
                rx += drx;
                return true;
            }
            return false;
        }

        void draw() {
            int c = (int)PApplet.map(count, 0, MAX_LIFE, 0, 255);
            if (count > 0) {
                p.pushMatrix();
                p.translate(x, y, 100);
                p.rotateZ(rx);
                star.setFill(0xff000000 | (c << 16) | (c << 8) | c);
                p.shape(star);
                p.popMatrix();
            }
        }
    }
}
