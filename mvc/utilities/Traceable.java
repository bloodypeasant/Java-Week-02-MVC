package mvc.utilities;

public interface Traceable {

  public default void trace(Traceable traceable) {
    String className = traceable.getClass().getName();
    String methodName = new Throwable().getStackTrace()[1].getMethodName();
    if (methodName.equals("<init>")) {
      methodName = "construct";
    }
    System.out.println(methodName + " " + className);
  }

  public static void trace(String className) {
    String methodName = new Throwable().getStackTrace()[1].getMethodName();
    if (methodName.equals("<init>")) {
      methodName = "construct";
    }
    System.out.println(methodName + " " + className);
  }

}
