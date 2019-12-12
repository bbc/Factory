package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Delilah extends Component {
    public static final String NAME = "Delilah";
    private static final String DESCRIPTION = "Bulk ingestor for legacy clips.";

    public Delilah(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(LegacyClips.NAME);
    }

    @Override
    public void processMessage() {
        Factory.logger.info("Delilah ProcessMessage");
        addAction(Action.READ_FROM_S3, 30);
        addAction(Action.WRITE_TO_S3, 30);
        addAction(Action.EMIT, 1);
        Factory.logger.info("Actions: [{}]", actions.size());
    }

    @Override
    public void click() {
        factory.addMessage(NAME);
    }
}
