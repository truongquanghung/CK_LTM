package model.BO;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.imageio.ImageIO;

public class PictureBO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static BufferedImage get(BufferedImage img_old) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(img_old, "jpg", baos);
			byte[] bytes = baos.toByteArray();
			try {
				Socket soc = new Socket("localhost",4000);
				DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
				dos.writeInt(bytes.length);
				dos.write(bytes);
				DataInputStream dis = new DataInputStream(soc.getInputStream());
				int length = dis.readInt();
				if (length>0) {
					bytes = new byte[length];
					dis.readFully(bytes,0,length);
				}
				ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
				BufferedImage img_new = ImageIO.read(bais);
				soc.close();
				return img_new;
			} catch (Exception e) {
				// TODO: handle exception
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
