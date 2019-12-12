package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class YellowPages extends Component {
    public static final String NAME = "Yellow Pages";

    public YellowPages(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Heraldry.NAME);
    }
}
