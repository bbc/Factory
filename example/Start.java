package me.acdean.factory.example;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Start extends Component {
    public static final String NAME = "Start";
    public static final String DESCRIPTION = "S";

    public Start(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        type = INPUT;
    }

    @Override
    public void click() {
        factory.addMessage(NAME);
    }
}
