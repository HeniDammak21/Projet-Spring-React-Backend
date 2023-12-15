package exception;

public class CategoryNotFoundException extends RuntimeException {
public CategoryNotFoundException(int id) {
	super("could not found the user with the id "+id);
}
}
