package diyigebao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LastAccessTimeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.��¼��ǰ�ķ���ʱ�䣬���õ�Cookie����
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = simpleDateFormat.format(date);;
		Cookie cookie = new Cookie("lastAccessTime", time);
		resp.addCookie(cookie);
		
		//2.��ÿͻ���Я����Cookie
		String lastAccessTime = null;
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie coo : cookies) {
				if ("lastAccessTime".equals(coo.getName())) {
					lastAccessTime = coo.getValue();
				}
			}
		}
		
		resp.setContentType("text/html;charset=utf-8");
		if (lastAccessTime == null) {
			resp.getWriter().println("���ǵ�һ�η���");
		} else {
			resp.getWriter().println("���ϴη��ʵ�ʱ�䣺 " + lastAccessTime);
		}
	}

}
