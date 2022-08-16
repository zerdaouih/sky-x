package org.eyesky.back.domain.enitity;


/**
 * class representing user profil that will contain all information about the user :
 * user detail
 * preferences
 * prestation type ( pilote , videaste , both ... )
 */
public class Profil {

    private EyeSkyUser user;
    private  ServiceProvisionType serviceProvisionType;
    private Preferences preferences;
}
