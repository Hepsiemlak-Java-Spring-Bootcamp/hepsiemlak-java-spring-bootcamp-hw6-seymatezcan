package emlakburada;

import emlakburada.dto.request.BannerRequest;
import emlakburada.dto.response.BannerResponse;
import emlakburada.repository.BannerRepository;
import emlakburada.service.BannerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.Banner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class BannerServiceTest {

    @InjectMocks
    BannerService bannerService;

    @Mock
    private BannerRepository bannerRepository;

    @Test()
    @DisplayName("when advert not found throw exception. "
            + "method name can be: should_throw_exception_when_advert_not_found")
    void saveBannerWithoutAdvertTest() {

        assertThrows(Exception.class, () -> {
            bannerService.saveBanner(prepareBannerRequest());
        }, "Banner cannot created.");

    }

    @Test
    void saveBannerWithAdvertTest() throws Exception{
        BannerRequest bannerRequest=prepareBannerRequest();
        Optional<Banner> banner = Optional.of(prepareBanner());

        Mockito.when(bannerRepository.save(any()))
                .thenReturn(prepareBanner());

        BannerResponse bannerResponse = bannerService.saveBanner(bannerRequest);
        assertEquals("myBannerAddress", bannerResponse.getAddress());
        verify(bannerService).saveBanner(any());
    }

    @Test
    void getAllAdvertsTest() {
        // when
        // given
        // verify

        Mockito.when(bannerRepository.findAll())
                .thenReturn(prepareBannerList());

        List<BannerResponse> responseList = bannerService.getAllBanners();

        assertNotEquals(0, responseList.size());

        assertThat(responseList.size()).isNotZero();

        for (BannerResponse response : responseList) {
            assertThat(response.getAdvertNo()).isEqualTo(0);

        }

    }

    private List<Banner> prepareBannerList() {
        List<Banner> banners = new ArrayList<Banner>();
        banners.add(prepareBanner());
        return banners;
    }

    private Banner prepareBanner() {
      return (Banner) new BannerRequest(5,"5568974125",2,"address");

    }

    private BannerRequest prepareBannerRequest() {
        BannerRequest bannerRequest=new BannerRequest();
        bannerRequest.setAddress("address2");
        bannerRequest.setAdvertNo(5);
        bannerRequest.setPhone("5689452141");
        bannerRequest.setTotal(1);
        return bannerRequest;

    }


}
