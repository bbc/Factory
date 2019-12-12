package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Heraldry extends Component {
    public static final String NAME = "Heraldry";

    public Heraldry(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = LAMBDA;
        addInput(Fbd.NAME);
    }
}
