package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Pumice extends Component {
    public static final String NAME = "Pumice";

    public Pumice(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Mattress.NAME);
    }
}
