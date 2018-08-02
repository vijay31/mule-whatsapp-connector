/**
 *
 */
package org.mule.modules.whatsapp.model;

public class WebhookRequest {
	
	private boolean set;
	
	String webhookUrl;
	
	public WebhookRequest(){
		set = true;
	}
	
	public WebhookRequest(String webhookUrl){
		this.webhookUrl = webhookUrl;
		set = true;
	}

	/**
	 * @return the set
	 */
	public boolean isSet() {
		return set;
	}

	/**
	 * @param set the set to set
	 */
	public void setSet(boolean set) {
		this.set = set;
	}

	/**
	 * @return the webhookUrl
	 */
	public String getWebhookUrl() {
		return webhookUrl;
	}

	/**
	 * @param webhookUrl the webhookUrl to set
	 */
	public void setWebhookUrl(String webhookUrl) {
		this.webhookUrl = webhookUrl;
	}
	
	

}
