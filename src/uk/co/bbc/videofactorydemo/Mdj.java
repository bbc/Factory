package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Mdj extends Component {
    public static final String NAME = "MDJ";

    public Mdj(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Paulette.NAME);
    }
}
