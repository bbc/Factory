package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Vimes extends Component {
    public static final String NAME = "Vimes";

    public Vimes(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Balham.NAME);
    }

    @Override
    public void processMessage() {
        Factory.logger.info("Vimes ProcessMessage");
        addAction(Action.METADATA_FROM_S3, 30);
        addAction(Action.EMIT, 1);
    }
}
