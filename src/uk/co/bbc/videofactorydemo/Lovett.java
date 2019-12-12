package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Lovett extends Component {
    public static final String NAME = "Lovett";
    private static final String DESCRIPTION = "Manages trimming.";

    public Lovett(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Pedant.NAME);
    }
}
