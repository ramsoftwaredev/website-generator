package ch.echosystem.website.generator;

import java.nio.file.Paths;

public final class WebSiteGenerator extends FreeMarkerHtmlRenderer
	{
	public WebSiteGenerator()
		{
		super(Paths.get("templates"));
		}
	}
