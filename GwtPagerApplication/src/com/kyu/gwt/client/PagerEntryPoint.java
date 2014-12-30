package com.kyu.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.kyu.gwt.client.presenters.CustomerPresenter;
import com.kyu.gwt.client.presenters.Presenter;
import com.kyu.gwt.client.views.CustomerPage;
import com.kyu.gwt.shared.Customer;

public class PagerEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		Customer customer=new Customer();
		Presenter presenter=new CustomerPresenter(customer.addCustomerList(), new CustomerPage());
		presenter.go(RootPanel.get());
	}

}
