package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Brucey extends Component {
    public static final String NAME = "Brucey";
    private static final String DESCRIPTION = "Adds bumpers if required.";

    public Brucey(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Fenton.NAME);
    }
}
