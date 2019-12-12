package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class SubtitleOut extends Component {
    public static final String NAME = "SubtitleOut";

    public SubtitleOut(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = CONNECTOR;
        addInput(Sting.NAME);
        addInput(Syncopaticaption.NAME);
        addInput(Distiller.NAME);
    }
}
