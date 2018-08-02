/**
 * @author Vijay Bharwani
 */
package org.mule.modules.whatsapp.model;

import java.util.List;

public class CreateGroupRequest {

	private String groupName;
	
	private List<String> phones;
	
	private String messageText;
	
	public CreateGroupRequest(){
		
	}
	
	public CreateGroupRequest(String groupName, List<String> phones, String messageText){
		this.groupName = groupName;
		this.phones = phones;
		this.messageText = messageText;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the phones
	 */
	public List<String> getPhones() {
		return phones;
	}

	/**
	 * @param phones the phones to set
	 */
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

	/**
	 * @return the messageText
	 */
	public String getMessageText() {
		return messageText;
	}

	/**
	 * @param messageText the messageText to set
	 */
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
	
}
