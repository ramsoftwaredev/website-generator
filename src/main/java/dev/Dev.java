package dev;

import java.util.Properties;
import ch.echosystem.website.generator.AbstractWebComponent;
import ch.echosystem.website.generator.HtmlRenderer;
import ch.echosystem.website.generator.WebSiteGenerator;
import ch.echosystem.website.util.Utils;

public class Dev
	{
	public static void main(String[] args)
		{
		dev();
		
		final Properties properties = Utils.getProperties("/config.properties");
		
		System.out.println(properties.getProperty("sdsd"));
		}
	
	public static void dev()
		{
		final WebSiteGenerator generator = new WebSiteGenerator();
		
		AbstractWebComponent.renderer = (HtmlRenderer) generator;
		
		final String html = new Page().render();
		
		System.out.println(html);
		}
	}
