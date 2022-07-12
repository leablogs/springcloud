package com.leablogs.feign;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("panda-frame")
@Service
@Component
public interface HelloService {
	@RequestMapping("/hello")
	String hello();

	@RequestMapping(value = "/hello1", method = RequestMethod.GET)
	String hello(@RequestParam("name") String name);

	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	User hello2(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("age") Integer age);

	@RequestMapping(value = "/hello3", method = RequestMethod.POST)
	String hello3(@RequestBody User user);

	@Data
	@AllArgsConstructor
	class User{
		private int id;
		private String name;
		private int age;
	}
}
