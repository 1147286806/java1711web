package diyigebao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��������ļ���
        //String fileName = req.getParameter("fileName");//a.png  a.txt
        //����ļ��ľ���·��
        //String filePath = getServletContext().getRealPath("/download/" + fileName);
        //�����ļ���MIME����
        //resp.setContentType(getServletContext().getMimeType(fileName));// imge/png  text/plain
        // ������ӦͷContent-Disposition,����������Ը�������ʽ���أ�������ȥ����
        //resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        //��ȡ�ļ�
        //InputStream inputStream = new FileInputStream(filePath);
        //��������--ͨ��response�����������������ͻ�����������
        //OutputStream outputStream = resp.getOutputStream();
        //byte[] buffer = new byte[1024];
        //int length = 0;
        //while ((length = inputStream.read(buffer)) != -1) {
        //   outputStream.write(buffer, 0, length);
        //}
        //outputStream.close();
        //inputStream.close();
		String fileName = req.getParameter("fileName");
		String filePath = getServletContext().getRealPath("/download/" + fileName);
		resp.setContentType(getServletContext().getMimeType(fileName));
		resp.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
		InputStream inputStream = new FileInputStream(filePath);
		OutputStream outputStream = resp.getOutputStream();
		byte[] buffer = new byte[1024];
		int length = 0;
		while ((length = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, length);
		}
		outputStream.close();
		inputStream.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
