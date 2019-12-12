package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Sting extends Component {
    public static final String NAME = "Sting";

    public Sting(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Subherd.NAME);
    }
}
