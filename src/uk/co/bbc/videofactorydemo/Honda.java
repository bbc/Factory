package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Honda extends Component {
    public static final String NAME = "Honda";
    private static final String DESCRIPTION = "Handles the FBD 'sidecars'";

    public Honda(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Bifurcate.NAME);
    }
}
