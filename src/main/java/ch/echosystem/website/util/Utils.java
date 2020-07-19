package ch.echosystem.website.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import org.apache.commons.io.IOUtils;
import ch.echosystem.util.argument.Argument;

public final class Utils
	{
	@FunctionalInterface
	public interface Wrapper
		{
		public void execute() throws IOException;
		}
	
	@FunctionalInterface
	public interface WrapperReturnValue<T>
		{
		public T execute() throws IOException;
		}
	
	private Utils()
		{
		throw new UnsupportedOperationException();
		}
	
	public static Properties getProperties(final String name)
		{
		final String content = wrapIOException(() ->
			{
			return IOUtils.resourceToString(name, StandardCharsets.ISO_8859_1);
			});
		
		try (final StringReader reader = new StringReader(content))
			{
			final Properties properties = new Properties();
			
			wrapIOException(() ->
				{
				properties.load(reader);
				});
			
			return properties;
			}
		}
	
	public static Object newInstanceOf(final String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException
		{
		Argument.notNull(className);
		
		return Class.forName(className).newInstance();
		}
	
	public static <T> T newInstanceOf(final String className, final Class<T> classOfT) throws ClassNotFoundException, InstantiationException, IllegalAccessException
		{
		Argument.notNull(classOfT);
		
		return classOfT.cast(newInstanceOf(className));
		}
	
	public static void wrapIOException(final Wrapper wrapper)
		{
		try
			{
			wrapper.execute();
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}
	
	public static <T> T wrapIOException(final WrapperReturnValue<T> wrapper)
		{
		try
			{
			return wrapper.execute();
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}
	}
