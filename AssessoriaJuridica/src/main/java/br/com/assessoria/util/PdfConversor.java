/**
 * 
 */
package br.com.assessoria.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.xml.bind.ValidationException;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PdfConversor extends Thread
  implements Runnable
{
  private String caminho;
  private int inicio;
  private int fim;
  private String caminhoSaida;
  private int estruturaArquivo;

  public PdfConversor(String caminhoDoArquivo)
  {
    this.caminho = caminhoDoArquivo;
  }

  public PdfConversor() {
  }

  public void setCaminhoArquivoPdf(String caminhoDoArquivo) {
    this.caminho = caminhoDoArquivo;
  }

  public void run()
  {
    try {
      converterPdfParaArquivoTexto();
    } catch (ValidationException e) {
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no porcessamento do arquivo!",""));
    }
  }

  public void converterPdfParaArquivoTexto()
    throws ValidationException
  {
    try
    {
      if ((this.caminho == null) || ("".equals(this.caminho.trim()))) {
        throw new ValidationException("Caminho do arquivo informado inválido.");
      }

      File f = new File(this.caminho);

      FileInputStream is = null;

      is = new FileInputStream(f);

      PDDocument pdfDocument = null;

      PDFParser parser = new PDFParser(is);

      parser.parse();

      pdfDocument = parser.getPDDocument();

      if (pdfDocument.isEncrypted()) {
        System.err.println("PDF CRIPTOGRAFADO - POSSIVEL ERRO EM CURSO");
      }

      PDFTextStripper stripper = new PDFTextStripper();

      File outputFile = null;

//      if ((getCaminhoSaida() != null) && (!"".equals(getCaminhoSaida())))
//        outputFile = new File(getCaminhoSaida());
//      else {
//        outputFile = new File(this.caminho.substring(0, this.caminho.length() - 4) + ".xml");
//      }

//      caminhoSaida = AssessoriaJuridicaUtils.getProperty("caminho.tmp") + caminho.substring(caminho.lastIndexOf("/")).replaceAll("PDF", "xml");
      caminhoSaida = "/home/elton" + caminho.substring(caminho.lastIndexOf("/")).replaceAll("PDF", "xml");
      
      outputFile = new File(caminhoSaida);
      
      OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(outputFile), "ISO-8859-1");

      stripper.setSortByPosition(false);

      System.out.println("INI >> EXTRACAO");
      output.write(stripper.getText(pdfDocument));
      System.out.println("FIM >> EXTRACAO");
      pdfDocument.close();
      output.flush();
      output.close();
    }
    catch (IOException e) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no porcessamento do arquivo!",""));
    }
  }

  public int getInicio() {
    return this.inicio;
  }

  public void setInicio(int inicio) {
    this.inicio = inicio;
  }

  public int getFim() {
    return this.fim;
  }

  public void setFim(int fim) {
    this.fim = fim;
  }

  public String getCaminhoSaida() {
    return this.caminhoSaida;
  }

  public void setCaminhoSaida(String caminhoSaida) {
    this.caminhoSaida = caminhoSaida;
  }

  public int getEstruturaArquivo() {
    return this.estruturaArquivo;
  }

  public void setEstruturaArquivo(int estruturaArquivo) {
    this.estruturaArquivo = estruturaArquivo;
  }
}