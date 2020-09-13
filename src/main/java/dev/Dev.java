package dev;

import ch.echosystem.website.generator.HTML;
import opendata.RepositoryPage;

public class Dev
	{
	public static void main(String[] args) throws Exception
		{
		//dev();
		
		opendata();
		}
	
	/*
	public static void dev() throws Exception
		{
		final HTML generator = new HTML("templates", false);
		
		//final String html = generator.render("/web/html5.ftlh", new PP());
		final String html = generator.render(new PP());
		
		System.out.println(html);
		}
	*/
	
	public static void opendata() throws Exception
		{
		final HTML generator = new HTML("templates", false);
		
		final String html = generator.render(new RepositoryPage(new Repo()));
		//final String html = generator.render(new IndexPage());
		
		System.out.println(html);
		}
	}
