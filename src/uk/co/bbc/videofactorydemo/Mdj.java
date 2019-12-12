package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Mdj extends Component {
    public static final String NAME = "MDJ";
    private static final String DESCRIPTION = "Media Distribution Layer (in Java)";

    public Mdj(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Paulette.NAME);
    }
}
