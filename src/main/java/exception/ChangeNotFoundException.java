package exception;

public class ChangeNotFoundException extends RuntimeException {
	public ChangeNotFoundException(int id) {
		super("could not found the change with the id "+id);
	}
	}
