package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Soprendo extends Component {
    public static final String NAME = "Soprendo";

    public Soprendo(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Mapr.NAME);
    }

    @Override
    public void emit() {
        currentMessage.routeTo(Alduin.NAME);
    }
}
