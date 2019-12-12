package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Syncopaticaption extends Component {
    public static final String NAME = "Syncopaticaption";
    private static final String DESCRIPTION = "Converts STL subtitles to TTML.";

    public Syncopaticaption(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Subherd.NAME);
    }
}
