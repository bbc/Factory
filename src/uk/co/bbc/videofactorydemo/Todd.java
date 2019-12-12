package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Todd extends Component {

    public static final String NAME = "Todd";

    public Todd(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(GtiEdwin.NAME);
        addInput(GtiElemental.NAME);
        addInput(GtiEts.NAME);
        addInput(Pleasant.NAME);
    }
}
