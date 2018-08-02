/**
 *
 */
package org.mule.modules.whatsapp.model;

public class SendMessageRequest {

	private String phone;
	private String body;
	
	public SendMessageRequest(){
		
	}
	
	public SendMessageRequest(String phone, String body){
		this.phone = phone;
		this.body = body;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}
	
	
}
