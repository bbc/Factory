package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Phin extends Component {
    public static final String NAME = "Phin";

    public Phin(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Honda.NAME);
    }
}
