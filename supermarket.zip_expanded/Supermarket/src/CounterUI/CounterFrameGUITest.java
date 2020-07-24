package CounterUI;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import Counter.MarketProxyStub;
import junit.framework.Assert;

public class CounterFrameGUITest {
	
	private CounterFrame instance;
	private MarketProxyStub stub;
	
	@Before
	public void setUp() throws Exception {
		stub = new MarketProxyStub();
		// create instance
		this.instance = new CounterFrame(stub);
	}
	
	private void connect() {
		stub.setConnect("test");
		instance.employeePassword.setText("test");
		instance.ConnectButton.doClick();
	}
	
	@Test
	public void textConnect() throws Exception{
		stub.setConnect(null);
		instance.employeePassword.setText("test");
		instance.ConnectButton.doClick();
		connect();
//		hold();
	}
	
	private void hold() throws Exception{
		instance.show();
		Thread.sleep(100000);
	}
	
	@Test
	public void textDisconnect() throws Exception{
		connect();
		instance.show();
		// disconnect
		instance.ConnectButton.doClick();
	}
	
	@Test
	public void textAcquire1() throws Exception{
		connect();
		stub.setCustomer("");
//		hold();
//		instance.SubmitButton.doClick();
//		hold();
		instance.customerCode.setText("1");
		instance.SubmitButton.doClick();
		instance.customerName.setText("test");
		instance.btCustomer.doClick();
		instance.SubmitButton.doClick();
		instance.ItemCode.setText("1");
		stub.setPrice(12);
		stub.setName("item");
		instance.getPrice.doClick();
//		Assert.assertEquals(Double.parseDouble(instance.itemPrice.getText()), 12);
//		Assert.assertEquals("item", instance.itemName.getText());
		instance.EndButton.doClick();
	}
	
	@Test
	public void textAcquire2() throws Exception{
		connect();

		instance.ItemCode.setText("1");
		stub.setPrice(12);
		stub.setName("item");
		instance.getPrice.doClick();
//		Assert.assertEquals(Double.parseDouble(instance.itemPrice.getText()), 12);
//		Assert.assertEquals("item", instance.itemName.getText());
		instance.EndButton.doClick();
	}	
	
	@Test
	public void textAcquire3() throws Exception{
		connect();
		instance.customerCode.setText("0");
		instance.getPrice.doClick();
		instance.ItemCode.setText("1");
		instance.ItemQuantity.setText("3");
		stub.setPrice(12);
		stub.setName("item");
		instance.getPrice.doClick();
		instance.SubmitButton.doClick();
//		Assert.assertEquals(Double.parseDouble(instance.itemPrice.getText()), 12);
//		Assert.assertEquals("item", instance.itemName.getText());
		instance.EndButton.doClick();
	}
	
	@Test
	public void textAcquire4() throws Exception{
		connect();
		instance.customerCode.setText("0");
		instance.ItemCode.setText("1");
		instance.ItemQuantity.setText("3");
		stub.setPrice(12);
		stub.setName("item");
		instance.getPrice.doClick();
		instance.SubmitButton.doClick();
		instance.ItemCode.setText("1");
		instance.ItemQuantity.setText("3");
		stub.setPrice(12);
		stub.setName("item");
		instance.getPrice.doClick();
		instance.SubmitButton.doClick();
//		hold();
//		Assert.assertEquals(Double.parseDouble(instance.itemPrice.getText()), 12);
//		Assert.assertEquals("item", instance.itemName.getText());
		instance.EndButton.doClick();
	}
}
