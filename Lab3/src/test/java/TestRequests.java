import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestRequests {

    public static final String APIURL = "https://en.wikipedia.org/w/api.php?";

    @Test
    public void   testGETSearchForATitleOrTextInAWikiRequest(){

        given()
                .get(APIURL+"action=query&list=search&srsearch=SPbPU&utf8=&format=json&srlimit=2")
                .then()
                .statusCode(200)
                .body("query.searchinfo.totalhits", equalTo(14))
                .body("query.search.title", hasItems("Peter the Great St. Petersburg Polytechnic University", "Kirill Prigoda"));
                //.log.all()
    }

    @Test
    public void   testGETCategoriesAssociatedWithAPageRequest(){

        given()
                .get(APIURL+"action=query&format=json&prop=categories&titles=Peter_the_Great_St._Petersburg_Polytechnic_University")
                .then()
                .statusCode(200)
                .body("query.normalized.from[0]", equalTo("Peter_the_Great_St._Petersburg_Polytechnic_University"))
                .body("query.normalized.to[0]", equalTo("Peter the Great St. Petersburg Polytechnic University"))
                .body("query.pages.6258161.title", equalTo("Peter the Great St. Petersburg Polytechnic University"))
                .body("query.pages.6258161.categories.title", hasItems("Category:1899 establishments in the Russian Empire",
                        "Category:Educational institutions established in 1899",
                        "Category:Engineering universities and colleges in Russia"));
                //.log.all()
    }

    @Test
    public void   testExamplePOSTRequest(){

        JSONObject request = new JSONObject();
        request.put("email", "mytestmail@mail.ru");
        request.put("password", "somepassword@mail.ru");

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .statusCode(400)
                .body("error", equalTo("Note: Only defined users succeed registration"));
    }

}
