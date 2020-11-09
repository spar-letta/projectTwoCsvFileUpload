package com.simiyu.projectTwo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.simiyu.projectTwo.model.FileUpload;
import com.simiyu.projectTwo.utils.CommonUtils;




@Component
public class FileValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return FileUpload.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		FileUpload fileUpload = (FileUpload) target;
		
		CommonsMultipartFile[] multipartFiles = fileUpload.getFiles();
		
		for(CommonsMultipartFile multipartFile : multipartFiles) {
			if(multipartFile.getSize() == 0) {				
				errors.rejectValue("files", "required.file");
				break;
			}
			String fileExtension = CommonUtils.getFileExtension(multipartFile.getOriginalFilename().toLowerCase());
				if(!fileExtension.equals("csv")) {
					errors.rejectValue("files","file.extension.allowed");
					break;
				}
			
		}
	}
}
