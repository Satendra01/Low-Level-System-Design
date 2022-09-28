package ChainOfResponsibility;

public class Main {
	public static void main(String []args)
	{
		//create chain
		LogProcessor logger=new InfoLogger(new DebugLogger(new ErrorLogger(null)));
		//call log method
		logger.log(LogProcessor.error,"hello");
	}
}
