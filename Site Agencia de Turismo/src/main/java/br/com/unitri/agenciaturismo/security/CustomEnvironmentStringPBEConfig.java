package br.com.unitri.agenciaturismo.security;

import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(value="singleton")
public class CustomEnvironmentStringPBEConfig extends EnvironmentStringPBEConfig {

	static final String ALGORITHM = "PBEWithMD5AndDES";
	static final String PASSWORD = "autobackup-ctbc@2012";
	
	
	public CustomEnvironmentStringPBEConfig() {
		super();
		/** Initializing the variables */
		setAlgorithm(ALGORITHM);
		setPassword(PASSWORD);
	}

	
	
}
