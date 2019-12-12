package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class L2vMinion extends Component {
    public static final String NAME = "L2V Minion";

    public L2vMinion(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(L2vSoprendo.NAME);
    }
}
