package ch.echosystem.website.generator.exception;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public class RenderException extends RuntimeException
	{
	/**
	 * @since 0.1.0
	 */
	private static final long serialVersionUID = -1608510599601726082L;
	
	/**
	 * @since 0.1.0
	 */
	public RenderException()
		{
		super();
		}
	
	/**
	 * @since 0.1.0
	 */
	public RenderException(final String message)
		{
		super(message);
		}
	
	/**
	 * @since 0.1.0
	 */
	public RenderException(final Throwable throwable)
		{
		super(throwable);
		}
	}
