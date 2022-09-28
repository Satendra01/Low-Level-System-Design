package ChainOfResponsibility;

public class InfoLogger extends LogProcessor{
	
	public InfoLogger(LogProcessor logProcessor) {
		super(logProcessor);
		// TODO Auto-generated constructor stub
	}
	
	public void log(int level,String msg)
	{
		if(level==LogProcessor.info)
		System.out.println("Info-level"+msg);
		else if(logProcessor!=null)
			logProcessor.log(level,msg);
			
	}
	
}
