package emlakburada.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

	private String email;
	private String password;

	public AuthRequest(String email){
		this.email=email;
	}

}
