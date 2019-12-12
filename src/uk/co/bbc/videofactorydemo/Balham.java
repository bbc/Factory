package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Balham extends Component {
    public static final String NAME = "Balham";
    private static final String DESCRIPTION = "The gateway to Media Factory.";

    public Balham(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Delilah.NAME);
        addInput(Clips.NAME);
    }

    @Override
    public void processMessage() {
        Factory.logger.info("Balham ProcessMessage");
        addAction(Action.METADATA_FROM_S3, 30);
        addAction(Action.EMIT, 1);
    }
}
