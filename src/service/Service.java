package service;

public class Service {
	private static Service instance = new Service();

	public Service(){
	}

	public static Service getInstance(){
		return instance;
	}
}
