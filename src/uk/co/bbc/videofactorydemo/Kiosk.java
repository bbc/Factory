package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Kiosk extends Component {
    public static final String NAME = "Kiosk";
    private static final String DESCRIPTION = "Exit point for video store.";

    public Kiosk(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Fred.NAME);
        addInput(VideoStore.NAME);
    }
}
