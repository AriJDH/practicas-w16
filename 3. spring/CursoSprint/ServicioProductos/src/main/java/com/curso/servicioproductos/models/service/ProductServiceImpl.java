package com.curso.servicioproductos.models.service;

import com.curso.servicioproductos.models.entity.Product;
import com.curso.servicioproductos.models.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

  @Autowired
  private IProductRepository iProductRepository;



  @Override
  @Transactional(readOnly = true)
  public List<Product> findAll() {
    return (List<Product>) iProductRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)

  public Product findById(Long id) {
    return iProductRepository.findById(id).orElse(null);
  }
}
