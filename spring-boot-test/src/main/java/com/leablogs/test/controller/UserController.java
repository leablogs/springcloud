package com.leablogs.test.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.leablogs.pojo.User;
import com.leablogs.test.view.PdfExportService;
import com.leablogs.test.view.PdfView;

@Controller
@RequestMapping("/user")
public class UserController {
public ModelAndView	exportPdf(String userName,String note) {
	User user = new User();
//	View view = new PdfView(PdfExportService());
	return new ModelAndView();
}
}