package me.porcelli.devnation.demo;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CanDriveService {

    public boolean canDrive(final Applicant applicant){
        if (applicant.getAge() > 16){
            return true;
        }

        return false;
    }

}
