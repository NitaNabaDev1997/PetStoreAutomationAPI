package api.test;

import api.endpoints.Endpoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class UserTests {

    Faker faker;
    User userPayload;

    public Logger logger;
    @BeforeClass
    public void setUpData()
    {
        faker= new Faker();
        userPayload= new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstname(faker.name().firstName());
        userPayload.setLastname(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password());
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        //logs
        logger= LogManager.getLogger(this.getClass());

        logger.debug("debugging.....");

    }

    @Test(priority = 1)
    public void testPostUser()
    {
        Response response=Endpoints.createUser(userPayload);
        response.then().log().all();


        Assert.assertEquals(response.getStatusCode(),200);
        //Assert.assertEquals();
    }

    @Test(priority = 2)
    public void testGetUser()
    {
        Response response=Endpoints.readUser(this.userPayload.getUsername());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 3)
    public void testUpdateUserByname()
    {

        userPayload.setFirstname(faker.name().firstName());
        userPayload.setLastname(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());


        Response response=Endpoints.UpdateUser(this.userPayload.getUsername(),userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }


    @Test(priority = 4)
    public void testDeleteUserByName()
    {
        Response response=Endpoints.DeleteUser(this.userPayload.getUsername());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }
}
