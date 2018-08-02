/**
 *@author Vijay Bharwani
 */
package org.mule.modules.whatsapp;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.ReconnectOn;
import org.mule.api.annotations.param.Default;
import org.mule.modules.whatsapp.config.ConnectorConfig;
import org.mule.modules.whatsapp.model.CreateGroupRequest;
import org.mule.modules.whatsapp.model.SendFileRequest;
import org.mule.modules.whatsapp.model.SendMessageRequest;
import org.mule.modules.whatsapp.model.WebhookRequest;



/**
 *his conenctor provides implementation of Whatsapp APIs.
 * @author vijaybharwani
 */
@Connector(name="whatsapp", friendlyName="Whatsapp")
public class WhatsappConnector {

	@Config
	ConnectorConfig config;
	
	Logger logger = Logger.getLogger(WhatsappConnector.class);


	/**
	 * 
	 * Send a message to a new or existing chat.
	 * @param number A phone number starting with the country code. You do not need to add your number. 
USA example: 17472822486.
	 * @param message Message text, UTF-8 or UTF-16 string with emoji 🍏
	 * @return Json String returned by Server
	 */
	@Processor
	@ReconnectOn(exceptions = { Exception.class })
	public String sendMessage(String number, String message) {
		logger.debug("Whatsapp Send Message");
		SendMessageRequest request = new SendMessageRequest(number, message);
		Client client = ClientBuilder.newClient();
		Response response =client.target(config.getApiUrl()).path("sendMessage").queryParam("token", config.getToken()).
				request(MediaType.APPLICATION_JSON).post(Entity.entity(request, MediaType.APPLICATION_JSON));
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus() + response.getEntity());
		}
		String entity = response.readEntity(String.class);
		logger.debug("response " + entity);
		return entity;
	}

	/**
	 * 
	 * Get a list of messages. To receive only new messages, pass the lastMessageNumber parameter from the last query.
	 * @param lastMessageNumber The lastMessageNumber parameter from the last response
	 * @param last Displays the last 100 messages. If this parameter is passed, then lastMessageNumber is ignored.
	 * @return JSON String of response received from Server.
	 */
	@Processor
	@ReconnectOn(exceptions = { Exception.class })
	public String readMessage(Integer lastMessageNumber, @Default("#[false]") boolean last) {
		logger.debug("Read Message");
		Client client = ClientBuilder.newClient();
		Response response = null;
		if(last){
			response =client.target(config.getApiUrl()).path("messages").
					queryParam("token", config.getToken()).
					queryParam("lastMessageNumber", lastMessageNumber).
					queryParam("last", true).
					request().get();
		}else{
			response =client.target(config.getApiUrl()).path("messages").
					queryParam("token", config.getToken()).
					queryParam("lastMessageNumber", lastMessageNumber).
					request().get();
		}

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus() + response.getEntity());
		}
		String entity = response.readEntity(String.class);
		logger.debug("response: " +entity);
		return entity;

	}


	/**
	 * Sets the URL for receiving webhook notifications of new messages and message delivery events (ack).
	 * @param webhookUrl Http or https URL for receiving notifications.
	 * @return JSON String returned by Server
	 */
	@Processor
	@ReconnectOn(exceptions = { Exception.class })
	public String setWebhookUrl(String webhookUrl) {
		logger.debug("Set web hook url");
		Client client = ClientBuilder.newClient();
		WebhookRequest request = new WebhookRequest(webhookUrl); 
		Response response =client.target(config.getApiUrl()).path("webhook").
				queryParam("token", config.getToken()).
				request(MediaType.APPLICATION_JSON).post(Entity.entity(request, MediaType.APPLICATION_JSON));
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus() + response.getEntity());
		}
		String entity = response.readEntity(String.class);
		logger.debug("response: " + entity );

		return entity;

	}

	/**
	 * Returns current webhook url.
	 * @return JSON String returned by Server.
	 */
	@Processor
	@ReconnectOn(exceptions = { Exception.class })
	public String getWebhookUrl() {
		logger.debug("Get Webhook URL");
		Client client = ClientBuilder.newClient();
		Response response = client.target(config.getApiUrl()).path("webhook").
				queryParam("token", config.getToken()).
				request().get();

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus() + response.getEntity());
		}
		String entity = response.readEntity(String.class);
		logger.debug("response " + entity);
		return entity;
	}

	/**
	 * Logout from WhatsApp Web to get new QR code.
	 * @return 
	 */
	@Processor
	@ReconnectOn(exceptions = { Exception.class })
	public String logout(){
		logger.info("Logout");
		Client client = ClientBuilder.newClient();
		Response response = client.target(config.getApiUrl()).path("logout").
				queryParam("token", config.getToken()).
				request().get();

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus() + response.getEntity());
		}
		String entity = response.readEntity(String.class);
		logger.debug("Response: " + entity);
		return entity;
	}

	/**
	 * Reboot your WhatsApp instance.
	 * @return
	 */
	@Processor
	@ReconnectOn(exceptions = { Exception.class })
	public String reboot(){
		logger.debug("Reboot");
		Client client = ClientBuilder.newClient();
		Response response = client.target(config.getApiUrl()).path("reboot").
				queryParam("token", config.getToken()).
				request().get();

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus() + response.getEntity());
		}
		String entity = response.readEntity(String.class);
		logger.debug("response " + entity);

		return entity;
	}

	/**
	 * Get outbound messages queue.
	 * @return JSON String returned from server.
	 */
	@Processor
	@ReconnectOn(exceptions = { Exception.class })
	public String showMessagesQueue() {
		logger.debug("showMessagesQueue");
		Client client = ClientBuilder.newClient();
		Response response = client.target(config.getApiUrl()).path("showMessagesQueue").
				queryParam("token", config.getToken()).
				request().get();

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus() + response.getEntity());
		}
		String entity = response.readEntity(String.class);
		logger.debug("response: "+ entity);

		return entity;
	}


	/**
	 * Clear outbound messages queue. This method is needed when you accidentally sent thousands of messages in a row.
	 * @return JSON string returned from server.
	 */
	@Processor
	@ReconnectOn(exceptions = { Exception.class })
	public String clearMessagesQueue(){
		logger.debug("Clear Message Queue");
		Client client = ClientBuilder.newClient();
		Response response = client.target(config.getApiUrl()).path("clearMessagesQueue").
				queryParam("token", config.getToken()).
				request().get();

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus() + response.getEntity());
		}
		String entity = response.readEntity(String.class);
		logger.debug("response: " + entity);

		return entity;
	}


	/**
	 * Get the account status and QR code for authorization.
	 * @return JSON string returned by server. 
	 */
	@Processor
	@ReconnectOn(exceptions = { Exception.class })
	public String status() {
		logger.debug("get Status");
		Client client = ClientBuilder.newClient();
		Response response = client.target(config.getApiUrl()).path("status").
				queryParam("token", config.getToken()).
				request().get();

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus() + response.getEntity());
		}
		String entity = response.readEntity(String.class);
		logger.debug("response :" + entity);
		return entity;
	}

	/**
	 * Direct link to QR-code in the form of an image, not base64.
	 * @return Byte Array object returned by server. 
	 */
	@Processor
	@ReconnectOn(exceptions = { Exception.class })
	public Object getQRCode(){
		logger.debug("Get QR Code...");
		Client client = ClientBuilder.newClient();
		Response response = client.target(config.getApiUrl()).path("qr_code").
				queryParam("token", config.getToken()).
				request().get();

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus() + response.getEntity());
		}
		Object entity = response.getEntity();
		logger.debug("response " + entity);

		return entity;
	}


	/**
	 * Creates a group and sends the message to the created group.
	 * 
	 * @param groupName Group name, string, mandatory.
	 * @param phones An array of phones starting with the country code. You do not need to add your number. 
USA example: ['17472822486'].
	 * @param message Message text, string
	 * @return JSON string returned by Server
	 */
	@Processor
	@ReconnectOn(exceptions = { Exception.class })
	public Object createGroup(String groupName, List<String> phones, String message){
		logger.debug("Clear Message Queue");
		Client client = ClientBuilder.newClient();
		CreateGroupRequest request = new CreateGroupRequest(groupName, phones, message);
		Response response = client.target(config.getApiUrl()).path("group").
				queryParam("token", config.getToken()).
				request(MediaType.APPLICATION_JSON).post(Entity.entity(request, MediaType.APPLICATION_JSON));

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus() + response.getEntity());
		}
		Object entity = response.readEntity(String.class);
		logger.debug("response" + entity);

		return entity;
	}


	/**
	 * Send a file to a new or existing chat.
	 * @param phone A phone number starting with the country code. You do not need to add your number. 
USA example: 17472822486.
	 * @param body HTTP link https://upload.wikimedia.org/wikipedia/ru/3/33/NatureCover2001.jpg 
Or base64-encoded file with mime data, for example data:image/jpeg;base64,/9j/4AAQSkZJRgABAQ... 
File in form-data input field
	 * @param fileName File name, for example 1.jpg or hello.xlsx
	 * @return JSON string returned by Server
 	 */
	@Processor
	@ReconnectOn(exceptions = { Exception.class })
	public Object sendFile(String phone, String body, String fileName) {
		logger.debug("Send file Queue");
		Client client = ClientBuilder.newClient();
		SendFileRequest request = new SendFileRequest(phone, body, fileName);
		Response response = client.target(config.getApiUrl()).path("sendFile").
				queryParam("token", config.getToken()).
				request(MediaType.APPLICATION_JSON).post(Entity.entity(request, MediaType.APPLICATION_JSON));

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus() + response.getEntity());
		}
		Object entity = response.readEntity(String.class);
		logger.debug("response" + entity);
		return entity;
	}



	public ConnectorConfig getConfig() {
		return config;
	}

	public void setConfig(ConnectorConfig config) {
		this.config = config;
	}

}