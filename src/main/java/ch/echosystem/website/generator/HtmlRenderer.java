package ch.echosystem.website.generator;

import java.io.IOException;
import java.nio.file.Path;
import freemarker.template.Template;

/**
 * @version 0.3.0
 * @since 0.3.0
 */
public interface HtmlRenderer
	{
	/**
	 * @since 0.3.0
	 */
	public String render(Template template, Object object);
	
	/**
	 * @since 0.3.0
	 */
	public String render(String templateName, Object object);
	
	/**
	 * @since 0.3.0
	 */
	public void render(Template template, Object object, Path path) throws IOException;
	
	/**
	 * @since 0.3.0
	 */
	public String render(Document document);
	}
