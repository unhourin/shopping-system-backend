package com.yun.study.springbootstudy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartParam {
    private Long thingId;

	private int userId;

	private int thingNum;
}
