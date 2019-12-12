package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Copper extends Component {
    public static final String NAME = "Copper";
    private static final String DESCRIPTION = "Intercepts messages for Audio Factory.";

    public Copper(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Bread.NAME);
    }
}
