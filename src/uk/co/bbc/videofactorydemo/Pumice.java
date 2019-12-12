package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Pumice extends Component {
    public static final String NAME = "Pumice";
    private static final String DESCRIPTION = "Tidies video before thumbnails are generated.";

    public Pumice(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Mattress.NAME);
    }
}
