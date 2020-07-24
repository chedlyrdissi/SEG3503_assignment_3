package test;

import org.junit.Before;
import org.junit.Test;

import Counter.MarketProxyStub;
import Counter.SocketProxy;
import CounterUI.BarCodeReaderUI;
import CounterUI.CounterFrame;
import Market.BasicServer;
import Market.MarketServer;
import MarketDB.Customer;
import MarketDB.DBManagerStub;
import MarketDB.Employee;
import MarketDB.Item;
import junit.framework.Assert;

public class IntegrationAppGUITest {
	
	private CounterFrame counter;
	private MarketServer market;
	private BasicServer server;
	private BarCodeReaderUI reader;
	private DBManagerStub stub;
	
	@Before
	public void setUp() throws Exception {
		counter = new CounterFrame(new SocketProxy());
	    market=new MarketServer();
	    (new Thread(market)).start();
	    stub = new DBManagerStub();
	    server = new BasicServer(stub);
//	    counter.show();
	    reader = new BarCodeReaderUI();
	    reader.setLocation(100,300);
//	    reader.show();
	    reader.setListener(counter);
	}
	
	private void connect() {
		stub.setEmployee(new Employee(1, "test", "test"));
		counter.employeePassword.setText("test");
		counter.ConnectButton.doClick();
		Assert.assertEquals("Disconnect", counter.ConnectButton.getName());
	}
	@Test
	public void testConnect() throws Exception {
		connect();
//		Thread.sleep(10000);
	}

	@Test
	public void testDisconnect() throws Exception {
		connect();
		counter.ConnectButton.doClick();
		Assert.assertEquals("Connect", counter.ConnectButton.getName());
	}

	@Test
	public void testAcquisition1() throws Exception {
		connect();
//		counter.show();
//		reader.show();
		counter.customerCode.setText("2");
		counter.btCustomer.doClick();
		counter.customerName.setText("name");
		counter.SubmitButton.doClick();
		stub.setItem(new Item(1, "product 1", 1, 1));
		reader.btProduct1.doClick();
		counter.EndButton.doClick();
//		Thread.sleep(10000);
	}

	@Test
	public void testAcquisition2() throws Exception {
		connect();
//		counter.show();
//		reader.show();
		stub.setItem(new Item(1, "product 1", 1, 1));
		reader.btProduct1.doClick();
		counter.EndButton.doClick();
	}

	@Test
	public void testAcquisition3() throws Exception {
		connect();
		stub.setItem(new Item(1, "product 1", 1, 2));
		reader.btProduct1.doClick();
		stub.setItem(new Item(2, "product 2", 1, 1));
		reader.btProduct2.doClick();
		counter.EndButton.doClick();
	}

	@Test
	public void testAcquisition4() throws Exception {
		connect();
		stub.setCustomer(new Customer(1, "customer 1"));
		reader.btCustomer1.doClick();
		stub.setItem(new Item(1, "product 1", 1, 2));
		reader.btProduct1.doClick();
		stub.setItem(new Item(2, "product 2", 1, 2));
		reader.btProduct2.doClick();
		
		counter.EndButton.doClick();
	}
}
