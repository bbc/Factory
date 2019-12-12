package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Copper extends Component {
    public static final String NAME = "Copper";

    public Copper(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Bread.NAME);
    }
}
