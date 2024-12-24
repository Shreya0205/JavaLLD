public class DebugLogger extends Logger{

    public DebugLogger(Logger nextLogger) {
        super(nextLogger);
    }

    public void log(LoggerType loggerType, String message){
        if ( loggerType== LoggerType.debug){
            System.out.println("DEBUG: " + message);
        }
        else{
            super.log(loggerType, message);
        }
    }
}
