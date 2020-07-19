package ch.echosystem.website.generator;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public interface WebComponent
	{
	/**
	 * @since 0.1.0
	 */
	public String getTemplateName();
	
	/**
	 * @since 0.1.0
	 */
	public String render();
	}
