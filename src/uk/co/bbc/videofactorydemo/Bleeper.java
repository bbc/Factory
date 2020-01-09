package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

@Deprecated
public class Bleeper extends Component {
    public static final String NAME = "Bleeper";
    private static final String DESCRIPTION = "Add the bleeps to an audio feed.";

    public Bleeper(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Mattress.NAME);
    }
}
