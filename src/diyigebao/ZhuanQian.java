package diyigebao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ZhuanQian extends HttpServlet{
	private int money = 1000;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		synchronized (this) {
			if (money >= 1000) {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			money -= 1000;
		}
		 resp.setContentType("text/html;charset=utf-8");
         PrintWriter printWriter = resp.getWriter();
         printWriter.println("ʣ�ࣺ" + money);
		}
	}
}
