package com.simiyu.projectTwo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simiyu.projectTwo.model.FileUpload;
import com.simiyu.projectTwo.model.User;
import com.simiyu.projectTwo.service.UserService;
import com.simiyu.projectTwo.validator.FileValidator;
/**
 * 
 * @author simiyu
 *
 */

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	FileValidator fileValidator;
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public ModelAndView dataPage() {
		List<User> user = userService.findAll();
		
		ModelAndView model = new ModelAndView("list_page");				
		
		model.addObject("user", user);
		
		return model;
	}
	
	@RequestMapping(value="/uploadPage", method=RequestMethod.GET)
	public ModelAndView uploadPage() {
		
		ModelAndView model = new ModelAndView("upload_page");
		
		FileUpload formUpload = new FileUpload();
		
		model.addObject("formUpload", formUpload);
		
		return model;
	}
	
	@RequestMapping(value="/doUpload", method=RequestMethod.POST)
	public String doUpload(@ModelAttribute("formUpload") FileUpload fileUpload, BindingResult result, RedirectAttributes redirectAttributes) throws IOException {
		fileValidator.validate(fileUpload, result);
		
		if(result.hasErrors()) {
			return "upload_page";
		}else {
			redirectAttributes.addFlashAttribute("filenames",uploadAndImportDb(fileUpload) );
			return "redirect:/success";
		}
	}
	@RequestMapping(value="/success", method=RequestMethod.GET)
	public String successpage() {		
		
		return "success";
	}
	
	private List<String> uploadAndImportDb(FileUpload fileUpload) throws IOException{
		List<String> filenames = new ArrayList<String>();
		List<String> paths = new ArrayList<String>();
		CommonsMultipartFile[] CommonsMultipartFiles = fileUpload.getFiles();
		
		String filePath = null;
		
		for(CommonsMultipartFile commonsMultipartFile : CommonsMultipartFiles) {
			filePath = "C:\\upload\\" + commonsMultipartFile.getOriginalFilename();
			File file = new File(filePath);
			FileCopyUtils.copy(commonsMultipartFile.getBytes(), file);
			filenames.add(commonsMultipartFile.getOriginalFilename());
			
			paths.add(filePath);			
		}
		userService.process(paths);
		return filenames;
	}
}
