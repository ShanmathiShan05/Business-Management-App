package com.business.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.business.entities.Products;
import com.business.repositories.ProductRepository;
@Component
public class ProductServices 
{
	@Autowired
	private ProductRepository productRepository;

	//add Product
	public void addProduct(Products p)
	{
		this.productRepository.save(p);
	}


	//getAll products
	public List<Products> getAllProducts()
	{
		List<Products> products=(List<Products>)this.productRepository.findAll();
		return products;
	}

	//get Single Product
	public Products getProduct(int id)
	{
		Optional<Products> optional = this.productRepository.findById(id);
		Products product=optional.get();
		return product;
	}

	//update Product
	public void updateproduct(Products p,int id)
	{
		p.setPid(id);
		Optional<Products> optional = this.productRepository.findById(id);
		Products prod=optional.get();

		if(prod.getPid()==id)
		{
			this.productRepository.save(p);				
		}
	}
	//delete product
	public void deleteProduct(int id)
	{
		this.productRepository.deleteById(id);
	}

	//Get Product By Name
	public Products getProductByName(String name)
	{
		
		Products product= this.productRepository.findByPname(name);
		if(product!=null)
		{
			return product;
		}
		return null;
	
	}
}