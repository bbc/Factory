package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Paulette extends Component {
    public static final String NAME = "Paulette";
    private static final String DESCRIPTION = "A smaller Paul.";

    public Paulette(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Rosetta.NAME);
        addInput(Mdj.NAME); // loop
        addInput(SubtitlePaulette.NAME);
    }

    // this is a loop - paulette -> mdj -> paulette -> mami
    @Override
    public void emit() {
        loop(this.name, Mdj.NAME, Mami.NAME);
    }
}
