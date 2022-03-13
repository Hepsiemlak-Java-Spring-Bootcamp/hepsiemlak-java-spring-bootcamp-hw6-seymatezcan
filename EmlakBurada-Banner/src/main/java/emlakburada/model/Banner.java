package emlakburada.model;

import lombok.*;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Banner {

	private int advertNo;
	private String phone;
	private int total;
	private Address address;


}
