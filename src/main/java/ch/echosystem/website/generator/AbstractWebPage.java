package ch.echosystem.website.generator;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public abstract class AbstractWebPage extends AbstractWebComponent implements WebPage
	{
	/**
	 * @since 0.1.0
	 */
	protected String title;
	
	/**
	 * @since 0.1.0
	 */
	public AbstractWebPage(final String templateName, final String title)
		{
		super(templateName);
		
		this.title = title;
		}
	
	/**
	 * @since 0.1.0
	 */
	@Override
	public String getTitle()
		{
		return title;
		}
	}
