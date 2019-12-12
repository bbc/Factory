package me.acdean.factory.example;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;
import me.acdean.factory.Message;
import me.acdean.factory.Route;

public class Three extends Component {
    public static final String NAME = "Three";
    public static final String DESCRIPTION = "3";

    public Three(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(One.NAME);
    }

    // split into two messages
    @Override
    public void emit() {
        currentMessage.routeTo(FourA.NAME);
        factory.addMessage(
                new Message(factory, Route.routeName(this.name, FourB.NAME))
        );
    }
}
