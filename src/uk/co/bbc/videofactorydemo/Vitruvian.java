package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Vitruvian extends Component {
    public static final String NAME = "Vitruvian";
    private static final String DESCRIPTION = "Resizes DOGs to the correct aspect ratio.";

    public Vitruvian(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Loudnorm.NAME);
    }

    @Override
    public void processMessage() {
        Factory.logger.info("Vitruvian ProcessMessage");
        addAction(Action.METADATA_FROM_S3, 30);
        addAction(Action.WRITE_DOG_TO_S3, 30);
        addAction(Action.EMIT, 1);
    }
}
