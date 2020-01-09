package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Pedant extends Component {
    public static final String NAME = "Pedant";
    private static final String DESCRIPTION = "Routes messages depending on accuracy of their start times.";

    public Pedant(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(VideoFactory.BAGPUSS); // loop
        addInput(Lijer.NAME);
    }

    // this is a loop - pedant -> bagpuss -> pedant -> (monk | lovett)
    @Override
    public void emit() {
        // switch depending on whether timing is accurate (random)
        if (p.random(100) < 50) {
            loop(this.name, VideoFactory.BAGPUSS, Monk.NAME);
        } else {
            loop(this.name, VideoFactory.BAGPUSS, Lovett.NAME);
        }
    }
}
