package me.acdean.factory.example;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class FourA extends Component {
    public static final String NAME = "FourA";
    public static final String DESCRIPTION = "4A";

    public FourA(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Three.NAME);
    }

    // reads from s3, processes, writes to s3, continues
    @Override
    public void processMessage() {
        readWorkWriteEmit();
    }
}
