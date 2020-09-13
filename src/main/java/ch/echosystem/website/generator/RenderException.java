package ch.echosystem.website.generator;

/**
 * @version 0.3.0
 * @since 0.3.0
 */
public class RenderException extends RuntimeException
	{
	/**
	 * @since 0.3.0
	 */
	private static final long serialVersionUID = -1608510599601726082L;
	
	/**
	 * @since 0.3.0
	 */
	public RenderException()
		{
		super();
		}
	
	/**
	 * @since 0.3.0
	 */
	public RenderException(final String message)
		{
		super(message);
		}
	
	/**
	 * @since 0.3.0
	 */
	public RenderException(final Throwable throwable)
		{
		super(throwable);
		}
	}
