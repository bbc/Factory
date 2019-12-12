package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Heraldry extends Component {
    public static final String NAME = "Heraldry";
    private static final String DESCRIPTION = "Watches for FBD arrivals.";

    public Heraldry(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        type = LAMBDA;
        addInput(Fbd.NAME);
    }
}
