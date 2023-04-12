package net.board.action;

// 전송방식을 결정하는 클래스
public class ActionForward {
// 포워드 , 리다이렉트
	private boolean isRedirect = false; // redirect인지 foward인지 
	private String path = null; // 실제 저장할 페이지 주소를 담는 변수 
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
