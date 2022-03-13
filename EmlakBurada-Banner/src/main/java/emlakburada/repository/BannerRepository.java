package emlakburada.repository;

import org.springframework.boot.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BannerRepository extends JpaRepository<Banner,Integer> {

}
