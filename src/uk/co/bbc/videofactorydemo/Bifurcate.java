package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Bifurcate extends Component {
    public static final String NAME = "Bifurcate";

    public Bifurcate(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(YellowPages.NAME);
    }
}
