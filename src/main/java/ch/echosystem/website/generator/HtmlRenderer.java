package ch.echosystem.website.generator;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public interface HtmlRenderer
	{
	/**
	 * @since 0.1.0
	 */
	public String render(String templateName, Object object);
	}
