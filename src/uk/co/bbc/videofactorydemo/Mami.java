package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Mami extends Component {
    public static final String NAME = "Mami";
    private static final String DESCRIPTION = "Media Asset Management Interface.";

    public Mami(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Paulette.NAME);
        addInput(PaulMami.NAME);
    }
}
