package br.com.AutoOMU;

import java.util.logging.Level;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class ConnectionSSH {

	LogsOMU log = LogsOMU.getInstance();
	JSch jsch;
	Session session;

	public void conexaoSSH() {
		try {

			jsch = new JSch();
			session = jsch.getSession("user", "ip", 22);
			session.setUserInfo(new UsuarioSSH());
			session.connect();

			if (session.isConnected())
				log.log(Level.INFO,
						"[SSHClient]Conexão SSH efetuada com sucesso!");

			exportOMU();
		} catch (Exception e) {
			log.log(Level.SEVERE,
					"[SSHClient] Erro de sessão! Não foi possível conectar ao servidor SSH!"
							+ e);
		}
	}

	public void exportOMU() {

		String command = "cd omu; perl objmig.pl < exportOMU;";
		ChannelExec channel;

		try {
			channel = (ChannelExec) session.openChannel("exec");

			channel.setCommand(command);

			channel.connect();
			log.log(Level.INFO,
					"[SSHCLIENT] Export do arquivo OMU efetuado com sucesso!");
			channel.disconnect();
			importOMU();
		} catch (JSchException e) {
			log.log(Level.SEVERE,
					"[SSHCLIENT] NÃO FOI POSSÍVEL EFETUAR O EXPORT DO ARQUIVO OMU! "
							+ e);

		}

	}

	public void importOMU() {

		String command = "cd omu; perl objmig.pl < importOMU;";

		ChannelExec channel;

		try {
			channel = (ChannelExec) session.openChannel("exec");

			channel.setCommand(command);

			channel.connect();
			// BufferedReader in=new BufferedReader(new
			// InputStreamReader(channel.getInputStream()));

			/*
			 * String msg=null; while((msg=in.readLine())!=null){
			 * System.out.println(msg); }
			 */
			log.log(Level.INFO,
					"[SSHCLIENT] Import do arquivo OMU efetuado com sucesso!");
			channel.disconnect();
			session.disconnect();
		} catch (JSchException e) {
			log.log(Level.SEVERE,
					"[SSHCLIENT] NÃO FOI POSSÍVEL EFETUAR O IMPORT DO ARQUIVO OMU! "
							+ e);

		}

	}
}
