package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Mami extends Component {
    public static final String NAME = "Mami";
    private static final String DESCRIPTION = "Media Asset Management Interface.";

    public Mami(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Paulette.NAME);
        addInput(PaulMami.NAME);
    }

    @Override
    public void processMessage() {
        addAction(Action.WRITE_TO_PIPS, 60);
        addAction(Action.EMIT);
    }
}
