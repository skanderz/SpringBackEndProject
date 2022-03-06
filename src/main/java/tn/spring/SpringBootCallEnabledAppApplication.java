package tn.spring;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class SpringBootCallEnabledAppApplication implements ApplicationRunner {

private final static String SID_ACCOUNT = "ACe4d4b9e56e450e35cfb5d9c04d4570a9";
private final static String AUTH_ID = "fe21dbd82cf9589459982bf127d17ffa";
private final static String FROM_NUMBER="+16815395093";
private final static String TO_NUMBER =" +21692557934";

static {
Twilio.init(SID_ACCOUNT, AUTH_ID);
}

public static void main(String[] args) {
SpringApplication.run(SpringBootCallEnabledAppApplication.class, args);
}

@Override
public void run(ApplicationArguments args) throws Exception {
Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
new com.twilio.type.Twiml("<Response><Say>New Publicity </Say></Response>"))
        .create();

}
}
