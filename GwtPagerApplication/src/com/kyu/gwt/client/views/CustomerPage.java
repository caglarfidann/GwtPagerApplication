package com.kyu.gwt.client.views;

import java.util.ArrayList;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.kyu.gwt.client.presenters.CustomerPresenter;
import com.kyu.gwt.shared.Customer;

public class CustomerPage extends Composite implements
		CustomerPresenter.Display {
	private CustomerPresenter customerPresenter;
	public static Customer SelectedCustomer;
	private static CustomerPageUiBinder uiBinder = GWT
			.create(CustomerPageUiBinder.class);

	interface CustomerPageUiBinder extends UiBinder<Widget, CustomerPage> {
	}

	public CustomerPage() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	CellTable<Customer> customerCellTable;
	@UiField
	HTMLPanel htmlPanel;
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		customerCellTable.setRowCount(0);
	}

	@Override
	public void setPresenter(CustomerPresenter customerPresenter) {
		// TODO Auto-generated method stub
		this.customerPresenter = customerPresenter;
	}

	@Override
	public void fillCustomerTable(ArrayList<Customer> customerList) {
		// TODO Auto-generated method stub
		TextColumn<Customer> CustomerID = new TextColumn<Customer>() {
			@Override
			public String getValue(Customer object) {
				return object.getCustomerID();
			}
		};

		TextColumn<Customer> CustomerName = new TextColumn<Customer>() {
			@Override
			public String getValue(Customer object) {
				return object.getCustomerName();
			}
		};

		TextColumn<Customer> CustomerSurname = new TextColumn<Customer>() {
			@Override
			public String getValue(Customer object) {
				return object.getCustomerSurname();
			}
		};

		TextColumn<Customer> CustomerMail = new TextColumn<Customer>() {
			@Override
			public String getValue(Customer object) {
				return object.getCustomerMail();
			}
		};

		Column<Customer, String> BranchbuttonColumn = new Column<Customer, String>(
				new ButtonCell()) {
			@Override
			public String getValue(Customer object) {
				return "Branch";
			}
		};
		BranchbuttonColumn.setFieldUpdater(new FieldUpdater<Customer, String>() {
			@Override
			public void update(int index, Customer object, String value) {
				SelectedCustomer=object;
				BranchPopUpPage asd=new BranchPopUpPage(SelectedCustomer);
				asd.show();
				//Window.alert(object.getCustomerID());
			}
		});
		
		Column<Customer, String> DisplaybuttonColumn = new Column<Customer, String>(
				new ButtonCell()) {
			@Override
			public String getValue(Customer object) {
				return "Display";
			}
		};
		DisplaybuttonColumn.setFieldUpdater(new FieldUpdater<Customer, String>() {
			@Override
			public void update(int index, Customer object, String value) {
				SelectedCustomer=object;
				Window.alert(object.getCustomerBranch());
			}
		});
		customerCellTable.addColumn(CustomerID, "Customer ID");
		customerCellTable.addColumn(CustomerName, "Customer Name");
		customerCellTable.addColumn(CustomerSurname, "CustomerSurname");
		customerCellTable.addColumn(CustomerMail, "Customer E-Mail");
		customerCellTable.addColumn(BranchbuttonColumn,SafeHtmlUtils.fromSafeConstant("<br/>"));
		customerCellTable.addColumn(DisplaybuttonColumn,SafeHtmlUtils.fromSafeConstant("<br/>"));
		customerCellTable.setRowCount(customerList.size(), true);
		customerCellTable.setRowData(0, customerList);
		ListDataProvider<Customer> dataProvider = new ListDataProvider<Customer>();
		dataProvider.addDataDisplay(customerCellTable);
	    dataProvider.setList(customerList);
	    SimplePager pager = new SimplePager();
	    pager.setDisplay(customerCellTable);
	    pager.setPageSize(7);
	    htmlPanel.add(pager);
	}

	@Override
	public Customer getSelectedCustomer() {
		// TODO Auto-generated method stub
		return SelectedCustomer;
	}

}
