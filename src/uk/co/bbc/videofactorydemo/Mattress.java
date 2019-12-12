package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Mattress extends Component {

    public static final String NAME = "Mattress";
    private static final String DESCRIPTION = "Media Asset Translator. Converts GTI output messages.";

    public Mattress(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(GtiEdwin.NAME);
        addInput(GtiElemental.NAME);
        addInput(GtiEts.NAME);
        addInput(Pleasant.NAME);
    }

    @Override
    public void emit() {
        currentMessage.routeTo(Mapr.NAME);
    }
}
