package edu.ucam.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.classes.Comment;
import edu.ucam.database.LoadDataReferences;
import edu.ucam.database.SaveDataByReference;

/**
 * Servlet implementation class AddComment
 */
@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Comment newComment = new Comment();

		
		newComment = new Comment();
		newComment.setResume(request.getParameter(Comment.COMMENT_RESUME_PARAM));
		newComment.setContent(request.getParameter(Comment.COMMENT_CONTENT_PARAM));
		newComment.setVoteId(request.getParameter(Comment.COMMENT_VOTE_ID_PARAM));
		
		if(newComment.getResume()!=null) {
			ArrayList<String> commentsReferences = new ArrayList<String>();
			LoadDataReferences.loadCommentsReferences(commentsReferences);	
		
			Comment.generateIdByReference(newComment, commentsReferences.get(commentsReferences.size()-1));
			
			SaveDataByReference.Comment(newComment);
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
