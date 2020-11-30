package Utils;

import javax.lang.model.element.AnnotationValue;
import javax.naming.AuthenticationException;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.lang.InstantiationException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Test {

    private TransformerFactory TRANSFORMER_FACTORY = TransformerFactory.newInstance();
    private List<String> list;

    public void setArray(List<String> list){
        this.list = new ArrayList<>(list);
    }

    public List<String> getList() {
        return new ArrayList<>(list);
    }

    public Class<?> loadClass(String name) throws ClassNotFoundException {
        switch (name){
            case "int":
                return Class.forName("int");
            default:
                return null;
        }
    }
    private void fillXMLDataForPanel(AnnotationValue xsltForPanel,Hashtable<Object, Object> uiIds,String inputUserFile,String xPath, JAXBContext jc, StringWriter stringWriter) throws JAXBException, TransformerFactoryConfigurationError, TransformerException, FileNotFoundException {
        JAXBSource source = new JAXBSource(jc, new Object());
        String formattedString = String.format(xsltForPanel.toString(), uiIds.get(0), uiIds.get(1));

        TRANSFORMER_FACTORY.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        Source xslt = new StreamSource(new StringReader(formattedString));
        Transformer t = TRANSFORMER_FACTORY.newTransformer(xslt);
        t.setParameter(XMLConstants.FEATURE_SECURE_PROCESSING, true);

        t.transform(source, new StreamResult(stringWriter));

//
//        TransformerFactory factory = TransformerFactory.newInstance();
//        factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
//        xslt  = new StreamSource(new FileInputStream(inputUserFile));
//
//        Transformer transformer = factory.newTransformer(xslt);


    }

    private Class<?> traceFields(String remoteType)
            throws ClassNotFoundException {
            Class<?> cls = null;
            switch (remoteType){
                case "class_1":
                    cls = Class.forName("class_1");
                    break;
                default:
                    throw new ClassNotFoundException("Can not find Class"+remoteType);
            }
            return cls;

    }




}
