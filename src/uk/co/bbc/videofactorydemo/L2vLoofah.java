package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class L2vLoofah extends Component {
    public static final String NAME = "L2V Loofah";

    public L2vLoofah(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(L2vPumice.NAME);
    }
}
