package com.productapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@RequestMapping("/addForm")
	public String showAddForm() {
		return "addProductForm";
	}
	
	@RequestMapping("/deleteForm")
	public String showDeleteForm() {
		return "deleteProductForm";
	}
	
	@RequestMapping("/editForm")
	public String showEditForm() {
		return "editProductForm";
	}
}
