package TRMS.P1.service;

public interface AuthorizationService {
	
	public int authenticatedUser(String username, String password);

	public String createToken(int employee_id);

	public String validateToken(String token);

}
