package opendata;

public final class OpenDataRepository // TODO extends WebSiteGenerator
	{
	public OpenDataRepository()
		{
		super();
		}
	
	public void update()
		{
		// Download last data
		// Update local data
		}
	
	public void publish()
		{
		// Format local data
		// Generate HTML
		// Publish FTP (synchronize)
		}
	
	public static void main(final String[] args)
		{
		/*
		final WebSiteGenerator generator = new WebSiteGenerator();
		
		AbstractWebComponent.renderer = (HtmlRenderer) generator;
		
		final Repository repository = new Repository("REP");
		
		final RepositoryWebPage page = new RepositoryWebPage(repository);
		
		final String html = page.render();
		
		System.out.println(html);
		*/
		}
	}
