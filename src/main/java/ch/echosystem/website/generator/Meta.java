package ch.echosystem.website.generator;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * @version 0.3.0
 * @since 0.3.0
 */
public final class Meta
	{
	/**
	 * @since 0.3.0
	 */
	private Charset charset = StandardCharsets.UTF_8;
	
	/**
	 * @since 0.3.0
	 */
	private Locale locale;
	
	/**
	 * @since 0.3.0
	 */
	public Meta()
		{
		super();
		}
	
	/**
	 * @since 0.3.0
	 */
	public Charset getCharset()
		{
		return charset;
		}
	
	/**
	 * @since 0.3.0
	 */
	public void setCharset(final Charset charset)
		{
		this.charset = charset;
		}
	
	/**
	 * @since 0.3.0
	 */
	public Locale getLocale()
		{
		return locale;
		}
	
	/**
	 * @since 0.3.0
	 */
	public void setLocale(final Locale locale)
		{
		this.locale = locale;
		}
	}
