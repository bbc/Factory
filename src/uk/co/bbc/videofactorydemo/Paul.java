package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Paul extends Component {
    public static final String NAME = "Paul";

    public Paul(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Ringo.NAME);
        addInput(L2vSponge.NAME);
        addInput(L2vAlduin.NAME);
        addInput(L2vMinion.NAME);
    }
}
