package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Loudnorm extends Component {
    public static final String NAME = "Loudnorm";
    private static final String DESCRIPTION = "Normalises audio volumes.";


    public Loudnorm(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Vimes.NAME);
    }

    @Override
    public void processMessage() {
        readWorkWriteEmit();
    }
}
