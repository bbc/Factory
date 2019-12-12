package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class WhitePages extends Component {
    public static final String NAME = "White Pages";

    public WhitePages(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Rights.NAME);
    }
}
