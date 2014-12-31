package com.kyu.gwt.shared;

import java.util.ArrayList;

public class Branch {
	private String BranchID;
	private String BranchName;
	private String BranchLocation;
	
	public String getBranchID() {
		return BranchID;
	}
	public void setBranchID(String branchID) {
		BranchID = branchID;
	}
	public String getBranchName() {
		return BranchName;
	}
	public void setBranchName(String branchName) {
		BranchName = branchName;
	}
	public String getBranchLocation() {
		return BranchLocation;
	}
	public void setBranchLocation(String branchLocation) {
		BranchLocation = branchLocation;
	}
	
	public ArrayList<Branch> addBranchList(){
		Branch branch;
		ArrayList<Branch> branch_temp=new ArrayList<Branch>();
		for(int i=1;i<6;i++){
			branch = new Branch();
			branch.setBranchID("10"+(i));
			branch.setBranchName("Branch"+i);
			branch.setBranchLocation("City"+i);
			branch_temp.add(branch);
		}
		return branch_temp;
	}
}
