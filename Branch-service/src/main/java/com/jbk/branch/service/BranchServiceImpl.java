package com.jbk.branch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.branch.dao.BranchDao;
import com.jbk.branch.entity.Branch;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	BranchDao dao;
	
	@Override
	public boolean saveBranch(Branch branch) {
		boolean value = dao.saveBranch(branch);
		return value;
	}

	@Override
	public Branch getBranch(int branchId) {
		Branch branch = dao.getBranch(branchId);
		return branch;
	}

}
