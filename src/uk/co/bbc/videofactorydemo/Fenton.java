package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Fenton extends Component {
    public static final String NAME = "Fenton";
    private static final String DESCRIPTION = "Manages the DOGs.";

    public Fenton(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Monk.NAME);
    }
}
