package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Syncopaticaption extends Component {
    public static final String NAME = "Syncopaticaption";

    public Syncopaticaption(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Subherd.NAME);
    }
}
