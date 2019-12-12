package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class PaulOut extends Component {
    public static final String NAME = "_PaulOut";

    public PaulOut(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = CONNECTOR;
        addInput(Paul.NAME);
    }
}
