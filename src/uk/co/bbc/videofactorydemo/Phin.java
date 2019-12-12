package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Phin extends Component {
    public static final String NAME = "Phin";
    private static final String DESCRIPTION = "Reads DPP data from MXF files.";

    public Phin(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Honda.NAME);
    }
}
