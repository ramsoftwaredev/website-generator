package ch.echosystem.website.generator;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UncheckedIOException;
import java.nio.file.Path;
import ch.echosystem.util.argument.Argument;
import ch.echosystem.website.generator.exception.RenderException;
import ch.echosystem.website.util.Utils;
import freemarker.core.HTMLOutputFormat;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class FreeMarkerHtmlRenderer implements HtmlRenderer
	{
	/**
	 * @since 0.1.0
	 */
	private final Configuration configuration;
	
	/**
	 * @since 0.1.0
	 */
	public FreeMarkerHtmlRenderer(final Path templatesPath)
		{
		super();
		
		Argument.notNull(templatesPath);
		
		configuration = makeConfiguration(templatesPath, true);
		}
	
	/**
	 * @since 0.1.0
	 */
	@Override
	public String render(final String templateName, final Object object)
		{
		try
			{
			final Template template = configuration.getTemplate(templateName);
			
			try (final StringWriter writer = new StringWriter())
				{
				template.process(object, writer);
				
				return writer.toString();
				}
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		catch (final Exception ex)
			{
			throw new RenderException(ex);
			}
		}
	
	/**
	 * @since 0.1.0
	 */
	private static Configuration makeConfiguration(final Path templatesDirectory, final boolean production)
		{
		final Configuration configuration = new Configuration(Configuration.VERSION_2_3_29);
		
		Utils.wrapIOException(() ->
			{
			configuration.setDirectoryForTemplateLoading(templatesDirectory.toFile());
			});
		
		configuration.setDefaultEncoding("UTF-8");
		
		configuration.setOutputFormat(HTMLOutputFormat.INSTANCE);
		
		configuration.setTemplateExceptionHandler(production ? TemplateExceptionHandler.RETHROW_HANDLER : TemplateExceptionHandler.HTML_DEBUG_HANDLER);
		
		// TODO dev / prod diff ??
		configuration.setLogTemplateExceptions(production ? false : true);
		
		// TODO dev / prod diff ??
		configuration.setWrapUncheckedExceptions(true);
		
		return configuration;
		}
	}
