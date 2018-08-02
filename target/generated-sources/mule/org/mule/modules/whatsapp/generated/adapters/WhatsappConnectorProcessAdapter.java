
package org.mule.modules.whatsapp.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.whatsapp.WhatsappConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>WhatsappConnectorProcessAdapter</code> is a wrapper around {@link WhatsappConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2018-08-02T05:23:51+05:30", comments = "Build UNNAMED.2793.f49b6c7")
public class WhatsappConnectorProcessAdapter
    extends WhatsappConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<WhatsappConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, WhatsappConnectorCapabilitiesAdapter> getProcessTemplate() {
        final WhatsappConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,WhatsappConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, WhatsappConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, WhatsappConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
