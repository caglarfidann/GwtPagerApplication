package com.kyu.gwt.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CustomerPage extends Composite {

	private static CustomerPageUiBinder uiBinder = GWT
			.create(CustomerPageUiBinder.class);

	interface CustomerPageUiBinder extends UiBinder<Widget, CustomerPage> {
	}

	public CustomerPage() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
