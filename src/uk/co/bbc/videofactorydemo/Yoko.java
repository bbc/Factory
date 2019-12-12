package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Yoko extends Component {
    public static final String NAME = "Yoko";

    public Yoko(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(John.NAME);
    }
}
