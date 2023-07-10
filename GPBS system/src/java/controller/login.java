package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import DAO.MemberDAO;
@WebServlet("/loginM")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		String email = req.getParameter("floatingEmail");
		String pass = req.getParameter("floatingPassword");
		
		MemberDAO mDAO = new MemberDAO();
		
		if(mDAO.login(email, pass)) {
			RequestDispatcher rd = req.getRequestDispatcher("memberNoti.jsp");
			rd.include(req, res);
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("loginMem.jsp");
			rd.include(req, res);
		}

}
	
	

}
