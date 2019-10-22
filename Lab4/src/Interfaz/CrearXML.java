package Interfaz;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.JTextField;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class CrearXML {
    
    //JFrame ventana;
    
    public CrearXML(){
        //ventana = Ventana;
    }
    
    public void crearArchivo(JTextField TxtNombre, JTextField TxtEstructura,JTextField TxtLimites, JTextField TxtIdioma, JTextField TxtPoblacion, JTextField TxtArea) throws TransformerConfigurationException, TransformerException{
        try {
            
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
            // elemento raiz
            Document doc = (Document) docBuilder.newDocument();
            Element rootElement = doc.createElement("Paises");
            doc.appendChild(rootElement);
            
            Element pais = doc.createElement("Pais");
            rootElement.appendChild(pais);
            
            String pNombre = TxtNombre.getText();
            Element nombre = doc.createElement("Nombre");
            nombre.appendChild(doc.createTextNode(pNombre));
            pais.appendChild(nombre);
            
            Element area = doc.createElement("Area");
            String pArea = TxtArea.getText();
            area.appendChild(doc.createTextNode(pArea));
            pais.appendChild(area);
            
            Element poblacion = doc.createElement("Poblacion");
            String pPoblacion = TxtPoblacion.getText();
            poblacion.appendChild(doc.createTextNode(pPoblacion));
            pais.appendChild(poblacion);
            
            Element idioma = doc.createElement("Idioma");
            String pIdioma = TxtIdioma.getText();
            idioma.appendChild(doc.createTextNode(pIdioma));
            pais.appendChild(idioma);
            
            Element limites = doc.createElement("Limites");
            String pLimites = TxtLimites.getText();
            limites.appendChild(doc.createTextNode(pLimites));
            pais.appendChild(limites);
            
            Element estructuraGeografica = doc.createElement("EstructuraGeografica");
            String pEstructura = TxtEstructura.getText();
            estructuraGeografica.appendChild(doc.createTextNode(pEstructura));
            pais.appendChild(estructuraGeografica);
            
            // escribimos el contenido en un archivo .xml
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("archivo.xml"));
            //StreamResult result = new StreamResult(new File("archivo.xml"));
 
            // Si se quiere mostrar por la consola...
            // StreamResult result = new StreamResult(System.out);
 
            transformer.transform(source, result);
            System.out.println("File saved!");
        
        }
        catch (ParserConfigurationException pce) {
            pce.printStackTrace();
	}
    }
}
