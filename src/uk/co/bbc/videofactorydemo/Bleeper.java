package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Bleeper extends Component {
    public static final String NAME = "Bleeper";

    public Bleeper(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Mattress.NAME);
    }
}
