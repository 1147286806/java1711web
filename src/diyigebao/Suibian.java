package diyigebao;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Suibian extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		
		
		resp.setContentType("text/html");
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String nowTime = simpleDateFormat.format(date);
		PrintWriter printWriter =resp.getWriter();
		printWriter.println("<p>" + nowTime + "</p>");
		printWriter.close();
	}
}
