package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Rosetta extends Component {
    public static final String NAME = "Rosetta";
    private static final String DESCRIPTION = "Resolves brands.";

    public Rosetta(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Barrister.NAME);
    }

    @Override
    public void processMessage() {
        Factory.logger.info("Rosetta ProcessMessage");
        addAction(Action.READ_FROM_PIPS, 30);
        addAction(Action.EMIT, 1);
    }
}
