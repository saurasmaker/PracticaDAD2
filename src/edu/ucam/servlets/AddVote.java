package edu.ucam.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.classes.Vote;
import edu.ucam.database.LoadDataReferences;
import edu.ucam.database.SaveDataByReference;

/**
 * Servlet implementation class AddVote
 */
@WebServlet("/AddVote")
public class AddVote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Vote newVote = new Vote();
		newVote.setProductId(request.getParameter(Vote.VOTE_PRODUCT_PARAM));
		newVote.setUserId(request.getParameter(Vote.VOTE_USER_PARAM));
		String assessment = request.getParameter(Vote.VOTE_ASSESSMENT_PARAM);				
		try {newVote.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter(Vote.VOTE_DATE_PARAM)));}catch(Exception t) {newVote.setDate(null);}
		
		
		if(assessment!=null) {
			newVote.setAssessment(Integer.parseInt(assessment));
						
			ArrayList<String> votesReferences = new ArrayList<String>();
			LoadDataReferences.loadVotesReferences(votesReferences);	
		
			Vote.generateIdByReference(newVote, votesReferences);
			
			SaveDataByReference.Vote(newVote);
		}
		
		request.getRequestDispatcher("/GoTo?GO_TO=/src/administer.jsp").forward(request, response);
		
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
