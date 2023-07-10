package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.swing.JOptionPane;

import model.Member;
import DAO.AdminDAO;
import DAO.MemberDAO;

@WebServlet("/Register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String member;  
	private MemberDAO dao;
	RequestDispatcher view;
	private String forward;
	
    public RegisterController() {
        super();
        dao=new MemberDAO();
       
    }

	


	
public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String ssmNumber = req.getParameter("ssmNumber");
		String licenseNumber = req.getParameter("licenseNumber");
		String memberFullName = req.getParameter("memberFullName");
		String memberAddress = req.getParameter("memberAddress");
		String memberEmail = req.getParameter("memberEmail");
		String memberPhone = req.getParameter("memberPhone");
		String memberDOB = req.getParameter("memberDOB");
		String memberGender = req.getParameter("memberGender");
		
		Member member = new Member(ssmNumber, memberFullName, memberAddress, memberEmail, memberPhone, memberGender, memberDOB, licenseNumber);
		
		MemberDAO mDAO = new MemberDAO();
		
		String result = mDAO.insert(member);
		
		PrintWriter out = res.getWriter();
		
		out.println(result);
		
	}
	

		
		
	

}
