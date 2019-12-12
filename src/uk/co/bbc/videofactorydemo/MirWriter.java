package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class MirWriter extends Component {
    public static final String NAME = "MirWriter";

    public MirWriter(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Mami.NAME);
    }
}
