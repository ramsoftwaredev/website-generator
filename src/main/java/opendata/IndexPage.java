package opendata;

public final class IndexPage extends AbstractRepositoryPage<Folder>
	{
	public IndexPage()
		{
		super();
		
		title = "INDEX";
		
		content = new Folder();
		}
	}
