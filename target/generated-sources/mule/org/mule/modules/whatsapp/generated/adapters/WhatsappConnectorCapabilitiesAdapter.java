
package org.mule.modules.whatsapp.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.devkit.capability.Capabilities;
import org.mule.api.devkit.capability.ModuleCapability;
import org.mule.modules.whatsapp.WhatsappConnector;


/**
 * A <code>WhatsappConnectorCapabilitiesAdapter</code> is a wrapper around {@link WhatsappConnector } that implements {@link org.mule.api.Capabilities} interface.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2018-08-02T05:23:51+05:30", comments = "Build UNNAMED.2793.f49b6c7")
public class WhatsappConnectorCapabilitiesAdapter
    extends WhatsappConnector
    implements Capabilities
{


    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(ModuleCapability capability) {
        if (capability == ModuleCapability.LIFECYCLE_CAPABLE) {
            return true;
        }
        return false;
    }

}
