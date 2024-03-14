package com.dib.Interface;

import com.dib.model.Branch;
import com.dib.model.Customer;

import java.util.List;
import java.util.Optional;

public interface BranchService {
    public Branch saveBranch(Branch branch);

    public List<Branch> getAllBranches();

    public Optional<Branch> getBranchById(int id);

    public Branch updateBranchById(int id,Branch branch);

    public void deleteBranchById(int id);
}
