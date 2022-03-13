package emlakburada.service;

import java.util.ArrayList;
import java.util.List;

import emlakburada.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakburada.dto.request.BannerRequest;
import emlakburada.dto.response.BannerResponse;
import emlakburada.model.Banner;
import lombok.extern.slf4j.Slf4j;

@Service
public class BannerService {

	@Autowired
	private BannerRepository repository;


	public List<BannerResponse> getAllBanners() {
		List<BannerResponse> bannerResponses = new ArrayList<>();
		for (Banner banner : repository.findAll()) {
			bannerResponses.add(convertToBannerResponse(banner));
		}
		return bannerResponses;
	}

	public BannerResponse saveBanner(BannerRequest request) {
		Banner banner=repository.save(convertToBanner(request));
		return convertToBannerResponse(banner);
	}

	private BannerResponse convertToBannerResponse(Banner banner) {
		BannerResponse response = new BannerResponse();
		response.setAdvertNo(banner.getAdvertNo());
		response.setPhone(banner.getPhone());
		response.setTotal(banner.getTotal());
		return response;
	}

	private Banner convertToBanner(BannerRequest request) {
		Banner banner = new Banner();
		banner.setAdvertNo(request.getAdvertNo());
		banner.setPhone(request.getPhone());
		banner.setTotal(request.getTotal());
		return banner;
	}

}
