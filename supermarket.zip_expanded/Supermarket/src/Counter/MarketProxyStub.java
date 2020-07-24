package Counter;

import java.net.Socket;

import Market.Market;
import Market.MarketStub;

public class MarketProxyStub implements MarketProxy {
	
	private String connect;
	private String name;
	private double price;
	private String customer;
	private boolean exception;
	private boolean numexception;

	public String connect(long employee, String password) throws Exception {
		if (exception) throw new Exception();
		if (numexception) throw new NumberFormatException();
		return connect;
	}
	
	public void setConnect(String c) {
		connect = c;
	}

	public String getName(long item) throws Exception {
		if (exception) throw new Exception();
		if (numexception) throw new NumberFormatException();
		return name;
	}
	
	public void setName(String n){
		name = n;
	}
	
	public double getPrice(long item) throws Exception {
		if (exception) throw new Exception();
		if (numexception) throw new NumberFormatException();
		return 0;
	}
	
	public void setPrice(double p) {price = p;}

	public String getCustomer(long code){
		return customer;
	}
	
	public void setCustomer(String c) {
		customer = c;
	}

	public void startTransaction(long customer, long employee) throws Exception {
		if (exception) throw new Exception();
		if (numexception) throw new NumberFormatException();
	}

	public void buy(long item, long quantity) throws Exception{
		if (exception) throw new Exception();
		if (numexception) throw new NumberFormatException();
	}
	public void endTransaction() throws Exception{
		if (exception) throw new Exception();
		if (numexception) throw new NumberFormatException();
	}
	public void abortTransaction() throws Exception{
		if (exception) throw new Exception();
		if (numexception) throw new NumberFormatException();
	}

	public void disconnect() {}

	public void setException() {exception = true;}
	public void setNumException() {numexception = true;}
}
