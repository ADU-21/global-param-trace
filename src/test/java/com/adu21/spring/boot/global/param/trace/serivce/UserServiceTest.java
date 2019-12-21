package com.adu21.spring.boot.global.param.trace.serivce;

import java.util.concurrent.ExecutionException;

import com.adu21.spring.boot.global.param.trace.context.AppContext;
import com.adu21.spring.boot.global.param.trace.model.User;
import com.adu21.spring.boot.global.param.trace.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(AppContext.class)
public class UserServiceTest {

    private static final long CONTEXT_USER_ID = 123L;
    private static final String CONTEXT_TRACE_ID = "trace-id";
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        AppContext context = new AppContext();
        context.setTraceId(CONTEXT_TRACE_ID);
        context.setUserId(CONTEXT_USER_ID);
        PowerMockito.mockStatic(AppContext.class);
        BDDMockito.given(AppContext.getContext()).willReturn(context);
    }

    @Test
    public void shouldReturnUserWhenUserIdInContext() throws ExecutionException, InterruptedException {
        // given
        when(userRepository.getUserById(eq(CONTEXT_USER_ID))).thenReturn(new User(CONTEXT_USER_ID, "userName"));

        // when
        User user = userService.getCurrentUser();

        // then
        Assert.assertEquals(Long.valueOf(123), user.getId());
        Assert.assertEquals("userName", user.getName());
    }
}