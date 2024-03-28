package com.yun.study.springbootstudy.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ImageController {

	@GetMapping(name = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
	public void getImageData(@RequestParam int kokuso) {

	}
}
