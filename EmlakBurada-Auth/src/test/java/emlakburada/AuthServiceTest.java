package emlakburada;

import emlakburada.dto.AuthRequest;
import emlakburada.dto.AuthResponse;
import emlakburada.entity.User;
import emlakburada.repository.AuthRepository;
import emlakburada.service.AuthService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class AuthServiceTest {

    @InjectMocks
    AuthService authService;

    @Mock
    private AuthRepository authRepository;

    @Test
    void getTokenTest(){

        AuthRequest authRequest = prepareAuthRequest();
        Optional<User> user = Optional.of(prepareUser());
        Mockito.when(authRepository.findByEmail(authRequest.getEmail())).thenReturn(user);
        assertDoesNotThrow(() -> {
            AuthResponse response = authService.getToken(authRequest);
            assertEquals("email", response.getToken());
            verify(authService).getToken(any());
            assertEquals("password",response.getToken());
            verify(authService.getToken(any()));

        });
    }

    private AuthRequest prepareAuthRequest() {
        AuthRequest authRequest=new AuthRequest();
        authRequest.setEmail("patika.dev@welcome");
        authRequest.setPassword("ABC123");
        return authRequest;
    }

    private User prepareUser() {

        User user = new User("user@welcome");
        return user;
    }

    private List<String> prepareEmailList() {
        List<String> userEmails=new ArrayList<>();
        userEmails.add("seyma.welcome@patika");
        userEmails.add("seyma.hello@patika");
        return userEmails;
    }
}
