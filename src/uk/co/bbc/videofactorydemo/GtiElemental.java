package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class GtiElemental extends Component {

    public static final String NAME = "GtiElemental";
    public static final String DESCRIPTION = "General purpose encoder.";

    public GtiElemental(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(GtiRouter2.NAME);
    }

    @Override
    public void emit() {
        routeToDestination();
    }

    // reads from s3, processes, writes to s3
    @Override
    public void processMessage() {
        readWorkWriteEmit();
    }
}
