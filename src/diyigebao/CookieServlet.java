package diyigebao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = new Cookie("goods", "IPhone7");
		cookie.setMaxAge(20);
		resp.addCookie(cookie);
		Cookie cookie2 = new Cookie("name", "zhangsan");
		resp.addCookie(cookie2);
	}
}
