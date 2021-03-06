package com.jbk.branch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.branch.entity.Branch;
import com.jbk.branch.service.BranchService;

@RestController
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	BranchService service;

	@PostMapping("/saveBranch")
	public ResponseEntity<String> saveBranch(@RequestBody Branch branch) {

		boolean value = service.saveBranch(branch);

		if (value) {
			return new ResponseEntity<String>("Saved...!!!", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Something went wrong...!!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getBranch")
	public ResponseEntity<Branch> getBranch(@RequestParam int branchId) {

		Branch branch = service.getBranch(branchId);

		if (branch != null) {
			return new ResponseEntity<Branch>(branch, HttpStatus.OK);
		} else {
			return new ResponseEntity<Branch>(branch, HttpStatus.NO_CONTENT);
		}

	}
}