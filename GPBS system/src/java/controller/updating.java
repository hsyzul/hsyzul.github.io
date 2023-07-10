package controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.MemberDAO;

@WebServlet("/updates")
public class updating extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		res.setContentType("text/html");  
        PrintWriter out = res.getWriter();  
 
        String email= req.getParameter("floatingEmail");  
        
        MemberDAO mDAO = new MemberDAO();

        model.Member member = mDAO.getDetail(email);
        
        out.print("<form action='detail' method='get'>"
        		+ "<tr><td><input type='hidden' name='id' value="+member.getId()+"></td></tr>"
        		+ "<tr><td><input type='text' name='name' value="+member.getName()+"></td></tr>"
        		+ "<tr><td><input type='text' name='phone' value="+member.getPhone()+"></td></tr>"
        		+ "<tr><td><input type='text' name='email' value="+member.getEmail()+"></td></tr>"
        		+ "<tr><td><input type='text' name='pass' value="+member.getAdd()+"></td></tr>"
        		+ "<tr><td><input type='submit'></td></tr>"
        		+ "</form>");  
  
        out.close();  
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		res.setContentType("text/html");  
        PrintWriter out = res.getWriter();  
 
        String id = req.getParameter("id");
        String name= req.getParameter("name");
        String phone= req.getParameter("phone");
        String email= req.getParameter("email");
        String add= req.getParameter("add");
        
        MemberDAO mDAO = new MemberDAO();
       
        String result = mDAO.update(id, name, phone, email, add);
        
        out.print(result);  
  
        out.close();  
	}
	
}