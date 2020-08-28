package xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestCompareXMLs {
	private static final String FAILURE = "Invalid XMLS";
	private static final String SUCCESS = "valid XMLS";

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		Document sourceDoc = getDocumentinstance("employeeAddr.xml");
		Document targetDoc = getDocumentinstance("employeeAddr2.xml");

		Element sourceRoot = sourceDoc.getDocumentElement();
		Element targetRoot = targetDoc.getDocumentElement();

		// System.out.println(sourceRoot.getNodeName());
		if (!sourceRoot.getNodeName().equals(targetRoot.getNodeName())
				|| sourceRoot.getChildNodes().getLength() != sourceRoot.getChildNodes().getLength()) {
			System.out.println(FAILURE);
		} else {
			try {
				travesrseAllNodes(sourceRoot.getChildNodes(), targetRoot.getChildNodes());
				System.out.println(SUCCESS);
			} catch (XMLCompareFailure e) {
				System.out.println(e.getMsg());
				System.out.println(FAILURE);
			}
		}
	}

	private static void travesrseAllNodes(NodeList sourceList, NodeList targetList) throws XMLCompareFailure {
		validateElementsSize(sourceList,targetList);
		for (int temp = 0; temp < sourceList.getLength(); temp++) {
			Node sourceNode = sourceList.item(temp);
			if (sourceNode.getNodeType() == Node.ELEMENT_NODE) {
				String elementName = sourceNode.getNodeName();

				Node targetNode = getNode(elementName, targetList, temp);
				compareAttributes(sourceNode, targetNode);

				if (isSimpleElement(sourceNode) && !sourceNode.getTextContent().equals(targetNode.getTextContent())) {
					throw new XMLCompareFailure("compare failed for" + elementName);
				}

				if (sourceNode.hasChildNodes()) {
					travesrseAllNodes(sourceNode.getChildNodes(), targetNode.getChildNodes());
				}
			}
		}
	}

	private static void validateElementsSize(NodeList sourceList, NodeList targetList) throws XMLCompareFailure {
		if (sourceList.getLength() != targetList.getLength()) {
			throw new XMLCompareFailure("elements size mismatch");
		}
	}

	private static Node getNode(String elementName, NodeList targetList, int t) throws XMLCompareFailure {
		if (targetList.getLength() < t) {
			throw new XMLCompareFailure("targetList has less elements" + elementName);
		}
		for (int temp = t; temp < targetList.getLength(); temp++) {
			Node sourceNode = targetList.item(temp);
			if (sourceNode.getNodeType() == Node.ELEMENT_NODE) {
				String targetElementName = sourceNode.getNodeName();
				if (elementName.equals(targetElementName)) {
					return sourceNode;
				}
			}
		}
		throw new XMLCompareFailure("element not found. -->" + elementName);
	}

	private static boolean isSimpleElement(Node node) {
		return node.getChildNodes().getLength() == 1;
	}

	private static void compareAttributes(Node source, Node target) throws XMLCompareFailure {
		if (source.hasAttributes()) {
			if (source.getAttributes().getLength() != target.getAttributes().getLength()) {
				throw new XMLCompareFailure("compare attributes size mismatch");
			}

			NamedNodeMap nodeMap = source.getAttributes();
			for (int i = 0; i < nodeMap.getLength(); i++) {
				Node tempNode = nodeMap.item(i);
				String nodeName = tempNode.getNodeName();
				Node targetNode = target.getAttributes().getNamedItem(nodeName);
				if (targetNode == null) {
					throw new XMLCompareFailure("invalid attribute name" + nodeName);
				}

				if (!nodeName.equalsIgnoreCase("id") && !tempNode.getNodeValue().equals(targetNode.getNodeValue())) {
					throw new XMLCompareFailure("invalid attribute name for" + tempNode.getNodeName());
				}
			}
		}
	}

	private static Document getDocumentinstance(String xml)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(xml));
		document.getDocumentElement().normalize();
		return document;
	}
}
