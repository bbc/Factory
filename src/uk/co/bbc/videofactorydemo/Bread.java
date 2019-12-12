package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Bread extends Component {
    public static final String NAME = "Bread";
    private static final String DESCRIPTION = "Broadcast Received Event Adapter.";

    public Bread(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Rorschach.NAME);
        addInput(Picr.NAME);
        addInput(Copper.NAME);  // loop
        addInput(ToddIn.NAME);
    }

    // this is a loop - Bread -> Copper -> Bread -> Lijer
    @Override
    public void emit() {
        loop(this.name, Copper.NAME, Lijer.NAME);
    }
}
