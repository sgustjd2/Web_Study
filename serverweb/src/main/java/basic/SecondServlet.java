package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		// 비즈니스 로직
		for ( int i = 1 ; i < 10; i ++ ) {
			System.out.printf("7 * %d = %d \n", i, 7*i);
		}
	}
	
}
