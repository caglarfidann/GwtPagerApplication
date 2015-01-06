package com.kyu.gwt.client.views;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.kyu.gwt.shared.Branch;
import com.kyu.gwt.shared.Customer;

public class BranchPopUpPage extends DialogBox {

	private static BranchPopUpPageUiBinder uiBinder = GWT
			.create(BranchPopUpPageUiBinder.class);

	interface BranchPopUpPageUiBinder extends UiBinder<Widget, BranchPopUpPage> {
	}
	Customer customer;
	Branch branch;
    Label customerLabel=new Label("Customer: ");
    Label customerText=new Label();
    Label branchLabel=new Label("Branch: ");
    ListBox branchList=new ListBox(false);
    Button selectButton=new Button("Select");
    Button backButton=new Button("Close");
    Label resultLabel=new Label();
	public BranchPopUpPage(Customer customer) {
		setWidget(uiBinder.createAndBindUi(this));
		this.customer=customer;
		branch=new Branch();
        onInitialize(this);
        
	}
	@UiField
	AbsolutePanel absolutePanel;
	public void onInitialize(final DialogBox box){		
		box.center();
		box.setStyleName("gwt-Bold-DialogBox");
		box.setText("BRANCH");
		absolutePanel.setSize("400px", "250px");
		absolutePanel.add(customerLabel,15,10);
		customerText.setText(customer.getCustomerName()+" "+customer.getCustomerSurname());
		absolutePanel.add(customerText,105,10);
		absolutePanel.add(branchLabel,15,40);
		fillList(branchList,branch.addBranchList());
		absolutePanel.add(branchList,105,40);
		absolutePanel.add(selectButton,60,70);
		absolutePanel.add(backButton,160,70);
		absolutePanel.add(resultLabel,70,100);
		box.setAnimationEnabled(true);
		box.setAutoHideEnabled(false);	
		box.setGlassEnabled(true);	
		selectButton.addClickHandler(new ClickHandler() {	
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				try {
					customer.setCustomerBranch(branchList.getItemText(branchList.getSelectedIndex()));	
					resultLabel.setText("Islem Basarili!!");
				} catch (Exception e) {
					resultLabel.setText("Islem Sirasinda Hata Olustu!!");
				}
				
			}
		});
		
		backButton.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				box.hide();
			}
		});
	}
	
	public void fillList(ListBox branchList,ArrayList<Branch> branchArrayList){
		for (int i = 0; i < branchArrayList.size(); i++) {
			branchList.addItem(branchArrayList.get(i).getBranchName());
		}
	}
	

}
