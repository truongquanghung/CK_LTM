package model.BO;

import model.DAO.AccountDAO;

public class AccountBO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Object getAccount(String id, String pass) {
		return AccountDAO.getAccount(id, pass);
	}

}
