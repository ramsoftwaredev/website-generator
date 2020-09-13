package opendata;

import ch.echosystem.website.generator.Content;

public class Folder implements Content
	{
	public Folder()
		{
		super();
		}
	
	@Override
	public String getTemplateName()
		{
		return "/opendata/index.ftlh";
		}
	}
