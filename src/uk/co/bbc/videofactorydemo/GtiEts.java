package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class GtiEts extends Component {

    public static final String NAME = "GtiEts";
    public static final String DESCRIPTION = "An audio encoder.";

    public GtiEts(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(GtiRouter2.NAME);
    }

    @Override
    public void emit() {
        routeToDestination();
    }

    @Override
    public void processMessage() {
        readWorkWriteEmit();
    }
}
