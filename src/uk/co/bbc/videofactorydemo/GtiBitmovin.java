package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class GtiBitmovin extends Component {

    public static final String NAME = "GtiBitmovin";
    private static final String DESCRIPTION = "A fast, parallel encoding service "
            + "that converts raw incoming video into desired outputs.";

    public GtiBitmovin(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(GtiRouter2.NAME);
    }

    // bitmovin reads from s3, processes, writes to s3
    @Override
    public void processMessage() {
        readWorkWriteEmit();
    }
}
