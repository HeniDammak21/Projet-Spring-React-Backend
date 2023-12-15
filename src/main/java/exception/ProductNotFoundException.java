package exception;

public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(int id) {
		super("could not found the user with the id "+id);
}
}
