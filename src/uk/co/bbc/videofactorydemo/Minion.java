package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Minion extends Component {
    public static final String NAME = "Minion";

    public Minion(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Soprendo.NAME);
    }
}
