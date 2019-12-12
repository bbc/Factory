package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Loofah extends Component {
    public static final String NAME = "Loofah";
    private static final String DESCRIPTION = "Creates thumbnail storyboards.";

    public Loofah(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Pumice.NAME);
    }

    @Override
    public void processMessage() {
        readWorkWriteEmit();
    }
}
