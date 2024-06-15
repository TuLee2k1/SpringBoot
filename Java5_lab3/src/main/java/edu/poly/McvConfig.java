package edu.poly;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class McvConfig implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
	public void exposeDirectory(String dirName,ResourceHandlerRegistry registry) {
		Path uploadDirPath = Paths.get(dirName);
		String uploadPath = uploadDirPath.toFile().getAbsolutePath();
		if (dirName.startsWith("../")) {
			dirName = dirName.replace("../", "");
		}
		
		registry.addResourceHandler("/"+dirName+"/**").addResourceLocations("File :/"+uploadPath+"/");
	}
}
