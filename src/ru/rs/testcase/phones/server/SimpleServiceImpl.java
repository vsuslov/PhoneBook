package ru.rs.testcase.phones.server;

import ru.rs.testcase.phones.client.services.SimpleService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class SimpleServiceImpl extends RemoteServiceServlet implements
		SimpleService {

	@Override
	public String doDoDo() {
		System.out.println("remote Calling");

		return "Halli Galli";
	}
}
