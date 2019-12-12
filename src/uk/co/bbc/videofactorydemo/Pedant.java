package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Pedant extends Component {
    public static final String NAME = "Pedant";

    public Pedant(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Bagpuss.NAME); // loop
        addInput(Lijer.NAME);
    }

    // this is a loop - pedant -> bagpuss -> pedant -> monk
    @Override
    public void emit() {
        loop(this.name, Bagpuss.NAME, Monk.NAME);
//        if (currentMessage.property(Bagpuss.NAME) == null) {
//            Factory.logger.info("Pedant -> Bagpuss");
//            currentMessage.property(Bagpuss.NAME, "done");
//            currentMessage.routeTo(Bagpuss.NAME);
//        } else {
//            Factory.logger.info("Pedant -> Monk");
//            currentMessage.routeTo(Monk.NAME);
//        }
//        Factory.logger.info("Pedant Current Message [{}]", currentMessage);
    }
}
