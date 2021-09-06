package controller;

import service.Service;

public class Controller {
	private static Controller instance = new Controller();
	private static Service service = Service.getInstance();

	public Controller(){
	}

	public static Controller getInstance(){
		return instance;
	}
}
