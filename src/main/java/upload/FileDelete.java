package upload;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import operation.FileOperation;

@WebServlet("/delete")
public class FileDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FileOperation operation;

	public FileDelete() {
		super();
		operation = new FileOperation(this);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// マルチパート取得のため、アップロード用のサーブレットへリダイレクトで遷移する
		response.sendRedirect("upload");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 送信されたファイル一覧を取得して削除するメソッドへ送る
		String[] files = request.getParameterValues("check");
		if (files != null) {
			operation.deleteFile(files);
		}
		doGet(request, response);
	}
}
