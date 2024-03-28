package com.yun.study.springbootstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yun.study.springbootstudy.entity.Thing;

public interface ThingRepository extends JpaRepository<Thing, Long>{

}
