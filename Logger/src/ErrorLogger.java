public class ErrorLogger extends Logger{

    public ErrorLogger(Logger nextLogger) {
        super(nextLogger);
    }

    public void log(LoggerType loggerType, String message){
        if ( loggerType== LoggerType.error){
            System.out.println("ERROR: " + message);
        }
        else{
            super.log(loggerType, message);
        }
    }
}
