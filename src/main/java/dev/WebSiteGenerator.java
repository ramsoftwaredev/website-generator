package dev;

import java.io.IOException;

import ch.echosystem.website.generator.HTML;

public class WebSiteGenerator extends HTML
	{
	public WebSiteGenerator() throws IOException
		{
		super("templates", true);
		}
	
	/*
	public WebSiteGenerator(final String templatesDirectory)
		{
		super(null);
		
		throw new UnsupportedOperationException();
		}
	
	public WebSiteGenerator(final String... templatesDirectories)
		{
		super(null);
		
		throw new UnsupportedOperationException();
		}
	*/
	}
