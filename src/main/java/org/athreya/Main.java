package org.athreya;
import org.athreya.project.impl.DevOps;
import org.athreya.project.interfaces.RsiOmniStore;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import java.lang.reflect.Proxy;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        RsiOmniStore devOps = new DevOps();
        RsiOmniStore proxy = (RsiOmniStore) Proxy.newProxyInstance(RsiOmniStore.class.getClassLoader(),
                new Class[]{RsiOmniStore.class} , new Handler(devOps));
        proxy.work();
        proxy.getNumberOfEmployees();
        proxy.getODCNumber();
        proxy.getDepartmentName();
//        System.out.println("Department Name " + devOps.getDepartmentName());
//        System.out.println("Number of Employees " + devOps.getNumberOfEmployees());
//        System.out.println("ODC Number " + devOps.getODCNumber());
//        System.out.println("Work " );
//        devOps.work();
    }
}