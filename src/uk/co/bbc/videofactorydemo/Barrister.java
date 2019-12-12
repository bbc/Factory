package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Barrister  extends Component {
    public static final String NAME = "Barrister";

    public Barrister(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Bleeper.NAME);
        addInput(Sponge.NAME);
        addInput(Minion.NAME);
        addInput(Alduin.NAME);
    }
}
