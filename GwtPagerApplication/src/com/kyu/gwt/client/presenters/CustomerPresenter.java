package com.kyu.gwt.client.presenters;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.kyu.gwt.shared.Customer;

public class CustomerPresenter implements Presenter {

	Display view;
	ArrayList<Customer> customerList;
	
	public interface Display{
		
		public void clear();
		
		public Widget asWidget();
		
		public void setPresenter(CustomerPresenter customerPresenter);
		
		public void fillCustomerTable(ArrayList<Customer> personList);
		
		public Customer getSelectedCustomer();
	}
	
	public CustomerPresenter(ArrayList<Customer> customerList,Display view) {
		// TODO Auto-generated constructor stub
		this.view=view;
		this.customerList=customerList;
		bind();
	}
	@Override
	public void bind() {
		// TODO Auto-generated method stub
		view.clear();
		view.setPresenter(this);
		view.fillCustomerTable(customerList);
	}

	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		container.clear();
		container.add(view.asWidget());
	}

}
