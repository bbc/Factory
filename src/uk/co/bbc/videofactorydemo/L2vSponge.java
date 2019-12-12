package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class L2vSponge extends Component {
    public static final String NAME = "L2V Sponge";

    public L2vSponge(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(L2vLoofah.NAME);
    }
}
