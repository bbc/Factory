package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Loofah extends Component {
    public static final String NAME = "Loofah";

    public Loofah(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Pumice.NAME);
    }

    @Override
    public void processMessage() {
        readWorkWriteEmit();
    }
}
