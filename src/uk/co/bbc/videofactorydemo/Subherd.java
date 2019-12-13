package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;
import me.acdean.factory.Message;

public class Subherd extends Component {
    public static final String NAME = "Subherd";
    private static final String DESCRIPTION = "Routes various subtitle messages according to type.";

    public Subherd(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Bifurcate.NAME);
        addInput(WhitePages.NAME);
    }

    @Override
    public void emit() {
        routeToProperty(Message.Property.SUBTITLE_HANDLER);
    }
}
