package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

@Deprecated
public class Barrister  extends Component {
    public static final String NAME = "Barrister";
    private static final String DESCRIPTION = "Sends jobs to Quality Control.";

    public Barrister(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(VideoFactory.BLEEPER);
        addInput(Sponge.NAME);
        addInput(Minion.NAME);
        addInput(VideoFactory.ALDUIN);
    }
}
