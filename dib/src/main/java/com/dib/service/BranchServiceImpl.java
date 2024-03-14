package com.dib.service;

import com.dib.Interface.BranchService;
import com.dib.model.Branch;
import com.dib.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
    public BranchRepository branchRepository;

    @Override
    public Branch saveBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    @Override
    public Optional<Branch> getBranchById(int id) {
        return branchRepository.findById(id);
    }

    @Override
    public Branch updateBranchById(int id, Branch branch) {
       if(branchRepository.existsById(id)){
           branch.setId(id);
           return branchRepository.save(branch);
       }
       else {
           throw new RuntimeException("Branch not found with"+ id);
       }
    }


    @Override
    public void deleteBranchById(int id) {
         branchRepository.deleteById(id);

    }
}
