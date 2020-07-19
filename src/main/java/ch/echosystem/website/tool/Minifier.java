package ch.echosystem.website.tool;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.jsoup.UncheckedIOException;
import ch.echosystem.downloader.TextDownloader;

public final class Minifier implements TextDownloader
	{
	private Minifier()
		{
		super();
		}
	
	public static void css()
		{
		}
	
	public static String js(final Path path)
		{
		try
			{
			return new Minifier().post("https://javascript-minifier.com/raw", makeParameters("input", path));
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}
	
	private static Map<String, String> makeParameters(final String name, final Path path) throws IOException
		{
		final Map<String, String> parameters = new HashMap<>();
		
		parameters.put("input", FileUtils.readFileToString(path.toFile(), StandardCharsets.UTF_8));
		
		return parameters;
		}
	}
