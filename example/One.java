package me.acdean.factory.example;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class One extends Component {
    public static final String NAME = "One";
    public static final String DESCRIPTION = "1";

    public One(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Start.NAME);
        addInput(Two.NAME);  // loop
    }

    // this is a loop
    @Override
    public void emit() {
        loop(this.name, Two.NAME, Three.NAME);
    }
}
