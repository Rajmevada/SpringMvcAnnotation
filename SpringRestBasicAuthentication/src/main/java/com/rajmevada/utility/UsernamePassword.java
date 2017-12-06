package com.rajmevada.utility;

import org.apache.commons.codec.binary.Base64;

public class UsernamePassword {

	public static void main(String[] args) {

		String plainClientCredentials = "raj:raj";
		String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));
		System.out.println(base64ClientCredentials);
	}

}
