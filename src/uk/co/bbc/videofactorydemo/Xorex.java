package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Xorex extends Component {
    public static final String NAME = "Xoerx";

    public Xorex(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
    }
}
