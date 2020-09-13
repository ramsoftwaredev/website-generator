package opendata;

public final class RepositoryPage extends AbstractRepositoryPage<AbstractRepository>
	{
	public RepositoryPage(final AbstractRepository repository)
		{
		super();
		
		title = "REPO";
		
		content = repository;
		}
	
	public AbstractRepository getRepository()
		{
		return content;
		}
	}
