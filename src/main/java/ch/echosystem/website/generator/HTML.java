package ch.echosystem.website.generator;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import ch.echosystem.util.argument.Argument;
import ch.echosystem.util.code.Good;
import ch.echosystem.util.io.IO;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * @version 0.3.0
 * @since 0.3.0
 */
@Good
public class HTML extends IO implements HtmlRenderer
	{
	/**
	 * @since 0.3.0
	 */
	private final Configuration configuration;
	
	/*
	@SuppressWarnings("unused")
	private HTML()
		{
		throw new UnsupportedOperationException();
		}
	
	public HTML(final boolean production) throws IOException
		{
		this("templates", production);
		}
	*/
	
	/**
	 * @since 0.3.0
	 */
	public HTML(final File templatesDirectory, final boolean production)
		{
		super();
		
		configuration = makeConfiguration(production);
		
		try
			{
			configuration.setDirectoryForTemplateLoading(templatesDirectory);
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}
	
	/**
	 * @since 0.3.0
	 */
	public HTML(final String templatesDirectory, final boolean production)
		{
		this(new File(notNull(templatesDirectory)), production);
		}
	
	/**
	 * @since 0.3.0
	 */
	public HTML(final Path templatesDirectory, final boolean production)
		{
		this(notNull(templatesDirectory).toFile(), production);
		}
	
	/**
	 * @since 0.3.0
	 */
	public final Configuration getConfiguration()
		{
		return configuration;
		}
	
	/**
	 * @since 0.3.0
	 */
	@Override
	public final String render(final Template template, final Object object)
		{
		notNull(template);
		notNull(object);
		
		try
			{
			try (final Writer writer = new StringWriter())
				{
				template.process(object, writer);
				
				return writer.toString();
				}
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		catch (final TemplateException ex)
			{
			throw new RenderException();
			}
		}
	
	/**
	 * @since 0.3.0
	 */
	@Override
	public final String render(final String templateName, final Object object)
		{
		notNull(templateName);
		
		try
			{
			return render(configuration.getTemplate(templateName), object);
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}
	
	/**
	 * @since 0.3.0
	 */
	@Override
	public final void render(final Template template, final Object object, final Path path) throws IOException
		{
		notNull(path);
		
		writeString(path, render(template, object));
		}
	
	@Override
	public final String render(final Document document)
		{
		notNull(document);
		
		return render(document.getTemplateName(), document);
		}
	
	/**
	 * @since 0.3.0
	 */
	@SuppressWarnings("unused")
	private static TemplateLoader makeTemplateLoader(final String... templatesDirectories) throws IOException
		{
		Argument.notNull(templatesDirectories);
		
		final List<TemplateLoader> loaders = new ArrayList<>();
		
		for (final String templatesDirectory : templatesDirectories)
			{
			loaders.add(new FileTemplateLoader(new File(templatesDirectory)));
			}
		
		return new MultiTemplateLoader(loaders.toArray(new TemplateLoader[0]));
		}
	
	/**
	 * @since 0.3.0
	 */
	private static final Configuration makeConfiguration(final boolean production)
		{
		final Configuration configuration = new Configuration(Configuration.VERSION_2_3_29);
		
		configuration.setDefaultEncoding("UTF-8");
		
		configuration.setTemplateExceptionHandler(production ? TemplateExceptionHandler.RETHROW_HANDLER : TemplateExceptionHandler.HTML_DEBUG_HANDLER);
		
		configuration.setLogTemplateExceptions(production ? false : true);
		
		configuration.setWrapUncheckedExceptions(true);
		
		configuration.setFallbackOnNullLoopVariable(false);
		
		return configuration;
		}
	}
