package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

@Deprecated
public class Bagpuss extends Component {
    public static final String NAME = "Bagpuss";
    private static final String DESCRIPTION = "Joins mezzanine chunks together.";

    public Bagpuss(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Pedant.NAME);
    }
}
