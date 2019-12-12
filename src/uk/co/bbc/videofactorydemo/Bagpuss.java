package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Bagpuss extends Component {
    public static final String NAME = "Bagpuss";

    public Bagpuss(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Pedant.NAME);
    }
}
