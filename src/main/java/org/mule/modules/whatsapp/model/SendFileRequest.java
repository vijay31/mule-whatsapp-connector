/**
 *
 */
package org.mule.modules.whatsapp.model;

public class SendFileRequest {

	private String phone;
	private String body;
	private String filename;
	
	public SendFileRequest(){
		
	}
	
	public SendFileRequest(String phone, String body, String fileName){
		this.phone = phone;
		this.body = body ;
		this.filename = fileName;
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

	/**
	 * @return the fileName
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFilename(String fileName) {
		this.filename = fileName;
	}
}
