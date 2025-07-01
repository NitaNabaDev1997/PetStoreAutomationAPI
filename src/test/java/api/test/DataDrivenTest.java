package api.test;

import api.endpoints.Endpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {

    @Test(priority = 1,dataProvider = "Data",dataProviderClass = DataProviders.class)
    public  void testPostUser(String userid, String username, String fname, String lastname,String email, String pass, String phn)
    {
        User userPayload= new User();

        userPayload.setId(Integer.parseInt(userid));
        userPayload.setUsername(username);
        userPayload.setFirstname(fname);
        userPayload.setLastname(lastname);
        userPayload.setEmail(email);
        userPayload.setPassword(pass);
        userPayload.setPhone(phn);

       Response response= Endpoints.createUser(userPayload);
        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test(priority = 2,dataProvider = "getUserName",dataProviderClass = DataProviders.class)
    public void testDeleteUserByName(String username)
    {
        Response response=Endpoints.DeleteUser(username);

        Assert.assertEquals(response.getStatusCode(),200);
    }
}
