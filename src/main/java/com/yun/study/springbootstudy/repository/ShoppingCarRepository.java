package com.yun.study.springbootstudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yun.study.springbootstudy.entity.ShoppingCart;
import com.yun.study.springbootstudy.entity.Thing;

public interface ShoppingCarRepository  extends JpaRepository<ShoppingCart, Long> {

	List<ShoppingCart> findAllByUserId(int user);

	ShoppingCart findByThingAndUserId(Thing thing, int userId);

}
