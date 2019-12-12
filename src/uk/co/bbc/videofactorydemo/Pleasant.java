package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Pleasant extends Component {

    public static final String NAME = "Pleasant";
    public static final String DESCRIPTION = "Routes encoder messages to their destination.";

    public Pleasant(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = LAMBDA;
        setDescription(DESCRIPTION);
        addInput(GtiBitmovin.NAME);
        addInput(GtiEdc.NAME);
    }

    @Override
    public void emit() {
        routeToDestination();
    }
}
