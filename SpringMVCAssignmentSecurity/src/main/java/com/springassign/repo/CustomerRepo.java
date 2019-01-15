package com.springassign.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springassign.model.Customers;

public interface CustomerRepo extends JpaRepository<Customers, Integer> {

}
