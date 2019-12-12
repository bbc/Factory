package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Fbd extends Component {
    public static final String NAME = "File Based Delivery";

    public Fbd(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = INPUT;
    }

    @Override
    public void click() {
        factory.addMessage(NAME);
    }
}
