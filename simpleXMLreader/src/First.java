import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class First {
    public static void main(String[] args) {
        try {
            // A document builder is created.
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // A DOM tree is created from the file
            Document doc = db.parse("file.xml");
            // A DOM tree is created from the file.
            Node root = doc.getDocumentElement();

            System.out.println("List of books:");
            System.out.println();
            // Look through all the sub-elements of the root - i.e. books
            NodeList currency = root.getChildNodes();
            for (int i = 0; i < currency.getLength(); i++) {
                Node curr = currency.item(i);
                // If the node is not text, then this is a book - go inside
                if (curr.getNodeType() != Node.TEXT_NODE) {
                    NodeList charProps = curr.getChildNodes();
                    for(int j = 0; j < charProps.getLength(); j++) {
                        Node charProp = charProps.item(j);
                        // If the node is not text, then this is one of the parameters of the book - print
                        if (charProp.getNodeType() != Node.TEXT_NODE) {
                            System.out.println(charProp.getNodeName() + ":" + charProp.getChildNodes().item(0).getTextContent());
                        }
                    }
                    System.out.println("===========>>>>");
                }
            }
        //handle all possible types of exceptions
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}