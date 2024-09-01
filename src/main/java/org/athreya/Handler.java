package org.athreya;

import org.athreya.project.interfaces.RsiOmniStore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {

    private RsiOmniStore store;

    public Handler(RsiOmniStore store) {
        this.store = store;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if (method.getName().equals("getDepartmentName")) {
            System.out.println("Fetching Department Name");
        } else if (method.getName().equals("getNumberOfEmployees")) {
            System.out.println("Fetching Number of Employees");
        } else if (method.getName().equals("getODCNumber")) {
            System.out.println("Fetching ODC Number");
        } else if (method.getName().equals("work")) {
            System.out.println("Performing Work");
        }
        result = method.invoke(store,args);
        //        System.out.println("Pre processing");
        //        Object result = method.invoke(store,args);
        //        System.out.println("Post processing");
        return result;
    }
}
