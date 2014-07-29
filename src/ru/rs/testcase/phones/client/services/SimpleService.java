package ru.rs.testcase.phones.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("qq")
public interface SimpleService extends RemoteService {

	public String doDoDo();

}
