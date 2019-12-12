package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class PaulMami extends Component {
    public static final String NAME = "_PaulMami";

    public PaulMami(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = CONNECTOR;
        addInput(PaulOut.NAME);
    }
}
