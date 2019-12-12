package me.acdean.factory.example;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Five extends Component {
    public static final String NAME = "Five";
    public static final String DESCRIPTION = "5";

    public Five(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(FourA.NAME);
        addInput(FourB.NAME);
    }
}
