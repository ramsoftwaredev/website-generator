package opendata;

import ch.echosystem.website.generator.Content;

public abstract class AbstractRepository implements Content
	{
	public AbstractRepository()
		{
		super();
		}
	
	public String getSource()
		{
		return "AbstractRepository.getSource()";
		}
	
	@Override
	public String getTemplateName()
		{
		return "/opendata/repository.ftlh";
		}
	}
