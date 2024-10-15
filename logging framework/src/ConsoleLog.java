public class ConsoleLog implements OutputInterface{
    public void appendLog(Log log){
        System.out.println("DB log: " + log.text + " Log level: " + log.loglevel);
    }
}
