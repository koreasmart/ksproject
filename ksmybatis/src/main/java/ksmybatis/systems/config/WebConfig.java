package ksmybatis.systems.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import ksmybatis.admin.common.interceptor.LogInterceptor;
import ksmybatis.admin.login.interceptor.LoginInterceptor;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer{
	
	@Value("${file.path}")
	private String fileRealPath;
	
	private final LoginInterceptor loginInterceptor;
	private final LogInterceptor logInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/admin/login")
				.excludePathPatterns("/manage/**")
				.excludePathPatterns("/favicon*");
		
		registry.addInterceptor(logInterceptor)
				.addPathPatterns("/admin/**")
				.excludePathPatterns("/manage/**")
				.excludePathPatterns("/favicon*");
				
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		String rootPath = getOSFilePath();
		
		registry.addResourceHandler("/attachment/**")
				.addResourceLocations(rootPath + fileRealPath + "/attachment/")
				.setCachePeriod(3600)
				.resourceChain(true)
				.addResolver(new PathResourceResolver());
		
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
	public String getOSFilePath() {
		String rootPath = "file:///";
		String os = System.getProperty("os.name").toLowerCase();
		
		if(os.contains("win")) {
			rootPath = "file:///d:";
		}else if(os.contains("linux")) {
			rootPath = "file://";
		}else if(os.contains("mac")) {			
			rootPath = "file://";
		}
		
		
		return rootPath;
	}

}
