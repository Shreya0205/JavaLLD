public class InfoLogger extends Logger{

    public InfoLogger(Logger nextLogger) {
        super(nextLogger);
    }

    public void log(LoggerType loggerType, String message){
        if ( loggerType== LoggerType.info){
           System.out.println("INFO: " + message);
        }
        else{
            super.log(loggerType, message);
        }
    }
}
