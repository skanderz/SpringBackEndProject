package tn.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.entities.Likee;
import tn.spring.service.ILikeService;



@RestController
@RequestMapping("/like")
public class LikeController {
	@Autowired
	ILikeService likeservice;
	@PostMapping("/add")
	@ResponseBody
	public Likee addlike(@RequestBody Likee c)
	{
	Likee lk =likeservice.addlike(c);
	return lk;
	}

}
