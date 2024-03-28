package com.yun.study.springbootstudy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yun.study.springbootstudy.bean.ShoppingCartParam;
import com.yun.study.springbootstudy.entity.ShoppingCart;
import com.yun.study.springbootstudy.entity.Thing;
import com.yun.study.springbootstudy.service.ThingService;

@CrossOrigin
@RestController
public class ThingController {

	private ThingService thingService;

	public ThingController(ThingService thingService) {
		super();
		this.thingService = thingService;
	}

	@GetMapping("/things")
	public ResponseEntity<Object> getAllThings() {
		List<Thing> result = thingService.getAllThings();

		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}

	@GetMapping("/shopping-cart")
	public ResponseEntity<Object> getShoppingCartInfo(@RequestParam int userId) {
		List<ShoppingCart> result = thingService.getShoppingCartInfo(userId);

		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}

	@PostMapping("/shopping-cart")
	public ResponseEntity<Object> addToShoppingCart(@RequestBody ShoppingCartParam params) {
		thingService.addToShoppingCart(params);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping("/shopping-cart")
	public ResponseEntity<Object> deleteShoppingCart(@RequestParam Long shoppingCartId) {
		thingService.deleteShoppingCart(shoppingCartId);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
