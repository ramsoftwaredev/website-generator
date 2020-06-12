import ch.echosystem.website.generator.WebPage;

public class Dev
	{
	public static void main(String[] args) throws Exception
		{
		dev();
		}
	
	public static void dev() throws Exception
		{
		final WebPage page = new WebPage()
			{
			@Override
			public String getTemplateName()
				{
				return "page.ftlh";
				}
			
			@Override
			public String getTitle()
				{
				return "OK";
				}
			};
		
		final String html = page.render();
		
		System.out.println(html);
		}
	}
