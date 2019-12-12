package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class L2vMapr extends Component {
    public static final String NAME = "L2V Mapr";

    public L2vMapr(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Ringo.NAME);
    }
}
