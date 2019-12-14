package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class MirWriter extends Component {
    public static final String NAME = "MirWriter";
    private static final String DESCRIPTION = "Writes to MIR.";

    public MirWriter(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Mami.NAME);
    }

    // maybe do this as a component attribute?
    @Override
    public void processMessage() {
        addAction(Action.SINK);
    }
}
