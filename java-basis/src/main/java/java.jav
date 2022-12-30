package com.leablogs;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class WordTable1 {
    public static void main(String[] args) {


        File file = new File("F:\\table.docx");
        String str = "";
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documentXml = builder.newDocument();
            documentXml.setXmlStandalone(true);
            Element errorMsgs = documentXml.createElement("ErrorMsgs");





            FileInputStream fis = new FileInputStream(file);
            XWPFDocument document = new XWPFDocument(fis);
            List<XWPFTable> tables = document.getTables();
            for (XWPFTable table : tables) {
                List<XWPFTableRow> rows = table.getRows();
//                for(XWPFTableRow row:rows){
                for (int j = 1; j < rows.size(); j++) {
                    XWPFTableRow row = rows.get(j);
                    List<XWPFTableCell> tableCells = row.getTableCells();

                    System.out.println(tableCells.get(0).getText() + " " + tableCells.get(1).getText());

                    Element errorMsg = documentXml.createElement("errorMsg");
                    Element code = documentXml.createElement("code");
                    Element message = documentXml.createElement("message");

                    code.setTextContent(tableCells.get(0).getText());
                    message.setTextContent(tableCells.get(1).getText());
                    errorMsg.appendChild(code);
                    errorMsg.appendChild(message);
                    errorMsgs.appendChild(errorMsg);
                    /*for (int i = 0; i < tableCells.size(); i++) {
                        System.out.println(tableCells.get(i).getText());
                    }*/
                }
            }
            documentXml.appendChild(errorMsgs);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            Transformer tf = transformerFactory.newTransformer();

            tf.setOutputProperty(OutputKeys.INDENT,"yes");
            tf.transform(new DOMSource(documentXml),new StreamResult(new File("book1.xml")));
            System.out.println("craete xml successful");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            System.out.println("error0");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
            System.out.println("error1");
        } catch (TransformerException e) {
            e.printStackTrace();
            System.out.println("error12");
        }
//        createXml();

    }
    private static void createXml(String code, String msg) {}

    private static void createXml() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            document.setXmlStandalone(true);

            Element bookstore = document.createElement("bookstore");
            for(int i =0;i<10;i++){
                Element book = document.createElement("book");
                Element name = document.createElement("name");
                Element price = document.createElement("price");
                name.setTextContent("雷神"+ i);
                price.setTextContent("100.00");
                book.appendChild(name);
                book.appendChild(price);
                bookstore.appendChild(book);
            }
            document.appendChild(bookstore);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            Transformer tf = transformerFactory.newTransformer();

            tf.setOutputProperty(OutputKeys.INDENT,"yes");
            tf.transform(new DOMSource(document),new StreamResult(new File("book1.xml")));
            System.out.println("craete xml successful");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
