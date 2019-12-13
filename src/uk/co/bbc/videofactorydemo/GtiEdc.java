package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class GtiEdc extends Component {

    public static final String NAME = "GtiEdc";
    public static final String DESCRIPTION = "A newer audio encoder.";

    public GtiEdc(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = LAMBDA;
        setDescription(DESCRIPTION);
        addInput(GtiRouter2.NAME);
    }

    // reads from s3, processes, writes to s3
    @Override
    public void processMessage() {
        readWorkWriteEmit();
    }
}
