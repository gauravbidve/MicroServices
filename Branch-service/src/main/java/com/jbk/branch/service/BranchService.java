package com.jbk.branch.service;

import com.jbk.branch.entity.Branch;

public interface BranchService {

	public boolean saveBranch(Branch branch);
	public Branch getBranch(int branchId);
	
}
