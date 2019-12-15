package uk.co.bbc.videofactorydemo;

import java.util.Random;
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

    // return a random destination.
    // method should be used when creating messages that will come through subherd
    public static String getRandomhandler() {
        Random random = new Random();
        String handler = null;
        switch (random.nextInt(3)) {    // 0, 1, 2
            case 0:
                handler = Distiller.NAME;
                break;
            case 1:
                handler = Sting.NAME;
                break;
            case 2:
                handler = Syncopaticaption.NAME;
                break;
        }
        return handler;
    }
}
