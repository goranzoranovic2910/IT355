package com.metropolitan.DZ13;

import com.metropolitan.configuration.SecurityConfiguration;
import com.metropolitan.configuration.WebMvcConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes={Dz13Application.class, SecurityConfiguration.class, WebMvcConfig.class })
public class Dz13ApplicationTests {

    @Test 
    public void encoder(){
        BCryptPasswordEncoder e = new BCryptPasswordEncoder();
        String s = e.encode("GORAN");
        System.out.println(s);
    }
    
    @Test
    public void contextLoads() {
    }
        
        

}
