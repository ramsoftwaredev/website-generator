package ch.echosystem.website.generator;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import freemarker.core.HTMLOutputFormat;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public interface WebComponent extends HtmlRenderer
	{
	/**
	 * @since 0.1.0
	 */
	static final Configuration CONFIGURATION = makeConfiguration(Paths.get("templates"), true);
	
	/**
	 * @since 0.1.0
	 */
	public String getTemplateName();
	
	/**
	 * @since 0.1.0
	 */
	@Override
	default String render() throws IOException, TemplateException
		{
		final Template template = CONFIGURATION.getTemplate(getTemplateName());
		
		try (final StringWriter writer = new StringWriter())
			{
			template.process(this, writer);
			
			return writer.toString();
			}
		}
	
	/**
	 * @since 0.1.0
	 */
	static Configuration makeConfiguration(final Path templatesDirectory, final boolean production)
		{
		try
			{
			final Configuration configuration = new Configuration(Configuration.VERSION_2_3_29);
			
			configuration.setDirectoryForTemplateLoading(templatesDirectory.toFile());
			
			configuration.setDefaultEncoding("UTF-8");
			
			configuration.setOutputFormat(HTMLOutputFormat.INSTANCE);
			
			configuration.setTemplateExceptionHandler(production ? TemplateExceptionHandler.RETHROW_HANDLER : TemplateExceptionHandler.HTML_DEBUG_HANDLER);
			
			// TODO dev / prod diff ??
			configuration.setLogTemplateExceptions(production ? false : true);
			
			// TODO dev / prod diff ??
			configuration.setWrapUncheckedExceptions(true);
			
			return configuration;
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}
	}
