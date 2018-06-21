package com.el.ally.invoicify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.invoicify.models.Company;
import com.el.ally.invoicify.repositories.CompanyRepository;


@RestController 
@RequestMapping("/api/company")

public class CompanyController {
@Autowired	



  private CompanyRepository companyrepo;
@Autowired


  public CompanyController(CompanyRepository companyrepo) {
    this.companyrepo = companyrepo;
    
  }

  @GetMapping("")
  public List<Company> getAll() {
    return companyrepo.findAll();
  }

  @GetMapping("{id}")
  public Company getOne(@PathVariable int id) {
    return companyrepo.findOne(id);
  }

  @PostMapping("")
  public Company create(@RequestBody Company Company) {
    return companyrepo.save(Company);
  }

  @PutMapping("{id}")
  public Company update(@RequestBody Company Company, @PathVariable int id) {
    Company.setId(id);
    return companyrepo.save(Company);
  }

  @DeleteMapping("{id}")
  public Company delete(@PathVariable int id) {
    Company company = companyrepo.findOne(id);
    companyrepo.delete(id);
    return company;
  }
  
	}


