package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Rutherford extends Component {
    public static final String NAME = "Rutherford";
    private static final String DESCRIPTION = "Splits requests with multiple Piff bundles.";

    public Rutherford(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Brucey.NAME);
    }
}
