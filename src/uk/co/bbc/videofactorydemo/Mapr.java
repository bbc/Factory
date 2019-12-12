package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Mapr extends Component {
    public static final String NAME = "Mapr";
    private static final String DESCRIPTION = "Media Asset to Piff Request.";

    public Mapr(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Mattress.NAME);
    }
}
