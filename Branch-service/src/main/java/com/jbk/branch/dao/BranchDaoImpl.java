package com.jbk.branch.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.branch.entity.Branch;

@Repository
public class BranchDaoImpl implements BranchDao {

	@Autowired
	SessionFactory sf;
	
	@Override
	public boolean saveBranch(Branch branch) {
		
		Session session = null;
		boolean value = false;
		
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(branch);
			transaction.commit();
			value = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return value;
	}

	@Override
	public Branch getBranch(int branchId) {
		
		Session session = null;
		Branch branch = null;
		
		try {
			session = sf.openSession();
			branch = session.get(Branch.class, branchId);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return branch;
	}

}
