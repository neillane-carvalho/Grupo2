package usuario;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class UsuarioFiltro
 */

public class UsuarioFiltro implements Filter {

    /**
     * Default constructor. 
     */
    public UsuarioFiltro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		//TUDO QUE VEM ANTES, SER� EXECUTADO ANTES DA SERVLET SER CHAMADA. NA IDA DA REQUISI��O.
		
		String nome= request.getParameter("nome");
		
		if((nome!= null && !nome.equals("")) 
				&& (nome.toUpperCase().equals("MARIA") || nome.toUpperCase().equals("JOAO"))){
			
			response.getWriter().append("Estou indo no meu caminho feliz! "); 
			
			chain.doFilter(request, response);
			
			response.getWriter().append("Estou VOLTANDO do meu caminho feliz! ");
			
			
			
		} else {
			throw new IOException("Nome n�o aceito... ");
		}

		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
