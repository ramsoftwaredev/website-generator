package dev;

import ch.echosystem.util.argument.Argument;
import ch.echosystem.util.code.MoveTo;

@Deprecated
@MoveTo("echosystem.util")
public final class Utils
	{
	/*
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
	*/
	
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
	}
