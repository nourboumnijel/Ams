package com.sip.ams.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.ams.entities.Provider;

@RequestMapping("/Providermvc")
@Controller
public class ProviderControllerTest {


	
@RequestMapping("/list")	

public String providerList(Model m) 

{
	
	
	ArrayList<String> providers=new ArrayList<>();
	providers.add("Samsung");
	providers.add("HP");
	providers.add("Dell");
	m.addAttribute("providers", providers);
	
	
	ArrayList<Provider> objs=new ArrayList<>(); ///list de la class entity Provider et il faut le dec
	objs.add(new Provider("Samsung","US","Sumsung@gmail.com"));
	objs.add(new Provider("HP","US","HP@gmail.com"));
	objs.add(new Provider("Dell","USA","Dell@gmail.com"));
	m.addAttribute("objs", objs);

return "Provider/ListProviders";   // on met le nom de la view

}	
	

@GetMapping("add")
public String addProviderGet() {
	
	return "Provider/addProvider";
	
}

	
	
	
@PostMapping("add")
@ResponseBody
public String addProviderPost(@RequestParam("pname") String name, @RequestParam("padress") String adress, @RequestParam("pemail") String email) 

{
	Provider p=new Provider(name,adress,email);
	System.out.println(p);
	///pour l'ajouter au tableau fournisseur
	
	return  "redirect:list";
	
}
	
	
	
	
	
}

