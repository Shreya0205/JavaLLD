//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Logger logger = new InfoLogger(new DebugLogger(new ErrorLogger(null)));

        logger.log(LoggerType.error, "Exception is raised");
        logger.log(LoggerType.info, "File is saved");
        logger.log(LoggerType.debug, "Debugging");
    }
}