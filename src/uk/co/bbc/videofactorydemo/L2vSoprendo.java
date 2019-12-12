package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class L2vSoprendo extends Component {
    public static final String NAME = "L2V Soprendo";

    public L2vSoprendo(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(L2vMapr.NAME);
    }

    @Override
    public void emit() {
        currentMessage.routeTo(L2vAlduin.NAME);
    }
}
