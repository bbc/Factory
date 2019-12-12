package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Ringo extends Component {
    public static final String NAME = "Ringo";

    public Ringo(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Yoko.NAME);
    }

    @Override
    public void emit() {
        currentMessage.routeTo(L2vMapr.NAME);
    }
}
