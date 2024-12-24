public abstract class Logger {

    private Logger nextLogger;

    public Logger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void log(LoggerType loggerType, String message){
        if(loggerType!=null){
            this.nextLogger.log(loggerType, message);
        }
    }
}
