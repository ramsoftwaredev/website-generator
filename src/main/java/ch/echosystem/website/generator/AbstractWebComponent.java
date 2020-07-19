package ch.echosystem.website.generator;

import ch.echosystem.util.argument.Argument;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public abstract class AbstractWebComponent implements WebComponent
	{
	/**
	 * @since 0.1.0
	 */
	public static HtmlRenderer renderer = null;
	
	/**
	 * @since 0.1.0
	 */
	protected final String templateName;
	
	/**
	 * @since 0.1.0
	 */
	public AbstractWebComponent(final String templateName)
		{
		super();
		
		Argument.notNull(templateName);
		
		this.templateName = templateName;
		}
	
	/**
	 * @since 0.1.0
	 */
	@Override
	public String getTemplateName()
		{
		return templateName;
		}
	
	/**
	 * @since 0.1.0
	 */
	@Override
	public String render()
		{
		return renderer.render(getTemplateName(), this);
		}
	}
