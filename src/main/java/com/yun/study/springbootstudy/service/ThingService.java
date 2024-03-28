package com.yun.study.springbootstudy.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yun.study.springbootstudy.bean.ShoppingCartParam;
import com.yun.study.springbootstudy.entity.ShoppingCart;
import com.yun.study.springbootstudy.entity.Thing;
import com.yun.study.springbootstudy.repository.ShoppingCarRepository;
import com.yun.study.springbootstudy.repository.ThingRepository;

@Service
@Transactional
public class ThingService {

	private ThingRepository thingRepository;

	private ShoppingCarRepository shoppingCarRepository;

	public ThingService(ThingRepository thingRepository, ShoppingCarRepository shoppingCarRepository) {
		super();
		this.thingRepository = thingRepository;
		this.shoppingCarRepository = shoppingCarRepository;
	}

	public List<Thing> getAllThings() {
		return thingRepository.findAll();
	}

	public List<ShoppingCart> getShoppingCartInfo(int userId) {
		return shoppingCarRepository.findAllByUserId(userId);
	}

	public void addToShoppingCart(ShoppingCartParam params) {
		Optional<Thing> thingOpt = thingRepository.findById(params.getThingId());
		Thing thing = thingOpt.get();
		ShoppingCart cart = shoppingCarRepository.findByThingAndUserId(thing, params.getUserId());
		if (Objects.isNull(cart)) {
			cart = new ShoppingCart();
			cart.setThing(thing);
			cart.setUserId(params.getUserId());
			cart.setThingNum(params.getThingNum());
		} else {
			cart.setThingNum(cart.getThingNum() + 1);
		}
		shoppingCarRepository.save(cart);
	}

	public void deleteShoppingCart(Long shoppingCartId) {
		shoppingCarRepository.deleteById(shoppingCartId);
	}
}
