package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Bifurcate extends Component {
    public static final String NAME = "Bifurcate";
    private static final String DESCRIPTION = "Routes subtitle files one way, other files the other.";

    public Bifurcate(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(YellowPages.NAME);
    }
}
