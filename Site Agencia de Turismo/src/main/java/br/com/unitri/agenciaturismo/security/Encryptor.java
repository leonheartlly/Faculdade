package br.com.unitri.agenciaturismo.security;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class Encryptor {

	public static void main(String[] args) {

//		System.out.println(encrypt("teste"));
		System.out.println(decrypt("IPDqmRhG0ZjCZMNOSPKD7g=="));
		
//		if (args != null && args.length == 4) {
//			encryptUsernameAndPassword(args[0], args[1], args[2], args[3]);
//		} else if (args != null && args.length == 2) {
//			encryptUsernameAndPassword(args[0], args[1],
//					CustomEnvironmentStringPBEConfig.PASSWORD,
//					CustomEnvironmentStringPBEConfig.ALGORITHM);
//		} else {
//			System.err
//					.println("Failed on ecrypt user and pass, inform the parameters: \"username\", \"password\", \"ENCRYPT_PASSWORD\" and \"ENCRYPT_ALGORITHM\" ");
//		}
	}

	public static void encryptUsernameAndPassword(String username,
			String password, final String ENCRYPT_PASSWORD,
			final String ENCRYPT_ALGORITHM) {
		StandardPBEStringEncryptor userNameEncryptor = new StandardPBEStringEncryptor();
		StandardPBEStringEncryptor passwordEncryptor = new StandardPBEStringEncryptor();
		/**
		 * Information retrieved from main pom.xml, on case pass changes the
		 * pass must be changed here
		 */
		userNameEncryptor.setAlgorithm(ENCRYPT_ALGORITHM);
		userNameEncryptor.setPassword(ENCRYPT_PASSWORD);
		passwordEncryptor.setAlgorithm(ENCRYPT_ALGORITHM);
		passwordEncryptor.setPassword(ENCRYPT_PASSWORD);
		System.out.println(">>> encryptedUserName: "
				+ userNameEncryptor.encrypt(username));
		System.out.println(">>> encryptedPassword: "
				+ passwordEncryptor.encrypt(password));
	}

	public static String encrypt(String stringToEncrypt) {
		return getEncryptor(null, null).encrypt(stringToEncrypt);
	}

	public static String decrypt(String stringToDecrypt) {
		return getEncryptor(null, null).decrypt(stringToDecrypt);
	}

	private static StandardPBEStringEncryptor getEncryptor(String algorithm,
			String password) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setAlgorithm(algorithm != null ? algorithm
				: CustomEnvironmentStringPBEConfig.ALGORITHM);
		encryptor.setPassword(password != null ? password
				: CustomEnvironmentStringPBEConfig.PASSWORD);
		return encryptor;
	}

}