package MarketDB;

public class DBManagerStub implements DBManager{
	
	private boolean exception;
	private Item item;
	private Employee employee;
	private Customer customer;
	private long trans;
	
	@Override
	public Item getItem(long code) {
		return item;
	}
	
	public void setItem(Item i) {
		item = i;
	}

	@Override
	public Employee getEmployee(long code) {
		return employee;
	}

	public void setEmployee(Employee e) {
		employee = e;
	}

	@Override
	public Customer getCustomer(long code) {
		return customer;
	}
	
	public void setCustomer(Customer c) {
		customer = c;
	}
	
	@Override
	public long startTransaction(long customer, long employee) throws Exception {
		if (exception) throw new Exception();
		return trans;
	}
	
	public void setStartTransaction(long t){
		trans = t;
	}

	@Override
	public void abortTransaction(long code) throws Exception {
		if (exception) throw new Exception();
	}

	@Override
	public void closeTransaction(long code) throws Exception {
		if (exception) throw new Exception();
	}

	@Override
	public void buy(long item, long quantity, long transaction) throws Exception {
		if (exception) throw new Exception();
	}

}
