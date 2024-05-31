package com.rvbraga.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("provider/")
public class SupplierController {
	
	@GetMapping("supplier")
	public String home() {
		return "Suplier";
	}

}
