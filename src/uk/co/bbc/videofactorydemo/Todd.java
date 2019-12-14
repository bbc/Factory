package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Todd extends Component {
    public static final String NAME = "Todd";
    private static final String DESCRIPTION = "Trim console.";

    public Todd(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(GtiEdwin.NAME);
        addInput(GtiElemental.NAME);
        addInput(GtiEts.NAME);
        addInput(Pleasant.NAME);
    }

    // maybe do this as a component attribute?
    @Override
    public void processMessage() {
        addAction(Action.SINK);
    }
}
