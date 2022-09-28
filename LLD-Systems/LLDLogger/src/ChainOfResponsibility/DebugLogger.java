package ChainOfResponsibility;

public class DebugLogger extends LogProcessor {

	public DebugLogger(LogProcessor logProcessor) {
		super(logProcessor);
		// TODO Auto-generated constructor stub
	}
	public void log(int level,String msg)
	{
		if(LogProcessor.debug==level)
			System.out.println("Debug-Level"+msg);
		else if(logProcessor!=null)
			logProcessor.log(level,msg);
			
	}
}
