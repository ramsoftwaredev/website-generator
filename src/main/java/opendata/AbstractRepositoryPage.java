package opendata;

import java.util.Locale;
import ch.echosystem.website.generator.Content;
import ch.echosystem.website.generator.Page;

public abstract class AbstractRepositoryPage<T extends Content> extends Page<T>
	{
	public AbstractRepositoryPage()
		{
		super("/web/html5.ftlh");
		
		meta.setLocale(Locale.FRENCH);
		}
	}
