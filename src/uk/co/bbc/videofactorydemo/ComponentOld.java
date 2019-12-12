package uk.co.bbc.videofactorydemo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import me.acdean.factory.Main;
import me.acdean.factory.Message;
import me.acdean.factory.Route;
import static processing.core.PApplet.BOTTOM;
import static processing.core.PApplet.LEFT;

@Deprecated // now in me.acdean.factory
public class ComponentOld {

    // size of component
    public static final int WIDTH = 120;
    public static final int HEIGHT = 90;

    Main parent;
    public List<String> inputs = new ArrayList<>();
    public List<String> outputs = new ArrayList<>();
    public Queue<Message> incoming = new ArrayDeque<>();    // waiting messages
    public Queue<Action> actions = new ArrayDeque<>();      // actions to do for current message
    public String name;
    public int x, y;  // position
    int colour;
    Message currentMessage;

    ComponentOld(Main papplet, int x, int y, String name) {
        parent = papplet;
        this.x = x;
        this.y = y;
        this.name = name;
    }

    final void addInput(String inputName) {
        inputs.add(inputName);
    }

    public void draw() {
        parent.fill(255);
        parent.rect(x, y, WIDTH, HEIGHT);
        parent.stroke(0);
        parent.fill(0);
        parent.textAlign(LEFT, BOTTOM);
        parent.text(name, x - WIDTH / 2 + 5, y + HEIGHT / 2 + 25);
    }

    public void tick() {
        if (actions.size() == 0) {
            // currently inactive so read next message
            if (incoming.size() != 0) {
                currentMessage = incoming.poll();
                // add actions for this message
                processMessage();
            }
        }
        // do next action
        if (actions.size() != 0) {
            Action action = actions.remove();
            switch (action.type) {
                case Action.PAUSE:
                    Main.println("PAUSE");
                    break;
                case Action.READ_FROM_S3:
                    Main.println("READ_FROM_S3");
                    break;
                case Action.WRITE_TO_S3:
                    Main.println("WRITE_TO_S3");
                    break;
                case Action.READ_FROM_PIPS:
                    Main.println("WRITE_FROM_PIPS");
                    break;
                case Action.WRITE_TO_PIPS:
                    Main.println("WRITE_TO_PIPS");
                    break;
                case Action.EMIT:
                    Main.println("EMIT");
                    emit();
                    break;
            }
        }
    }

    // add action to actions queue based on emssage type
    void processMessage() {
        Main.println("ProcessMessage");
        // example
//        add(Action.PAUSE, 5);
//        add(Action.READ_FROM_S3, 10);
//        add(Action.PAUSE, 5);
//        add(Action.READ_FROM_S3, 10);
//        add(Action.PAUSE, 5);
        add(Action.EMIT, 1);
        Main.println("Actions: ", actions.size());
    }

    void add(int type, int count) {
        for (int i = 0 ; i < count ; i++) {
            actions.add(new Action(type));
        }
    }

    void emit() {
        // if there's only one output we know where it's going
        if (outputs != null && outputs.size() == 1) {
            String queueName = this.name + "_" + outputs.get(0);
            Main.println("QueueName", queueName);
            // change current message route and reset timing
            currentMessage.route(Route.routeName(this.name, outputs.get(0)));
            currentMessage.delay(0);
        }
    }

    // use the DESTINATION property to choose next route
    void routeToDestination() {
        routeToProperty(Message.Property.DESTINATION);
    }
    // use the given property to choose next route
    void routeToProperty(String propertyName) {
        routeToProperty(propertyName, null);
    }
    // ditto but with a default in case property isn't defined
    void routeToProperty(String propertyName, String defaultRoute) {
        String destination = currentMessage.property(propertyName);
        if (destination == null && defaultRoute != null) {
            destination = defaultRoute;
        }
        Main.println(Pleasant.NAME, "Destination:", destination);
        currentMessage.route(Route.routeName(this.name, destination));
        currentMessage.delay(0);
    }

    class Action {
        public static final int PAUSE = 0;
        public static final int READ_FROM_S3 = 1;
        public static final int WRITE_TO_S3 = 2;
        public static final int READ_FROM_PIPS = 3;
        public static final int WRITE_TO_PIPS = 4;
        public static final int EMIT = 99;
        int type;
        private int length;

        Action(int type) {
            this.type = type;
        }
    }
}
