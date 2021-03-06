package com.hacks4eva.broker;


	import java.io.FileInputStream;  
	import java.io.FileOutputStream;  
	import java.io.IOException;  
	import java.io.ObjectInputStream;  
	import java.io.ObjectOutputStream;  
	import javax.crypto.*;  
	import javax.crypto.spec.*;  
	import java.security.*;  
	import java.security.spec.*;  
	import java.security.InvalidKeyException;  
	import java.security.NoSuchAlgorithmException;  
	import java.security.spec.KeySpec;  
	import sun.misc.BASE64Encoder; // para simplificar o exemplo. Use alguma outra classe para converter  
	import sun.misc.BASE64Decoder; // para Base-64.  
	public final class encript {  
	    private static SecretKey skey;  
	    private static KeySpec ks;  
	    private static PBEParameterSpec ps;  
	    private static final String algorithm = "PBEWithMD5AndDES";  
	    private static BASE64Encoder enc = new BASE64Encoder();  
	    private static BASE64Decoder dec = new BASE64Decoder();  
	    static {  
	        try {  
	            SecretKeyFactory skf = SecretKeyFactory.getInstance(algorithm);  
	            ps = new PBEParameterSpec (new byte[]{3,1,4,1,5,9,2,6}, 20);  
	  
	            ks = new PBEKeySpec ("EAlGeEen3/m8/YkO".toCharArray()); // esta ? a chave que voc? quer manter secreta.  
	            // Obviamente quando voc? for implantar na sua empresa, use alguma outra coisa - por exemplo,  
	            // "05Bc5hswRWpwp1sew+MSoHcj28rQ0MK8". Nao use caracteres especiais (como ?) para nao dar problemas.  
	  
	            skey = skf.generateSecret (ks);  
	        } catch (java.security.NoSuchAlgorithmException ex) {  
	            ex.printStackTrace();  
	        } catch (java.security.spec.InvalidKeySpecException ex) {  
	            ex.printStackTrace();  
	        }  
	    }  
	    public static final String encrypt(final String text)  
	        throws  
	        BadPaddingException,  
	        NoSuchPaddingException,  
	        IllegalBlockSizeException,  
	        InvalidKeyException,  
	        NoSuchAlgorithmException,  
	        InvalidAlgorithmParameterException {  
	              
	        final Cipher cipher = Cipher.getInstance(algorithm);  
	        cipher.init(Cipher.ENCRYPT_MODE, skey, ps);  
	        return enc.encode (cipher.doFinal(text.getBytes()));  
	    }  
	    public static final String decrypt(final String text)  
	        throws  
	        BadPaddingException,  
	        NoSuchPaddingException,  
	        IllegalBlockSizeException,  
	        InvalidKeyException,  
	        NoSuchAlgorithmException,  
	        InvalidAlgorithmParameterException {  
	              
	        final Cipher cipher = Cipher.getInstance(algorithm);  
	        cipher.init(Cipher.DECRYPT_MODE, skey, ps);  
	        String ret = null;  
	        try {  
	            ret = new String(cipher.doFinal(dec.decodeBuffer (text)));  
	        } catch (Exception ex) {  
	        }  
	        return ret;  
	    }  
	    public static void main(String[] args) throws Exception {  
	        String password = "3p6/Lsbp+MIK8zqK"; // esta ? a tal senha do banco de dados que voc? quer criptografar  
	        String encoded = PWSec.encrypt (password);  
	        System.out.println (encoded);  // imprime "4fWCjTdEhMPEluqE2n8ci4FiqWeb+DXc"  
	        System.out.println (PWSec.decrypt (encoded).equals (password)); // imprime "true"  
	        // Vamos alterar um caracter, s� para ver o que ocorre  
	        char[] enc = encoded.toCharArray();  
	        enc[2] = (char) (enc[2] + 1);  
	        encoded = new String (enc);  
	        System.out.println (encoded); // imprime "4fXCjTdEhMPEluqE2n8ci4FiqWeb+DXc"  
	        System.out.println (password.equals (PWSec.decrypt (encoded))); // imprime "false"  
	    }  
	}  


