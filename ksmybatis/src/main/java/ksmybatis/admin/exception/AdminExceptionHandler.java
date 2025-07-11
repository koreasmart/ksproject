package ksmybatis.admin.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice(basePackages = {"ksmybatis.admin"})
@Slf4j
public class AdminExceptionHandler {
	
	@ExceptionHandler({
						IllegalArgumentException.class,
						MethodArgumentTypeMismatchException.class,
						MissingServletRequestParameterException.class
					  })
	public String adminBadRequestHandle(HttpServletRequest request, Exception ex, Model model) {
		log.error("AdminExceptionHandler");
		StackTraceElement[] stackTrace = ex.getStackTrace();
		StackTraceElement origin = stackTrace[0];
		log.error("[Exceptoion] {}\n[method]:{} ({}:{}) - message={}",
					origin.getClassName(),
					origin.getMethodName(),
					origin.getFileName(),
					origin.getLineNumber(),
					ex.getMessage()
				 );
		return "error/500";
	}
	
	@ExceptionHandler(Exception.class)
	public String adminGlobalErrorHandle(HttpServletRequest request, Exception ex, Model model) {
	
		log.error("AdminExceptionHandler");
		StackTraceElement[] stackTrace = ex.getStackTrace();
		StackTraceElement origin = stackTrace[0];
		log.error("[Exceptoion] {}\n[method]:{} ({}:{}) - message={}",
					origin.getClassName(),
					origin.getMethodName(),
					origin.getFileName(),
					origin.getLineNumber(),
					ex.getMessage()
				 );
		model.addAttribute("homeUrl", "/admin");
		
		return "error/500";
	}
	
}
















