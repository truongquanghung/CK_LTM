package model.BO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ExpressionBO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String calculate(String bt) {
		try {
			Socket soc = new Socket("localhost", 3000);
			DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
			dos.writeUTF(bt);
			DataInputStream dis = new DataInputStream(soc.getInputStream());
			String s = bt + "=" + dis.readUTF();
			if (bt.isEmpty())
				s = "Bạn chưa nhập biểu thức!";
			System.out.println(s);
			soc.close();
			return s;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Lỗi kết nối Server";
	}
	
}
