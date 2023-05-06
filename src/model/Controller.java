package model;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private Orders order;
    private Inventory inventory;

    public Controller() {
        this.order = new Orders();
        this.inventory = new Inventory();
    }

    public void load() throws IOException {
        order.load();
        inventory.load();
    }
}
