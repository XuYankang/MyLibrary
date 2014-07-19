package nlp.util;

public class ErrorReport {
    //      private static Logger logger = Logger
    //                      .getLogger(ErrorReport.class.getName());

    public static void showMessage(String msg) {
        //              logger.error("Error: " + msg);
        System.err.println("Error: " + msg);
    }

    public static void showMessage(Object errobj, String methodName) {
        //                      logger.error("Error in class: " + errobj.getClass().getName()
        //                              + "\tMethod: " + methodName);
        System.err.println("Error in class: " + errobj.getClass().getName()
                + "\tMethod: " + methodName);
    }

    public static void showMessage(Object errobj, String methodName,
                                   String addition) {
        //              logger.error("Error in class: " + errobj.getClass().getName()
        //                              + "\tMethod: " + methodName + "\tAddition: " + addition);
        System.err.println("Error in class: " + errobj.getClass().getName()
                + "\tMethod: " + methodName + "\tAddition: " + addition);
    }
}