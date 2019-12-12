package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Lovett extends Component {
    public static final String NAME = "Lovett";

    public Lovett(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Pedant.NAME);
    }
}
