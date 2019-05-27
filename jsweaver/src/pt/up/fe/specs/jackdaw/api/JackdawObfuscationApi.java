package pt.up.fe.specs.jackdaw.api;

import org.lara.interpreter.weaver.utils.LaraResourceProvider;

public enum JackdawObfuscationApi implements LaraResourceProvider {

	OPAQUE("OpaquePredicates.lara"),
	OBFUSCATOR("Obfuscator.lara"),
	FLATTED("Flatted.lara");

	private final String resource;

	private static final String WEAVER_PACKAGE = "jackdaw/";
	private static final String BASE_PACKAGE = "obfuscation/";

	/**
	 * @param resource
	 */
	private JackdawObfuscationApi(String resource) {
		this.resource = WEAVER_PACKAGE + getSeparatorChar() + BASE_PACKAGE + resource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.suikasoft.SharedLibrary.Interfaces.ResourceProvider#getResource()
	 */
	@Override
	public String getOriginalResource() {
		return resource;
	}
}
