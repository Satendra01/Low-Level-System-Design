package ChainOfResponsibility;

public abstract class LogProcessor {
	 static int info=1;
	 static int debug=2;
	 static int error=3;
	LogProcessor logProcessor;
	public LogProcessor(LogProcessor logProcessor) {
		super();
		this.logProcessor = logProcessor;
	}
	public abstract void log(int level,String msg);
}
