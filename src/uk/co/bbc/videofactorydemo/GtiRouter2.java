package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;
import me.acdean.factory.Message;

public class GtiRouter2 extends Component {

    public static final String NAME = "GtiRouter2";
    public static final String DESCRIPTION = "Decides which encoder to use for this job.";

    public GtiRouter2(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = LAMBDA;
        setDescription(DESCRIPTION);
        addInput(CropConfigurator.NAME);
    }

    // route message to relevant encoder
    @Override
    public void emit() {
        routeToProperty(Message.Property.ENCODER);
    }
}
