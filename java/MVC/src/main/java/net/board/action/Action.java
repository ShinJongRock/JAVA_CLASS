package net.board.action;



import javax.servlet.http.*;

public interface Action {
    public ActionFoward execute(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception;
}