package com.jbk.branch.dao;

import com.jbk.branch.entity.Branch;

public interface BranchDao {

	public boolean saveBranch(Branch branch);
	public Branch getBranch(int branchId);
	
}
