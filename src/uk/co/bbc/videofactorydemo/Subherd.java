package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Subherd extends Component {
    public static final String NAME = "Subherd";

    public Subherd(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Bifurcate.NAME);
        addInput(WhitePages.NAME);
    }
}
