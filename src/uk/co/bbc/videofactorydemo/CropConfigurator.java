package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class CropConfigurator extends Component {

    public static final String NAME = "CropConfigurator";
    public static final String DESCRIPTION = "Adds cropping details to the request if required.";

    public CropConfigurator(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = LAMBDA;
        setDescription(DESCRIPTION);
        addInput(Cockcroft.NAME);
    }
}
