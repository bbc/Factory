package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Rutherford extends Component {
    public static final String NAME = "Rutherford";

    public Rutherford(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Brucey.NAME);
    }
}
