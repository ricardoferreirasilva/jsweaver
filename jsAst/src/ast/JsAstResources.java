package ast;

import pt.up.fe.specs.util.providers.ResourceProvider;

public enum JsAstResources implements ResourceProvider {

    ESPRIMA("esprima/esprima.js"),
    ESPRIMA_WALK("esprima/esprima-walk.js"),
    ESCODEGEN("esprima/escodegen.browser.js"),
    PARSE_JAVASCRIPT("javascript/parseJavascript.js"),
    GENERATE_JAVASCRIPT("javascript/generateJavascript.js");

    // private final WebResourceProvider webResource;
    private final String resource;

    /**
     * @param resource
     */
    private JsAstResources(String resource) {
        this.resource = resource;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.suikasoft.SharedLibrary.Interfaces.ResourceProvider#getResource()
     */
    @Override
    public String getResource() {
        return resource;
    }

}
