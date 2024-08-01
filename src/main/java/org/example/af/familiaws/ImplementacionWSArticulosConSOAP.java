package af.familiaws;

import org.example.servicios.IServiciosArticulos;

import javax.xml.soap.*;



public class ImplementacionWSArticulosConSOAP implements IServiciosArticulos {

    @Override
    public String[] getArticulos() {
        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            String url = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso";

            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);
            String response = extractMessageValue(soapResponse);
            soapConnection.close();

            return new String[]{response};

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private SOAPMessage createSOAPRequest() throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://www.dataaccess.com/webservicesserver/";
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("web", serverURI);

        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("NumberToWords", "web");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("ubiNum", "web");
        soapBodyElem1.addTextNode("123");

        soapMessage.saveChanges();

        return soapMessage;
    }

    private String extractMessageValue(SOAPMessage soapResponse) throws Exception {
        SOAPBody responseBody = soapResponse.getSOAPBody();
        return responseBody.getTextContent();
    }
}
