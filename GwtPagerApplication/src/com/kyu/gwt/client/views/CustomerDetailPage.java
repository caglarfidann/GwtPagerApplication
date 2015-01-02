package com.kyu.gwt.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.kyu.gwt.client.presenters.CustomerDetailPresenter;
import com.kyu.gwt.shared.Branch;
import com.kyu.gwt.shared.Customer;

public class CustomerDetailPage extends Composite implements CustomerDetailPresenter.Display{
	private CustomerDetailPresenter detailPresenter;
	private AbsolutePanel absolutePanel;
	private static CustomerDetailPageUiBinder uiBinder = GWT
			.create(CustomerDetailPageUiBinder.class);

	interface CustomerDetailPageUiBinder extends
			UiBinder<Widget, CustomerDetailPage> {
	}

	public CustomerDetailPage() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	private Label titleLabel=new Label("--CUSTOMER DETAIL--");
	private Label customerIDLabel=new Label("Customer ID :");
	private Label customerIDText=new Label();
	
	private Label customerNameLabel=new Label("Customer Name :");
	private Label customerNameText=new Label();
	
	private Label customerSurnameLabel=new Label("Customer ID :");
	private Label customerSurnameText=new Label();
	
	private Label customerMailLabel=new Label("Customer Mail :");
	private Label customerMailText=new Label();
	
	private Label customerBranchLabel=new Label("Customer Branch :");
	private Label customerBranchText=new Label();
	
	private Button backButton=new Button("Back");

	@Override
	public void clear() {
		// TODO Auto-generated method stub
	}

	@Override
	public void setPresenter(CustomerDetailPresenter customerDetailPresenter) {
		// TODO Auto-generated method stub
		this.detailPresenter=customerDetailPresenter;
	}

	@Override
	public void fillInfo(HasWidgets container, Customer customer) {
		// TODO Auto-generated method stub
		int width=Window.getClientWidth();
		int height=Window.getClientHeight();
		absolutePanel = new AbsolutePanel();
		absolutePanel.setSize(String.valueOf(width)+"px",String.valueOf(height)+"px");
		absolutePanel.add(titleLabel,width/2,10);
		
		absolutePanel.add(customerIDLabel,(width/2)-110,40);
		absolutePanel.add(customerIDText,(width/2)+40,40);
		customerIDText.setText(customer.getCustomerID());
		absolutePanel.add(customerNameLabel,(width/2)-110,70);
		absolutePanel.add(customerNameText,(width/2)+40,70);
		customerNameText.setText(customer.getCustomerName());
		absolutePanel.add(customerSurnameLabel,(width/2)-110,100);
		absolutePanel.add(customerSurnameText,(width/2)+40,100);
		customerSurnameText.setText(customer.getCustomerSurname());
		absolutePanel.add(customerMailLabel,(width/2)-110,130);
		absolutePanel.add(customerMailText,(width/2)+40,130);
		customerMailText.setText(customer.getCustomerMail());
		absolutePanel.add(customerBranchLabel,(width/2)-110,160);
		absolutePanel.add(customerBranchText,(width/2)+40,160);
		customerBranchText.setText(customer.getCustomerBranch());
		absolutePanel.add(backButton,width/2,190);
		
		container.add(absolutePanel);
	}

	@Override
	public Button getBackButton() {
		// TODO Auto-generated method stub
		return backButton;
	}
}
