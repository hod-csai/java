package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/")
public class XmlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().println("<h2>XML Demo Servlet</h2>");
            resp.getWriter().println("<ul>");
            resp.getWriter().println("<li><a href='?action=validate'>Validate DTD example</a></li>");
            resp.getWriter().println("<li><a href='?action=transform'>Transform XSL example</a></li>");
            resp.getWriter().println("</ul>");
            return;
        }

        try {
            if ("validate".equalsIgnoreCase(action)) {
                resp.setContentType("text/plain;charset=UTF-8");
                boolean ok = validateDTD("/examples/dtd/data.xml", "/examples/dtd/data.dtd");
                resp.getWriter().println(ok ? "Validation succeeded" : "Validation failed (see logs)");
                return;
            }

            if ("transform".equalsIgnoreCase(action)) {
                resp.setContentType("text/html;charset=UTF-8");
                transformXSLT("/examples/xsl/data.xml", "/examples/xsl/style.xsl", resp.getOutputStream());
                return;
            }

            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown action");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private boolean validateDTD(String xmlPath, String dtdPath) throws Exception {
        InputStream xmlIn = getServletContext().getResourceAsStream(xmlPath);
        InputStream dtdIn = getServletContext().getResourceAsStream(dtdPath);
        if (xmlIn == null || dtdIn == null) throw new IOException("Example files not found in webapp/examples");

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setErrorHandler(new SimpleErrorHandler());

            // Provide the DTD via entity resolver
            final InputStream dtdStream = dtdIn;
            builder.setEntityResolver((publicId, systemId) -> new InputSource(dtdStream));

            builder.parse(new InputSource(xmlIn));
            return true;
        } catch (SAXParseException e) {
            log("Validation error: " + e.getMessage(), e);
            return false;
        }
    }

    private void transformXSLT(String xmlPath, String xslPath, OutputStream out) throws Exception {
        try (InputStream xmlIn = getServletContext().getResourceAsStream(xmlPath);
             InputStream xslIn = getServletContext().getResourceAsStream(xslPath)) {
            if (xmlIn == null || xslIn == null) throw new IOException("Example files not found in webapp/examples");

            TransformerFactory tf = TransformerFactory.newInstance();
            Source xsl = new StreamSource(xslIn);
            Transformer transformer = tf.newTransformer(xsl);
            Source xml = new StreamSource(xmlIn);
            StreamResult result = new StreamResult(out);
            transformer.transform(xml, result);
        }
    }

    static class SimpleErrorHandler implements ErrorHandler {
        @Override
        public void warning(SAXParseException exception) throws SAXException {
            System.err.println("Warning: " + exception.getMessage());
            exception.printStackTrace(System.err);
        }

        @Override
        public void error(SAXParseException exception) throws SAXException {
            System.err.println("Error: " + exception.getMessage());
            exception.printStackTrace(System.err);
            throw exception;
        }

        @Override
        public void fatalError(SAXParseException exception) throws SAXException {
            System.err.println("Fatal: " + exception.getMessage());
            exception.printStackTrace(System.err);
            throw exception;
        }
    }
}
