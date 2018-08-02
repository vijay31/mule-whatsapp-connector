
package org.mule.modules.whatsapp.generated.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/whatsapp</code>.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2018-08-02T05:23:51+05:30", comments = "Build UNNAMED.2793.f49b6c7")
public class WhatsappNamespaceHandler
    extends NamespaceHandlerSupport
{

    private static Logger logger = LoggerFactory.getLogger(WhatsappNamespaceHandler.class);

    private void handleException(String beanName, String beanScope, NoClassDefFoundError noClassDefFoundError) {
        String muleVersion = "";
        try {
            muleVersion = MuleManifest.getProductVersion();
        } catch (Exception _x) {
            logger.error("Problem while reading mule version");
        }
        logger.error(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [whatsapp] is not supported in mule ")+ muleVersion));
        throw new FatalBeanException(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [whatsapp] is not supported in mule ")+ muleVersion), noClassDefFoundError);
    }

    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        try {
            this.registerBeanDefinitionParser("config", new WhatsappConnectorConnectorConfigConfigDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("config", "@Config", ex);
        }
        try {
            this.registerBeanDefinitionParser("send-message", new SendMessageDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("send-message", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("read-message", new ReadMessageDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("read-message", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("set-webhook-url", new SetWebhookUrlDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("set-webhook-url", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-webhook-url", new GetWebhookUrlDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-webhook-url", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("logout", new LogoutDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("logout", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("reboot", new RebootDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("reboot", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("show-messages-queue", new ShowMessagesQueueDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("show-messages-queue", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("clear-messages-queue", new ClearMessagesQueueDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("clear-messages-queue", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("status", new StatusDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("status", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-q-r-code", new GetQRCodeDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-q-r-code", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-group", new CreateGroupDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-group", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("send-file", new SendFileDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("send-file", "@Processor", ex);
        }
    }

}
