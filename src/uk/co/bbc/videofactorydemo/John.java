package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class John extends Component {
    public static final String NAME = "John";

    public John(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Lijer.NAME);
    }
}
