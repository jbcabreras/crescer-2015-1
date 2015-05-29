// define quais paginas o usuario podera acessar sem estar logado no primeiro if


package filmator.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	  @Override
	  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
	      Object controller) throws Exception {

		  String uri = request.getRequestURI();
		  
		  // ---> AQUI
		  
	      if(uri.endsWith("index") || 
	          uri.endsWith("registrar") || 
	          uri.endsWith("erro") || 
	          uri.endsWith("sucesso") || 
	          uri.endsWith("logar") || 
	          uri.contains("resources")){
	    	  
	        return true;
	      }
		  
	      if(request.getSession().getAttribute("usuarioLogado") != null) {
	        return true;
	      }
	      
	      response.sendRedirect("/template/index");
	      return false;
	  }
}