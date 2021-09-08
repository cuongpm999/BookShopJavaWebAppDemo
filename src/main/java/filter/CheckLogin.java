package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "/checkout", "/finish" })
public class CheckLogin implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String username = null;
		if (req.getCookies() != null) {
			Cookie cookies[] = req.getCookies();

			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase("username")) {
					username = cookie.getValue();
					break;
				}
			}
		}

		if (username != null) {
			req.getSession().setAttribute("username", username);
			chain.doFilter(request, response);
		}

		else
			resp.sendRedirect("/BookShop/login");

	}
}
