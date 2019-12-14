package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Sponge extends Component {
    public static final String NAME = "Sponge";
    private static final String DESCRIPTION = "Generates thumbnail manifests.";

    public Sponge(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Loofah.NAME);
    }

    @Override
    public void processMessage() {
        Factory.logger.info("Sponge ProcessMessage");
        addAction(Action.WRITE_TO_S3, 30);
        addAction(Action.EMIT);
        Factory.logger.info("Actions: [{}]", actions.size());
    }
}
