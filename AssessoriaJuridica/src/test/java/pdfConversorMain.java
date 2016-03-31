import br.com.assessoria.util.PdfConversor;




public class pdfConversorMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String dir = "/home/elton/Elton-Projetos/Anderson/UDI17-09.PDF";
		
//		String a = "/opt/assessoriq/tmp";
//		a+= dir.substring(dir.lastIndexOf("/"));
//		a = a.replaceAll("PDF", "xml");
//		System.out.println(a);
		PdfConversor pdfCon = new PdfConversor(dir);
		pdfCon.start();

	}

}
