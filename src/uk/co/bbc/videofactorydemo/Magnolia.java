package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Magnolia extends Component {
    public static final String NAME = "Magnolia";
    private static final String DESCRIPTION = "Sets defaults for FBD workflow messages.";

    public Magnolia(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Phin.NAME);
    }
}
