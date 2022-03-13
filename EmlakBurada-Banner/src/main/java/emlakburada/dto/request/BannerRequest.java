package emlakburada.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BannerRequest {
	
	private int advertNo;
	private String phone;
	private int total;
	private String address;

	//public void setAddress(String address) {
	//}
}
