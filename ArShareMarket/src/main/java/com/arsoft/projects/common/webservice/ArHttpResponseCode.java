package com.arsoft.projects.common.webservice;

public enum ArHttpResponseCode {
	//1xx: Information
	CONTINUE(100,"Continue"),
	SWITCHING_PROTOCOLS(101,"Switching Protocols"),
	//2xx:,"Successful
	OK(200,"OK"),
	CREATED(201,"Created"),
	ACCEPTED(202,"Accepted"),
	NON_AUTHORITATIVE_INFORMATION(203,"Non Authoritative Information"),
	NO_CONTENT(204,"No Content"),
	RESETCONTENT(205,"Reset Content"),
	PARTIALCONTENT(206,"Partial Content"),
	//3xx:,"Redirection
	MULTIPLE_CHOICES(300,"Multiple Choices"),
	MOVED_PERMANENTLY(301,"Moved Permanently"),
	FOUND(302,"Found"),
	SEE_OTHER(303,"See Other"),
	NOT_MODIFIED(304,"Not Modified"),
	USE_PROXY(305,"Use Proxy"),
	UNUSED(306,"Unused"),
	TEMPORARY_REDIRECT(307,"Temporary Redirect"),
	//4xx:,"Client Error
	BAD_REQUEST(400,"Bad Request"),
	UNAUTHORIZED(401,"Unauthorized"),
	PAYMENT_REQUIRED(402,"Payment Required"),
	FORBIDDEN_ACCESS(403,"Forbidden Access"),
	NOTFOUND(404,"NotFound"),
	METHOD_NOT_ALLOWED(405,"Method Not Allowed"),
	NOT_ACCEPTABLE(406,"Not Acceptable"),
	PROXY_AUNTICATION_REQUIRED(407,"Proxy Auntication Required"),
	REQUEST_TIMEOUT(408,"Request Timeout"),
	CONFLICT(409,"Conflict"),
	GONE(410,"Gone"),
	LENGTH_REQUIRED(411,"Length Required"),
	PRECONDITION_FAILED(412,"Precondition Failed"),
	REQUEST_ENTITY_TOO_LARGE(413,"Request Entity Too Large"),
	REQUEST_URL_TOO_LONG(414,"Request Url Too Long"),
	UNSUPPORTED_MEDIA_TYPE(415,"Unsupported Media Type"),
	REQUESTED_RANGE_NOT_SATISFIABLE(416,"Requested Range Not Satisfiable"),
	EXPECTATION_FAILED(417,"Expectation Failed"),
	//5xx:,"Server
	INTERNAL_SERVER_ERROR(500,"Internal Server Error"),
	NOT_IMPLEMENTED(501,"Not Implemented"),
	BAD_GATEWAY(502,"Bad Gateway"),
	SERVICE_UNAVAILABLE(503,"Service Unavailable"),
	GATEWAY_TIMEOUT(504,"Gateway Timeout"),
	HTTP_VERSION_NOT_SUPPORTED(505,"HTTP Version Not Supported");

	
	private int httpResponseCode;
	private String httpResponseDescription;
	
	private ArHttpResponseCode(int httpResponseCode, String httpResponseDescription){
		this.httpResponseCode = httpResponseCode;
		this.httpResponseDescription = httpResponseDescription;
	}
	
	public int getHttpResponseCode(){
		return this.httpResponseCode;
	}
	
	public String getHttpResponseDescription(){
		return this.httpResponseDescription;
	}
	
	public String toString(){
		return this.httpResponseCode+ " "+ this.httpResponseDescription;
	}
}
