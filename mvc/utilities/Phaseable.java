package mvc.utilities;

public interface Phaseable extends Traceable {

  public default void fin() {
    trace(this);
  }

  public default void init() {
    trace(this);
  }

  public default void run() {
    trace(this);
  };

}