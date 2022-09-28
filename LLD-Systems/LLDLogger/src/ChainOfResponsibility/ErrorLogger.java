package ChainOfResponsibility;

public class ErrorLogger extends LogProcessor {

	public ErrorLogger(LogProcessor logProcessor) {
		super(logProcessor);
		// TODO Auto-generated constructor stub
	}
	public void log(int level,String msg)
	{
		if( LogProcessor.error==level)
			System.out.println("Debug-Level"+msg);
		else 
			System.out.println("None-Level");
			
	}
}