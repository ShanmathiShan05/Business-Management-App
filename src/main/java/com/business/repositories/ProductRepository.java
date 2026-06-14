package com.business.repositories;

import org.springframework.data.repository.CrudRepository;
import com.business.entities.Products;

public interface ProductRepository extends CrudRepository<Products,Integer>
{
	public Products findByPname(String name);

}
