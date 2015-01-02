package com.kyu.gwt.client.presenters;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.kyu.gwt.client.views.CustomerPage;
import com.kyu.gwt.shared.Customer;

public class CustomerDetailPresenter implements Presenter {

	Display view;
	Customer customer;
	ArrayList<Customer> customerList;
	public interface Display{
		
		public void clear();
		
		public Widget asWidget();
		
		public void setPresenter(CustomerDetailPresenter customerDetailPresenter);
		
		public void fillInfo(HasWidgets container,Customer customer);
		
		public Button getBackButton();
	}
	public CustomerDetailPresenter(ArrayList<Customer> customerList,Customer customer,Display view) {
		// TODO Auto-generated constructor stub
		this.view=view;
		this.customer=customer;
		this.customerList=customerList;
		bind();
	}
	@Override
	public void bind() {
		// TODO Auto-generated method stub
		view.clear();
		view.setPresenter(this);	
		view.getBackButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Presenter presenter=new CustomerPresenter(customerList, new CustomerPage());
				presenter.go(RootPanel.get());
			}
		});
	}

	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		container.clear();
		container.add(view.asWidget());
		view.fillInfo(container,customer);
	}
}
