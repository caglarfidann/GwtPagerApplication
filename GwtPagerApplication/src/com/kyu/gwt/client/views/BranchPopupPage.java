package com.kyu.gwt.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Widget;

public class BranchPopupPage extends DialogBox {

	private static BranchPopupPageUiBinder uiBinder = GWT
			.create(BranchPopupPageUiBinder.class);

	interface BranchPopupPageUiBinder extends UiBinder<Widget, BranchPopupPage> {
	}

	public BranchPopupPage() {
		//initWidget(uiBinder.createAndBindUi(this));
		super.setWidget(uiBinder.createAndBindUi(this));
	}

}
