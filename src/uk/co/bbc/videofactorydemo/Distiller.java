package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Distiller extends Component {
    public static final String NAME = "Distiller";

    public Distiller(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = LAMBDA;
        addInput(Subherd.NAME);
    }

    @Override
    public void processMessage() {
        readWorkWriteEmit();
    }
}
