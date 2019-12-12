package me.acdean.factory.example;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Two extends Component {
    public static final String NAME = "Two";
    public static final String DESCRIPTION = "2";

    public Two(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(One.NAME);
    }
}
