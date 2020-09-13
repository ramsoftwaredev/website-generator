package ch.echosystem.website.generator;

import ch.echosystem.schema.org.annotation.WebPage;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
@WebPage
public abstract class Page<T extends Content> implements Document
	{
	private final String templateName;
	
	//@Property(Thing.name)
	protected String title;
	
	//@Property(WebPage.mainContentOfPage)
	protected T content;
	
	protected final Meta meta = new Meta();
	
	protected final Head head = new Head();
	
	public Page(final String templateName)
		{
		super();
		
		this.templateName = templateName;
		}
	
	@Override
	public final String getTemplateName()
		{
		return templateName;
		}
	
	public final String getTitle()
		{
		return title;
		}
	
	public final T getContent()
		{
		return content;
		}
	
	public final Meta getMeta()
		{
		return meta;
		}
	
	public final Head getHead()
		{
		return head;
		}
	}
