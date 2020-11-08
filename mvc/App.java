package mvc;

import java.awt.EventQueue;

import mvc.controller.Controller;
import mvc.model.Model;
import mvc.utilities.Phaseable;
import mvc.view.View;

public class App implements Phaseable {

  public Controller controller;
  public Model model;
  public View view;

  public App() {
    trace(this);
    controller = new Controller(this);
    model = new Model(this);
    view = new View(this);
    init();
    run();
    fin();
  }

  public void fin() {
    trace(this);
    controller.fin();
    model.fin();
    view.fin();
  }

  public void init() {
    trace(this);
    controller.init();
    model.init();
    view.init();
  }

  public static void make() {
    EventQueue.invokeLater(() -> {
      new App();
    });
  }

  public void run() {
    trace(this);
    controller.run();
    model.run();
    view.run();
  }

}
