package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Monk extends Component {
    public static final String NAME = "Monk";

    public Monk(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Pedant.NAME);
    }
}
