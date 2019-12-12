package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Movver extends Component {
    public static final String NAME = "Movver";
    private static final String DESCRIPTION = "Wraps raw audio in a mov container.";

    public Movver(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Chopper.NAME);
        addInput(Lijer.NAME);
    }
}
