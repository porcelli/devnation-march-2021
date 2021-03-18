package me.porcelli.devnation.demo;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DriversLicenseEmitionService {
    
    public void emit(Applicant applicant){
        System.out.println("Emit drivers license for :" + applicant);
    }

}
