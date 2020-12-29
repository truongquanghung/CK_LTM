package models;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class danhsach {
	XSSFWorkbook gv;
	XSSFWorkbook pt;
	XSSFWorkbook dspc;
	XSSFWorkbook dsgs;
	
	public XSSFWorkbook getGv() {
		return gv;
	}
	public void setGv(XSSFWorkbook gv) {
		this.gv = gv;
	}
	public XSSFWorkbook getPt() {
		return pt;
	}
	public void setPt(XSSFWorkbook pt) {
		this.pt = pt;
	}
	public XSSFWorkbook getDspc() {
		return dspc;
	}
	public void setDspc(XSSFWorkbook dspc) {
		this.dspc = dspc;
	}
	public XSSFWorkbook getDsgs() {
		return dsgs;
	}
	public void setDsgs(XSSFWorkbook dsgs) {
		this.dsgs = dsgs;
	}
	public void xuly(String string) {
		try {
			byte[] dsgv, dspt;
			Socket soc = new Socket("localhost",4000);
			
			ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
			gv.write(baos1);
			dsgv = baos1.toByteArray();
			ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
			pt.write(baos2);
			dspt = baos2.toByteArray();
			
			DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
			dos.writeInt(Integer.parseInt(string));
			dos.writeInt(dsgv.length);
			System.out.println(dsgv.length);
			dos.write(dsgv);
			dos.writeInt(dspt.length);
			System.out.println(dspt.length);
			dos.write(dspt);
			
			DataInputStream dis = new DataInputStream(soc.getInputStream());
			
			int length = dis.readInt();
			if (length>0) {
				byte[] pc = new byte[length];
				dis.readFully(pc,0,length);
				ByteArrayInputStream bais = new ByteArrayInputStream(pc);
				this.setDspc(new XSSFWorkbook(bais));
			}
			
			length = dis.readInt();
			if (length>0) {
				byte[] gs = new byte[length];
				dis.readFully(gs,0,length);
				ByteArrayInputStream bais = new ByteArrayInputStream(gs);
				this.setDsgs(new XSSFWorkbook(bais));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}			
	}
}
