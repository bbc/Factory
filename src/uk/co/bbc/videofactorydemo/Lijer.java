package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;
import me.acdean.factory.Message;
import me.acdean.factory.Route;

public class Lijer extends Component {
    public static final String NAME = "Lijer";
    private static final String DESCRIPTION = "Live Ingest Job routER.";

    public Lijer(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Bread.NAME);
    }

    @Override
    public void emit() {
        // split to john
        currentMessage.routeTo(Pedant.NAME);
        factory.addMessage(
                new Message(factory, Route.routeName(this.name, John.NAME))
        );
    }
}
