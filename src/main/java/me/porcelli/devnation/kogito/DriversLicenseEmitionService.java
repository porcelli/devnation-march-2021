package me.porcelli.devnation.kogito;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DriversLicenseEmitionService {
    
    public void emit(Applicant applicant){
        System.out.println("Emit drivers license for :" + applicant);
    }

}
