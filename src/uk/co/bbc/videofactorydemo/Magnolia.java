package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Magnolia extends Component {
    public static final String NAME = "Magnolia";

    public Magnolia(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Phin.NAME);
    }
}
