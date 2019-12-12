package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Kiosk extends Component {
    public static final String NAME = "Kiosk";

    public Kiosk(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Fred.NAME);
        addInput(VideoStore.NAME);
    }
}
