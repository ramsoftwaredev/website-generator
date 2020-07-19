package dev;

import ch.echosystem.website.generator.AbstractWebPage;

public class Page extends AbstractWebPage
	{
	public Page()
		{
		super("test/page.ftlh", "Page");
		}
	
	public Block getBlock()
		{
		return new Block();
		}
	
	public String getName()
		{
		return "Name";
		}
	
	public String aaaa()
		{
		return "aaaa()";
		}
	}
