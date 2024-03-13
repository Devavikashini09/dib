package com.dib.controller;

import com.dib.model.Branch;
import com.dib.repository.BranchRepository;
import com.dib.service.BranchService;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/branches")
public class BranchController {
   @Autowired
    public BranchService branchService;
   @PostMapping
    public ResponseEntity<Branch> saveBranch(@RequestBody  Branch branch)
   {
      return new ResponseEntity<>(branchService.saveBranch(branch), HttpStatus.CREATED);
   }
   @GetMapping
   public List<Branch> getAllBranches(){
       return branchService.getAllBranches();
   }
   @GetMapping("/{id}")
   public ResponseEntity<Branch> getBranchById(@PathVariable int id){
       Optional<Branch> branch=branchService.getBranchById(id);
       return branch.map(ResponseEntity::ok)
               .orElseGet(() -> ResponseEntity.notFound().build());
   }

   @PutMapping("/{id}")
    public ResponseEntity<Branch> updateBranchById(@PathVariable int id,@RequestBody Branch branch){
       return ResponseEntity.ok(branchService.updateBranchById(id,branch));

   }
   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBranchById (@PathVariable int id){
       branchService.deleteBranchById(id);
       return ResponseEntity.noContent().build();

   }



}
