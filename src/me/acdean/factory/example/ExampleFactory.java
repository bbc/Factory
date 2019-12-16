package me.acdean.factory.example;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;
import me.acdean.factory.Main;
import me.acdean.factory.Message;
import me.acdean.factory.Route;

public class ExampleFactory extends Factory {

    public ExampleFactory(Main p) {
        super(p);

        int w = Component.WIDTH * 3 / 2;
        int h = Component.HEIGHT * 3 / 2;
        logger.info("W [{}] H [{}]", w, h);

        int y98 = h * -12 / 2;
        int y99 = h * -11 / 2;
        int y00 = h * -10 / 2;
        int y01 = h * -9 / 2;
        int y02 = h * -8 / 2;
        int y03 = h * -7 / 2;
        int y04 = h * -6 / 2;
        int y05 = h * -5 / 2;
        int y06 = h * -4 / 2;
        int y07 = h * -3 / 2;
        int y08 = h * -2 / 2;
        int y09 = h * -1 / 2;
        int y10 = 0;
        int y11 = h * 1 / 2;
        int y12 = h * 2 / 2;
        int y13 = h * 3 / 2;
        int y14 = h * 4 / 2;
        int y15 = h * 5 / 2;
        int y16 = h * 6 / 2;
        int y17 = h * 7 / 2;
        int y18 = h * 8 / 2;
        int y19 = h * 9 / 2;
        int y20 = h * 10 / 2;

        int x = -1000;
        addComponent(new Start(this, x, y10));
        x += w;

        addComponent(new One(this, x, y10));
        addComponent(new Two(this, x, y12));
        x += w;

        addComponent(new Three(this, x, y10));
        x += w;

        addComponent(new FourA(this, x, y08));
        addComponent(new FourB(this, x, y12));
        x += w;

        addComponent(new Five(this, x, y10));
        x += w;
    }

    // fixup the routes. seems a bit hacky.
    @Override
    public void fixupRoutes() {
        logger.info("Fixing up routes");
        updateRoute(One.NAME, Two.NAME, Route.LOOP_BACK);
        updateRoute(Two.NAME, One.NAME, Route.LOOP_FORWARD);

        for (Route route : routes.values()) {
            logger.info("Fixed Route [{}]", route);
        }
    }

    // a start message
    @Override
    public Message addMessage() {
        return addMessage(Start.NAME);
    }
}
