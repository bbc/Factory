package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Chopper extends Component {
    public static final String NAME = "Chopper";
    private static final String DESCRIPTION = "Manual audio trimmer.";

    public Chopper(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(MezToAudio.NAME);
    }
}
