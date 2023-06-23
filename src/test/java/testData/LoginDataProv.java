package testData;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

public class LoginDataProv {
    Faker fakeData=new Faker();

    @DataProvider(name = "loginData")
    public Object[][] logD(){
         return new  Object[][]{
                 {fakeData.name().username(),fakeData.internet().password()},
                 {fakeData.name().username(),fakeData.internet().password()},
                 {fakeData.name().username(),fakeData.internet().password()},
                 {fakeData.name().username(),fakeData.internet().password()}

        };

    }
}
