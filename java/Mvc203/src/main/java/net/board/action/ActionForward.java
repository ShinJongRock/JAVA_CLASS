package net.board.action;

// ���۹���� �����ϴ� Ŭ����
public class ActionForward {
// ������ , �����̷�Ʈ
	private boolean isRedirect = false; // redirect���� foward���� 
	private String path = null; // ���� ������ ������ �ּҸ� ��� ���� 
	
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
