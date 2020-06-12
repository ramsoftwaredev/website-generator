package ch.echosystem.website.generator;

import java.io.IOException;
import freemarker.template.TemplateException;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public interface HtmlRenderer
	{
	/**
	 * @since 0.1.0
	 */
	public String render() throws IOException, TemplateException;
	}
