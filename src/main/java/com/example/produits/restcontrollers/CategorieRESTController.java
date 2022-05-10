package com.example.produits.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.produits.entities.Categorie;
import com.example.produits.service.CategorieService;


@RestController
@RequestMapping("api/cat")
@CrossOrigin
public class CategorieRESTController {
	@Autowired
	CategorieService categorieService;
	@RequestMapping(method = RequestMethod.GET)
	public List<Categorie> getAllCategories() {
		return categorieService.getAllCategories();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Categorie getCategorieById(@PathVariable("id") Long id) {
		return categorieService.getCategorie(id);
	}
	@RequestMapping(method = RequestMethod.POST)
	public Categorie createCategorie(@RequestBody Categorie c) {
	return categorieService.saveCategorie(c);
	}
  
	@RequestMapping(method = RequestMethod.PUT)
	public Categorie updateCategorie(@RequestBody Categorie c)
	{
	return categorieService.updateCategorie(c);
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id)
	{
		categorieService.deleteCategorieById(id);
	}
		

}
